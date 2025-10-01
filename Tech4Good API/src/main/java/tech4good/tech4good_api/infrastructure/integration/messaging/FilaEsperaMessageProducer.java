package tech4good.tech4good_api.infrastructure.integration.messaging;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech4good.tech4good_api.core.domain.filaespera.FilaEspera;
import tech4good.tech4good_api.core.application.dto.filaespera.FilaEsperaEventDto;
import tech4good.tech4good_api.core.application.dto.filaespera.TipoEventoFilaEspera;
import tech4good.tech4good_api.infrastructure.integration.config.RabbitMQConfig;

@Service
@RequiredArgsConstructor
@Slf4j
public class FilaEsperaMessageProducer {

    private final RabbitTemplate rabbitTemplate;
    private final RabbitMQConfig rabbitMQConfig;
    private final ObjectMapper objectMapper;

    /**
     * Envia mensagem quando beneficiado entra na fila de espera
     */
    public void enviarEventoEntradaFila(FilaEspera filaEspera) {
        try {
            FilaEsperaEventDto evento = FilaEsperaEventDto.builder()
                    .filaEsperaId(filaEspera.getId())
                    .beneficiadoId(filaEspera.getBeneficiado().getId())
                    .beneficiadoNome(filaEspera.getBeneficiado().getNome())
                    .dataEntradaFila(filaEspera.getDataEntradaFila())
                    .tipoEvento(TipoEventoFilaEspera.ENTRADA_FILA)
                    .mensagem(String.format("Beneficiado %s entrou na fila de espera em %s",
                             filaEspera.getBeneficiado().getNome(),
                             filaEspera.getDataEntradaFila()))
                    .build();

            String eventoJson = objectMapper.writeValueAsString(evento);

            rabbitTemplate.convertAndSend(
                rabbitMQConfig.getFilaEsperaExchangeName(),
                rabbitMQConfig.getFilaEsperaRoutingKey(),
                eventoJson
            );

            log.info("Evento de entrada na fila enviado para beneficiado ID: {}",
                    filaEspera.getBeneficiado().getId());

        } catch (JsonProcessingException e) {
            log.error("Erro ao converter evento para JSON: {}", e.getMessage());
            throw new RuntimeException("Falha ao processar evento de entrada na fila", e);
        }
    }

    /**
     * Envia mensagem quando beneficiado sai da fila de espera
     */
    public void enviarEventoSaidaFila(FilaEspera filaEspera) {
        try {
            FilaEsperaEventDto evento = FilaEsperaEventDto.builder()
                    .filaEsperaId(filaEspera.getId())
                    .beneficiadoId(filaEspera.getBeneficiado().getId())
                    .beneficiadoNome(filaEspera.getBeneficiado().getNome())
                    .dataEntradaFila(filaEspera.getDataEntradaFila())
                    .tipoEvento(TipoEventoFilaEspera.SAIDA_FILA)
                    .mensagem(String.format("Beneficiado %s saiu da fila de espera em %s",
                             filaEspera.getBeneficiado().getNome(),
                             filaEspera.getDataSaidaFila()))
                    .build();

            String eventoJson = objectMapper.writeValueAsString(evento);

            rabbitTemplate.convertAndSend(
                rabbitMQConfig.getFilaEsperaExchangeName(),
                rabbitMQConfig.getFilaEsperaRoutingKey(),
                eventoJson
            );

            log.info("Evento de saída da fila enviado para beneficiado ID: {}",
                    filaEspera.getBeneficiado().getId());

        } catch (JsonProcessingException e) {
            log.error("Erro ao converter evento para JSON: {}", e.getMessage());
            throw new RuntimeException("Falha ao processar evento de saída da fila", e);
        }
    }
}
