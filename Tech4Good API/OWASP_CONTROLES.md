# Controles de Segurança Implementados (Evidências OWASP Top 10)

Este documento descreve 4 controles presentes no projeto que mitigam riscos mapeados pelo OWASP Top 10. Inclui explicação, risco mitigado, trecho de código e oportunidades de reforço.

---
## 1. A01: Broken Access Control
**Risco:** Usuários não autorizados acessarem recursos protegidos.

**Controle Implementado:** Modelo de autorização declarativa via `HttpSecurity` exigindo autenticação para domínios sensíveis e liberando apenas rotas públicas necessárias.

```java
// SecurityConfiguracao.java (trecho)
.authorizeHttpRequests(authorize -> authorize
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

**Efeito de Mitigação:**
- Impede acesso anônimo a endpoints críticos.
- Reduz superfícies para enumeração e abuso.
- Usa política stateless, evitando fixação de sessão.

**Boas Práticas Atendidas:** Positive security model; segregação clara entre público e protegido.

**Possíveis Reforços:**
- Restringir `h2-console` em produção.
- Adicionar escopos/funções (ex.: ROLE_ADMIN) com `.hasRole(...)`.
- Complementar com anotações a nível de método (`@PreAuthorize`).

---
## 2. A02: Cryptographic Failures
**Risco:** Exposição de senhas ou tokens permitindo comprometimento de contas.

**Controles Implementados:**
1. Hash de senha forte com BCrypt.
2. Assinatura HMAC de JWT com chave secreta externa (`jwt.secret`).
3. Expiração configurada (`jwt.validity`).

```java
// SecurityConfiguracao.java
@Bean
public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }
```

```java
// GerenciadorTokenJwt.java (trecho)
return Jwts.builder()
    .setSubject(authentication.getName())
    .signWith(parseSecret())
    .setIssuedAt(new Date(System.currentTimeMillis()))
    .setExpiration(new Date(System.currentTimeMillis() + jwtTokenValidity * 1000))
    .compact();
```

**Efeito de Mitigação:**
- Senhas não ficam reversíveis (BCrypt é adaptativo).
- Tokens inválidos após expiração reduzem janela de abuso.
- Assinatura impede adulteração sem a chave.

**Boas Práticas Atendidas:** Password Storage; Token Integrity; Expiration Policy.

**Possíveis Reforços:**
- Rotacionar chave JWT periodicamente + key id (kid).
- Usar variáveis de ambiente/secret manager; evitar armazenar secret em texto plano.
- Definir fator de custo BCrypt explícito (ex.: `new BCryptPasswordEncoder(12)`).
- Incluir claim de authorities (atualmente coletada e não adicionada) para validações fine-grained se necessário.

---
## 3. A03: Injection
**Risco:** Execução de comandos SQL arbitrários (SQL Injection) obtendo/leakando dados sensíveis.

**Controle Implementado:** Uso de Spring Data JPA com query derivada e binding automático de parâmetros, sem concatenação manual de SQL.

```java
// BeneficiadoJpaRepository.java
public interface BeneficiadoJpaRepository extends JpaRepository<BeneficiadoEntity, Integer> {
    boolean existsByCpf(String cpf);
    Optional<BeneficiadoEntity> findByCpf(String cpf);
}
```

**Efeito de Mitigação:**
- Geração de Prepared Statements internalizada no provedor JPA.
- Evita interpolação de strings e construção dinâmica insegura.
- Reduz risco em campos críticos como CPF.

**Boas Práticas Atendidas:** Parametrização; ORM seguro.

**Possíveis Reforços:**
- Adicionar validação sintática/regex para CPF antes de consultar.
- Restringir tamanho de colunas (`@Column(length=...)`).
- Revisar se há queries nativas em outros pontos (não evidenciado aqui).

---
## 4. A07: Identification and Authentication Failures
**Risco:** Bypass de autenticação, uso de tokens expirados ou forjados.

**Controles Implementados:**
1. Filtro dedicado (`OncePerRequestFilter`) para extração e validação de JWT.
2. Recusa de token expirado (gera 401).
3. Criação explícita de `SecurityContext` somente após validação.
4. Arquitetura stateless (sem sessão servidor) reduz superfície de hijacking.

```java
// AutenticacaoFilter.java (trechos)
String requestTokenHeader = request.getHeader("Authorization");
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
// GerenciadorTokenJwt.java (validação de expiração)
private Boolean isTokenExpired(String token) {
    Date expirationDate = getExpirationDateFromToken(token);
    return expirationDate.before(new Date(System.currentTimeMillis()));
}
```

**Efeito de Mitigação:**
- Impede uso de tokens caducados.
- Evita criação de contexto para tokens inválidos.
- Minimiza persistência de estado comprometível.

**Boas Práticas Atendidas:** Token-Based Auth; Fail-Fast em expiração.

**Possíveis Reforços:**
- Implementar refresh token + rotação.
- Lista de revogação (logout forçado / comprometimento).
- Auditoria de tentativas inválidas (rate limiting / lockout progressivo).

---
## Sumário dos Benefícios
| OWASP | Controle Principal | Benefício Central |
|-------|--------------------|-------------------|
| A01   | Regras de autorização + stateless | Minimiza acesso indevido |
| A02   | BCrypt + JWT assinado + expiração | Protege credenciais e integridade de token |
| A03   | Repositórios JPA parametrizados | Mitiga SQL Injection |
| A07   | Filtro JWT + validação expiração | Garante autenticidade e validade da sessão |

---
## Recomendações Futuras
1. A05 (Security Misconfiguration): Rever exposição de `h2-console` e cabeçalhos de segurança (ex.: `Content-Security-Policy`).
2. Logging Seguro: Remover qualquer possibilidade de logar tokens inteiros; mascarar se necessário.
3. Observabilidade: Adicionar métricas para tentativas inválidas por IP/usuário.
4. Hardening de CORS: Restringir `allowedOrigins` a domínios confiáveis em produção.
5. Segregação por Perfil: Introduzir roles (ex.: ADMIN, OPERACIONAL) para granularidade adicional.

---
## Conclusão
Os controles atuais estabelecem uma base sólida contra categorias críticas (A01, A02, A03, A07). A evolução natural envolve reforço de políticas de chave, maior observabilidade e mecanismos de revogação/rotação para tokens.


