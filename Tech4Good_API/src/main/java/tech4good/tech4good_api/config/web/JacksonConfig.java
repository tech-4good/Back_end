package tech4good.tech4good_api.config.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class JacksonConfig {

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();

        // Registra o módulo para suportar tipos de data/hora do Java 8
        mapper.registerModule(new JavaTimeModule());

        // Desabilita a serialização de datas como timestamps
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        // Configura validação de tipos polimórficos para segurança
        BasicPolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder()
                .allowIfBaseType(Object.class)
                .build();

        mapper.activateDefaultTyping(ptv, ObjectMapper.DefaultTyping.NON_FINAL);

        return mapper;
    }

    /**
     * ObjectMapper específico para Feign Clients (sem tipos polimórficos)
     * Usado para APIs externas que não suportam metadata de tipo do Jackson
     */
    @Bean
    @Qualifier("feignObjectMapper")
    public ObjectMapper feignObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();

        // Registra o módulo para suportar tipos de data/hora do Java 8
        mapper.registerModule(new JavaTimeModule());

        // Desabilita a serialização de datas como timestamps
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        // NÃO ativa tipos polimórficos para evitar conflitos com APIs externas

        return mapper;
    }
}

