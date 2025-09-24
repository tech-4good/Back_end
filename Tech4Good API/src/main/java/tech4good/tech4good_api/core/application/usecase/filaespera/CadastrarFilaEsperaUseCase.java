package tech4good.tech4good_api.core.application.usecase.filaespera;

import tech4good.tech4good_api.core.adapter.FilaEsperaGateway;
import tech4good.tech4good_api.core.application.command.filaespera.CadastrarFilaEsperaCommand;
import tech4good.tech4good_api.core.domain.filaespera.FilaEspera;
import tech4good.tech4good_api.infrastructure.integration.messaging.FilaEsperaMessageProducer;

public class CadastrarFilaEsperaUseCase {
    private final FilaEsperaGateway gateway;
    private final FilaEsperaMessageProducer messageProducer;

    public CadastrarFilaEsperaUseCase(FilaEsperaGateway gateway, FilaEsperaMessageProducer messageProducer) {
        this.gateway = gateway;
        this.messageProducer = messageProducer;
    }

    public FilaEspera executar(CadastrarFilaEsperaCommand command) {
        FilaEspera fila = new FilaEspera();
        fila.setDataEntradaFila(command.dataEntradaFila());
        fila.setBeneficiado(command.beneficiado());

        // Salva no banco de dados
        FilaEspera filaSalva = gateway.salvar(fila);

        // Envia mensagem para o RabbitMQ
        messageProducer.enviarEventoEntradaFila(filaSalva);

        return filaSalva;
    }
}
