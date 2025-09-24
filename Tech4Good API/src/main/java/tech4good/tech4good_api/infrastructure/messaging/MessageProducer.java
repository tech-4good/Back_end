package tech4good.tech4good_api.infrastructure.messaging;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import tech4good.tech4good_api.infrastructure.messaging.config.RabbitMQConfig;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageProducer {

    private final RabbitTemplate rabbitTemplate;
    private final RabbitMQConfig rabbitMQConfig;

    /**
     * Envia uma mensagem simples para a fila
     * @param message conteúdo da mensagem
     */
    public void sendMessage(String message) {
        try {
            log.info("Enviando mensagem: {}", message);

            rabbitTemplate.convertAndSend(
                rabbitMQConfig.getExchangeName(),
                rabbitMQConfig.getRoutingKey(),
                message
            );

            log.info("Mensagem enviada com sucesso!");

        } catch (Exception e) {
            log.error("Erro ao enviar mensagem: {}", e.getMessage(), e);
            throw new RuntimeException("Falha ao enviar mensagem", e);
        }
    }

    /**
     * Envia uma mensagem com informações adicionais
     * @param message conteúdo da mensagem
     * @param details detalhes adicionais
     */
    public void sendDetailedMessage(String message, Object details) {
        String fullMessage = String.format("Mensagem: %s | Detalhes: %s", message, details.toString());
        sendMessage(fullMessage);
    }
}
