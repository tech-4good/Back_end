# Relatório de Controles de Segurança (Evidências OWASP Top 10)

## 0. Metodologia e Escopo
Este relatório identifica e analisa 4 riscos do OWASP Top 10 aplicáveis ao backend (Spring Boot) desta API. Para cada item foram verificados: código-fonte, configuração de segurança, uso de frameworks (Spring Security, Spring Data JPA) e padrões de projeto. Mesmo quando a mitigação é provida indiretamente pelo framework, o mecanismo técnico interno é descrito (não apenas "o Spring trata").

### Itens Selecionados
1. A01 – Broken Access Control  
2. A02 – Cryptographic Failures  
3. A03 – Injection  
4. A07 – Identification and Authentication Failures  

Critério de escolha: itens com superfície clara no código atual (camada de segurança, autenticação JWT, persistência JPA) e impacto direto sobre confidencialidade e integridade de dados sensíveis (beneficiados, voluntários, endereços, documentos).

---
## 1. A01 – Broken Access Control
### Descrição Sintética (OWASP)
Falhas que permitem a usuários não autorizados executar ações ou acessar dados além de suas permissões.

### Cenário de Risco na Aplicação
A API expõe endpoints para gestão de beneficiados, endereços, cestas, entregas e arquivos. Sem controle adequado, um cliente anônimo poderia ler, alterar ou enumerar dados pessoais (CPF, endereço, renda), violando princípios de minimização e LGPD.

### Implementação / Tratamento
O controle principal ocorre no bean `SecurityFilterChain` (classe `SecurityConfiguracao`). A DSL de configuração declara explicitamente padrões de URL que:
- São liberados (`permitAll()`) apenas para autenticação, documentação e recursos públicos.
- Exigem autenticação para domínios sensíveis (beneficiados, entregas, etc.).

O Spring Security, ao construir a cadeia de filtros, associa um `AuthorizationFilter` que consulta a matriz de ant matchers configurada. Para cada requisição:
1. A resolução do matcher é feita em ordem; a primeira correspondência é aplicada.  
2. Se a rota exige autenticação, verifica-se a presença de um `Authentication` válido no `SecurityContext`.  
3. Caso ausente, responde-se 401 (ou 403 dependendo do contexto) via `AutenticacaoEntryPoint`.

### Evidência de Código
```java
.authorizeHttpRequests(auth -> auth
  .requestMatchers(URLS_PERMITIDAS).permitAll()
  .requestMatchers(HttpMethod.POST, "/voluntarios", "/voluntarios/login").permitAll()
  .requestMatchers(
     "/voluntarios/**", "/beneficiados/**", "/enderecos/**", 
     "/cestas/**", "/auxilio-governamentais/**", "/filhos-beneficiados/**",
     "/tipo-moradores/**", "/files/**", "/fila-espera/**", "/entregas/**",
     "/beneficiado-has-auxilios/**"
  ).authenticated()
  .anyRequest().authenticated()
)
.sessionManagement(m -> m.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
```

### Como o Framework Mitiga (Detalhe Técnico)
- A resolução de autorização usa `RequestMatcher` e avalia `AntPathRequestMatcher` internamente, evitando erros de comparação manual de path.
- A política `STATELESS` impede criação de sessão Http (sem `JSESSIONID`), reduz vetores de fixation/hijacking.
- A ausência de sessão força cada requisição autenticada a apresentar JWT válido (controle consistente).

### Limitações e Riscos Remanescentes
- Não há diferenciação de papéis (roles) — todos os usuários autenticados parecem ter o mesmo escopo.
- Falta enforcement de autorização a nível de método (`@PreAuthorize`) para cenários futuros de lógica condicional (ex.: acesso apenas a seu próprio registro).
- `h2-console` liberado pode expor metadados se não filtrado em produção.

### Recomendações
1. Introduzir roles (ex.: `ROLE_ADMIN`, `ROLE_VOLUNTARIO`) e uso de `.hasRole()` ou anotações em métodos de serviço.  
2. Remover ou proteger `h2-console` em ambientes não-dev.  
3. Implementar verificação de propriedade de recurso (ex.: usuário só altera seu perfil) via camada de serviço + `@PreAuthorize("#id == authentication.principal.id")` quando aplicável.  
4. Adicionar política de CORS restritiva por ambiente (`allowedOrigins` explícitos).

---
## 2. A02 – Cryptographic Failures
### Descrição Sintética (OWASP)
Falhas relacionadas a armazenamento, transmissão ou uso incorreto de primitivas criptográficas, expondo dados sensíveis.

### Cenário de Risco na Aplicação
Armazenamento de senhas de voluntários e emissão de tokens de acesso. Senhas em claro ou hashing fraco permitiriam comprometimento em caso de vazamento. Tokens sem assinatura ou sem expiração poderiam ser replicados indefinidamente.

