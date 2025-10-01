package tech4good.tech4good_api.infrastructure.integration.config;

import lombok.Getter;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class RabbitMQConfig {

    @Value("${rabbitmq.filaespera.queue.name:tech4good.filaespera.queue}")
    private String filaEsperaQueueName;

    @Value("${rabbitmq.filaespera.exchange.name:tech4good.filaespera.exchange}")
    private String filaEsperaExchangeName;

    @Value("${rabbitmq.filaespera.routing.key:tech4good.filaespera.routing.key}")
    private String filaEsperaRoutingKey;

    /**
     * Fila específica para eventos da FilaEspera
     */
    @Bean
    public Queue filaEsperaQueue() {
        return QueueBuilder.durable(filaEsperaQueueName).build();
    }

    /**
     * Exchange específico para eventos da FilaEspera
     */
    @Bean
    public DirectExchange filaEsperaExchange() {
        return new DirectExchange(filaEsperaExchangeName);
    }

    /**
     * Binding entre a fila e exchange da FilaEspera
     */
    @Bean
    public Binding filaEsperaBinding(Queue filaEsperaQueue, DirectExchange filaEsperaExchange) {
        return BindingBuilder.bind(filaEsperaQueue).to(filaEsperaExchange).with(filaEsperaRoutingKey);
    }
}
