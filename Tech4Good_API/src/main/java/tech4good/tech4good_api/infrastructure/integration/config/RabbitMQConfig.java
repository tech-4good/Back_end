package tech4good.tech4good_api.infrastructure.integration.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.voluntario.queue.name:tech4good.voluntario.queue}")
    private String voluntarioQueueName;

    @Value("${rabbitmq.voluntario.exchange.name:tech4good.voluntario.exchange}")
    private String voluntarioExchangeName;

    @Value("${rabbitmq.voluntario.routing.key:tech4good.voluntario.routing.key}")
    private String voluntarioRoutingKey;

    public String getVoluntarioQueueName() {
        return voluntarioQueueName;
    }

    public String getVoluntarioExchangeName() {
        return voluntarioExchangeName;
    }

    public String getVoluntarioRoutingKey() {
        return voluntarioRoutingKey;
    }

    /**
     * Fila específica para eventos de Voluntário
     */
    @Bean
    public Queue voluntarioQueue() {
        return QueueBuilder.durable(voluntarioQueueName).build();
    }

    /**
     * Exchange específico para eventos de Voluntário
     */
    @Bean
    public DirectExchange voluntarioExchange() {
        return new DirectExchange(voluntarioExchangeName);
    }

    /**
     * Binding entre a fila e exchange de Voluntário
     */
    @Bean
    public Binding voluntarioBinding(Queue voluntarioQueue, DirectExchange voluntarioExchange) {
        return BindingBuilder.bind(voluntarioQueue).to(voluntarioExchange).with(voluntarioRoutingKey);
    }
}
