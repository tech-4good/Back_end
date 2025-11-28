package tech4good.tech4good_api.config.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * Configuração customizada para Feign Clients
 * Usa um ObjectMapper sem tipos polimórficos para evitar conflitos com APIs externas
 */
@Configuration
public class FeignConfig {

    private final ObjectMapper feignObjectMapper;

    public FeignConfig(@Qualifier("feignObjectMapper") ObjectMapper feignObjectMapper) {
        this.feignObjectMapper = feignObjectMapper;
    }

    @Bean
    public Decoder feignDecoder() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(feignObjectMapper);
        HttpMessageConverters converters = new HttpMessageConverters(converter);
        return new ResponseEntityDecoder(new SpringDecoder(() -> converters));
    }

    @Bean
    public Encoder feignEncoder() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(feignObjectMapper);
        HttpMessageConverters converters = new HttpMessageConverters(converter);
        return new SpringEncoder(() -> converters);
    }
}

