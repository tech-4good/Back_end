package tech4good.tech4good_api.core.application.usecase.filaespera;

import tech4good.tech4good_api.core.adapter.FilaEsperaGateway;
import tech4good.tech4good_api.core.application.command.filaespera.RemoverFilaEsperaCommand;
import tech4good.tech4good_api.core.domain.filaespera.FilaEspera;
import tech4good.tech4good_api.infrastructure.integration.messaging.FilaEsperaMessageProducer;
import java.time.LocalDate;

public class RemoverFilaEsperaUseCase {
    private final FilaEsperaGateway gateway;
    private final FilaEsperaMessageProducer messageProducer;

    public RemoverFilaEsperaUseCase(FilaEsperaGateway gateway, FilaEsperaMessageProducer messageProducer) {
        this.gateway = gateway;
        this.messageProducer = messageProducer;
    }

    public void executar(RemoverFilaEsperaCommand command) {
        // Busca os dados da fila antes de remover para enviar a mensagem
        FilaEspera filaEspera = gateway.buscarPorId(command.id());

        if (filaEspera != null) {
            // Define a data de saída da fila
            filaEspera.setDataSaidaFila(LocalDate.now());

            // Envia mensagem de saída da fila antes de remover
            messageProducer.enviarEventoSaidaFila(filaEspera);

            // Remove do banco de dados
            gateway.remover(command.id());
        }
    }
}
