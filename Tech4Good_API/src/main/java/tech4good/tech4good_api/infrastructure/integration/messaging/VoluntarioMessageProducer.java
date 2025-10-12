package tech4good.tech4good_api.infrastructure.integration.messaging;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech4good.tech4good_api.core.domain.voluntario.Voluntario;
import tech4good.tech4good_api.core.application.dto.voluntario.VoluntarioEmailEventDto;
import tech4good.tech4good_api.infrastructure.integration.config.RabbitMQConfig;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class VoluntarioMessageProducer {

    private final RabbitTemplate rabbitTemplate;
    private final RabbitMQConfig rabbitMQConfig;
    private final ObjectMapper objectMapper;

    public void enviarSolicitacaoRedefinicaoSenha(Voluntario voluntario, String tokenRedefinicao) {
        try {
            VoluntarioEmailEventDto evento = VoluntarioEmailEventDto.builder()
                    .voluntarioId(voluntario.getId())
                    .voluntarioNome(voluntario.getNome())
                    .voluntarioEmail(voluntario.getEmail().toString())
                    .tokenRedefinicao(tokenRedefinicao)
                    .dataEvento(LocalDateTime.now())
                    .build();

            String eventoJson = objectMapper.writeValueAsString(evento);

            rabbitTemplate.convertAndSend(
                rabbitMQConfig.getVoluntarioExchangeName(),
                rabbitMQConfig.getVoluntarioRoutingKey(),
                eventoJson
            );

            log.info("Mensagem de redefinição de senha enviada para fila - Voluntário: {}", voluntario.getEmail().toString());

        } catch (JsonProcessingException e) {
            log.error("Erro ao enviar mensagem para fila: {}", e.getMessage());
            throw new RuntimeException("Falha ao enviar mensagem", e);
        }
    }
}