### Implementação / Tratamento
1. Hash de senha: Bean `PasswordEncoder` configurado com `BCryptPasswordEncoder`. Cada senha:
   - Recebe salt aleatório embutido (gerado internamente a cada hash).
   - Usa fator de custo default (10 se não definido) que torna brute force mais caro.
2. Emissão de JWT: Classe `GerenciadorTokenJwt` gera token com:
   - Subject = username.  
   - `issuedAt` e `expiration` calculados usando `jwt.validity` (valor externo configurável).  
   - Assinatura HMAC SHA (derivada de `Keys.hmacShaKeyFor(secretBytes)`).
3. Validação: O parser (`Jwts.parserBuilder().setSigningKey(...)`) valida integridade e expiração; token adulterado ou expirado lança exceção (`ExpiredJwtException`).

### Evidência de Código
```java
@Bean
public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }
```
```java
return Jwts.builder()
  .setSubject(authentication.getName())
  .signWith(parseSecret())
  .setIssuedAt(new Date(System.currentTimeMillis()))
  .setExpiration(new Date(System.currentTimeMillis() + jwtTokenValidity * 1000))
  .compact();
```
```java
private SecretKey parseSecret() {
  return Keys.hmacShaKeyFor(this.secret.getBytes(StandardCharsets.UTF_8));
}
```

### Como o Framework / Biblioteca Mitiga (Detalhe Técnico)
- BCrypt incorpora salt aleatório por hash e custo configurável; isso invalida pré-computação (rainbow tables) e desacelera brute force.
- A biblioteca JJWT constrói header + payload + assinatura; na validação recalcula HMAC e compara (constant time comparision na implementação interna do JJWT/Java Crypto) — tokens adulterados falham imediatamente.
- A verificação de expiração compara `exp` com `System.currentTimeMillis()` garantindo invalidação temporal.

### Limitações e Riscos Remanescentes
- Fator de custo do BCrypt não explicitado (pode ficar defasado ao longo do tempo).  
- Chave JWT possivelmente definida em `application.properties` — risco se commit inadvertido em VCS.  
- Não há rotação de chaves (ausência de `kid` no header impede migração suave).  
- Nenhum claim adicional (ex.: roles) para validação contextual de autorização.

### Recomendações
1. Externalizar segredo em secret manager (Vault, AWS Secrets Manager, etc.).  
2. Definir custo explícito (ex.: 12 ou 14) e política de revisão anual.  
3. Implementar rotação: inserir `kid`, manter chave ativa e chave dephase até expiração de tokens antigos.  
4. Adicionar claims de autoridade minimizando round-trips ao banco (garantindo still valid via versioning se necessário).  
5. Considerar refresh token separado com revogação/tenant tracking.

---
## 3. A03 – Injection
### Descrição Sintética (OWASP)
Entrada não confiável interpretada como comando ou query, permitindo manipular consultas ou execução arbitrária.

### Cenário de Risco na Aplicação
Entradas como CPF, IDs de beneficiados e parâmetros de busca poderiam, se interpolados em consultas SQL dinâmicas, vazar dados sensíveis ou corromper integridade das tabelas.

### Implementação / Tratamento
A aplicação utiliza Spring Data JPA (interfaces `JpaRepository`), delegando a construção de consultas a um provedor ORM (provavelmente Hibernate). Métodos derivados como `findByCpf` e `existsByCpf` geram consultas parametrizadas (Prepared Statements) com binding indexado. Esse binding impede que conteúdo de entrada seja interpretado como parte da sintaxe SQL.

### Evidência de Código
```java
public interface BeneficiadoJpaRepository extends JpaRepository<BeneficiadoEntity, Integer> {
  boolean existsByCpf(String cpf);
  Optional<BeneficiadoEntity> findByCpf(String cpf);
}
```

### Como o Framework Mitiga (Detalhe Técnico)
- O Spring Data analisa o nome do método (`findByCpf`) e gera uma JPQL do tipo `select e from Beneficiado e where e.cpf = ?1`.
- O provedor (Hibernate) converte para SQL nativo com placeholders (`?`).
- Parâmetros são enviados através de API JDBC (`PreparedStatement#setString`), evitando concatenação.
- O driver JDBC realiza o parsing antes da inserção de valores, tornando payload de entrada incapaz de alterar a estrutura da query.

### Limitações e Riscos Remanescentes
- Ausência de validação de formato para CPF permite payloads anômalos (embora não injetem SQL, podem gerar ruído ou exploração de lógica).  
- Possíveis queries nativas (não analisadas aqui) representariam risco se adicionadas sem parâmetros.  
- Falta de limites de tamanho em campos pode afetar performance ou facilitar ataques de negação (payloads muito grandes).

### Recomendações
1. Implementar validação de formato (regex CPF) antes do acesso ao repositório.  
2. Definir restrições de tamanho (`@Column(length=...)`, Bean Validation `@Size`).  
3. Revisar periodicamente inclusão de queries nativas (`@Query(nativeQuery=true)`) garantindo uso de parâmetros nomeados.  
4. Adicionar sanitização / trimming de campos textuais.

