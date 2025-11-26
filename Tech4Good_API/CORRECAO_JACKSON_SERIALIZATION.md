# Correções de Serialização Jackson - LocalDate e Value Objects

## 📋 Problema Original
Erro ao carregar entregas da API:
```
Could not write JSON: Java 8 date/time type `java.time.LocalDate` not supported by default
```

E depois:
```
No serializer found for class tech4good.tech4good_api.core.domain.shared.valueobject.Cpf
```

## ✅ Soluções Implementadas

### 1. Configuração Global do Jackson
**Arquivo criado:** `JacksonConfig.java`
- Localização: `src/main/java/tech4good/tech4good_api/config/web/`
- Registra o módulo `JavaTimeModule` para suportar tipos de data Java 8 (LocalDate, LocalDateTime, etc.)
- Desabilita serialização de datas como timestamps
- Configurado como bean primário para uso em toda a aplicação

### 2. Atualização do Redis Cache Config
**Arquivo modificado:** `RedisCacheConfig.java`
- Localização: `src/main/java/tech4good/tech4good_api/config/redis/`
- Injetado o `ObjectMapper` configurado no `GenericJackson2JsonRedisSerializer`
- Garante que o cache Redis também serialize corretamente objetos com LocalDate

### 3. Anotações Jackson nos Value Objects

Todos os Value Objects foram atualizados com anotações Jackson para serialização correta:

#### Value Objects Corrigidos:

**Shared Value Objects:**
- ✅ `Cpf.java` - CPF formatado
- ✅ `Telefone.java` - Telefone formatado
- ✅ `TipoCesta.java` - Enum (não precisa de correção)

**Beneficiado Value Objects:**
- ✅ `Rg.java` - RG formatado
- ✅ `Renda.java` - Valor monetário formatado
- ✅ `Religiao.java` - String simples
- ✅ `EstadoCivil.java` - Enum (não precisa de correção)

**Voluntário Value Objects:**
- ✅ `Email.java` - Email validado

**Cesta Value Objects:**
- ✅ `Peso.java` - Peso em kg

**Auxílio Governamental Value Objects:**
- ✅ `Auxilio.java` - Nome do auxílio

#### Padrão Aplicado:
```java
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public class ValueObject {
    private final String value;
    
    @JsonCreator
    public ValueObject(String value) {
        this.value = value;
    }
    
    @JsonValue
    @Override
    public String toString() {
        return value; // ou formatado
    }
}
```

**Anotações usadas:**
- `@JsonCreator`: Indica ao Jackson qual construtor usar para deserialização
- `@JsonValue`: Indica qual método usar para serialização (geralmente toString ou getValue)

## 🚀 Como Aplicar as Mudanças

### 1. Recompilar o projeto
```bash
mvn clean package -DskipTests
```

### 2. Fazer deploy na nuvem
Após a compilação, faça o deploy do novo JAR/WAR para sua plataforma na nuvem.

## 📦 Dependências
A dependência `jackson-datatype-jsr310` já estava presente no `pom.xml`, apenas foi necessário configurá-la.

## 🔧 Correção Adicional - Erro de Cache (LinkedHashMap)

### Problema
Ao recarregar a página várias vezes, ocorria o erro:
```
class java.util.LinkedHashMap cannot be cast to class org.springframework.data.domain.Page
```

### Causa
O Redis estava serializando objetos `Page<Entrega>` sem informações de tipo, causando deserialização incorreta.

### Solução
Adicionado suporte a tipos polimórficos no `JacksonConfig`:
```java
BasicPolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder()
        .allowIfBaseType(Object.class)
        .build();

mapper.activateDefaultTyping(ptv, ObjectMapper.DefaultTyping.NON_FINAL);
```

Isso permite que o Jackson inclua informações de tipo (@class) na serialização JSON, garantindo deserialização correta do cache.

## 🎯 Resultado Esperado
Após o deploy, a API deve:
- ✅ Serializar corretamente objetos com `LocalDate`
- ✅ Serializar todos os Value Objects (CPF, Telefone, RG, etc.)
- ✅ Retornar JSON válido no endpoint de entregas
- ✅ Funcionar corretamente com Redis cache
- ✅ **Permitir múltiplos reloads da página sem erro de cast**