---
## 4. A07 – Identification and Authentication Failures
### Descrição Sintética (OWASP)
Falhas nos processos de autenticação ou gestão de identidade permitindo impersonação, reuse ou escalonamento indevido.

### Cenário de Risco na Aplicação
A API depende de tokens JWT para identificar usuários voluntários. Tokens expirados ou modificados, se aceitos, abririam acesso indevido a dados de beneficiados. Ausência de limpeza do contexto de segurança permitiria confusão entre requisições.

### Implementação / Tratamento
Fluxo executado no `AutenticacaoFilter` (subclasse de `OncePerRequestFilter`):
1. Extrai header `Authorization` e valida prefixo `Bearer `.  
2. Obtém username decodificando o token via `GerenciadorTokenJwt` (que usa JJWT para parser e valida assinatura).  
3. Se não houver `Authentication` ainda em `SecurityContextHolder`, carrega `UserDetails` e valida integridade e expiração do token (`validateToken`).  
4. Constrói `UsernamePasswordAuthenticationToken` e o injeta no contexto para downstream (controladores, @PreAuthorize).  

### Evidência de Código
```java
if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
  jwtToken = requestTokenHeader.substring(7);
  username = jwtTokenManager.getUsernameFromToken(jwtToken);
}
...
if (jwtTokenManager.validateToken(jwtToken, userDetails)) {
  UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
    userDetails, null, userDetails.getAuthorities());
  SecurityContextHolder.getContext().setAuthentication(auth);
}
```
```java
public boolean validateToken(String token, UserDetails userDetails) {
  String username = getUsernameFromToken(token);
  return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
}
```

### Como o Framework / Biblioteca Mitiga (Detalhe Técnico)
- `OncePerRequestFilter` garante execução única por requisição, evitando duplicações e race conditions em contexto de autenticação.
- `SecurityContextHolder` usa por padrão `ThreadLocal` para isolar a identidade da requisição atual — não há vazamento entre threads.
- A biblioteca JJWT executa decodificação Base64Url, validação de assinatura e parsing estruturado; uma assinatura inválida resulta em exceção antes de qualquer uso de claims.
- A ausência de sessão (STATELESS) obriga validação idempotente por requisição — reduz chance de sessão zombie.

### Limitações e Riscos Remanescentes
- Não há controle de revogação (token válido continua aceito até expirar).  
- Sem limitação de tentativas ou detecção de brute force de token (p.ex. em endpoints públicos).  
- Ausência de refresh token estruturado pode induzir a janelas longas de expiração ou troca manual frequente.

### Recomendações
1. Implementar lista de revogação (cache distribuído; blacklist/jti).  
2. Adicionar métricas de falhas de autenticação e rate limiting (ex.: Bucket4J ou Spring Cloud Gateway).  
3. Introduzir refresh token com rotação (rotating refresh tokens).  
4. Adicionar claim `iat` verificada contra versão de credencial (para invalidar credenciais em reset de senha).  
5. Registrar auditoria mínima (sucesso/falha, origem IP, user agent).  

---
## 5. Tabela de Mapeamento (Resumo)
| OWASP | Risco Alvo | Mecanismo Central | Onde no Código | Limitação Principal |
|-------|------------|-------------------|----------------|--------------------|
| A01 | Acesso indevido a endpoints | DSL de autorização + stateless | SecurityConfiguracao | Falta de roles e owner checks |
| A02 | Vazamento / alteração de segredos | BCrypt + JWT assinado + expiração | SecurityConfiguracao / GerenciadorTokenJwt | Sem rotação de chaves |
| A03 | SQL Injection | Repositórios JPA parametrizados | BeneficiadoJpaRepository e similares | Falta de validação de formato |
| A07 | Uso de token inválido/expirado | Filtro JWT + validação assinatura/expiração | AutenticacaoFilter / GerenciadorTokenJwt | Sem revogação e rate limiting |

---
## 6. Recomendações Consolidada (Prioridades)
1. (Alto) Introduzir rotação e proteção de segredo JWT (A02).  
2. (Alto) Adicionar controle de revogação + refresh tokens (A07).  
3. (Médio) Implementar roles e verificações de propriedade (A01).  
4. (Médio) Validação e limites de campos de entrada críticos (CPF, nomes) (A03).  
5. (Médio) Endurecer CORS e remover `h2-console` fora de dev (A01/A05).  
6. (Baixo) Auditoria estruturada e métricas de falhas (A07).  

---
## 7. Conclusão
Os controles existentes fornecem uma base coerente para proteção de acesso, criptografia aplicada a credenciais e prevenção básica de injeção, além de autenticação tokenizada. A eficácia depende de manutenção contínua: rotação de segredos, incremento do custo BCrypt, enriquecimento de autorização contextual e observabilidade. A priorização indicada aproxima a aplicação de um nível de maturidade superior em segurança alinhada ao OWASP Top 10.
