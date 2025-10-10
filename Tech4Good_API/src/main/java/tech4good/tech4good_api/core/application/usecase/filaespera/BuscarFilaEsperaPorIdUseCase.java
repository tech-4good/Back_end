package tech4good.tech4good_api.core.application.usecase.filaespera;

import tech4good.tech4good_api.core.adapter.FilaEsperaGateway;
import tech4good.tech4good_api.core.application.command.filaespera.BuscarFilaEsperaPorIdCommand;
import tech4good.tech4good_api.core.domain.filaespera.FilaEspera;

public class BuscarFilaEsperaPorIdUseCase {
    private final FilaEsperaGateway gateway;

    public BuscarFilaEsperaPorIdUseCase(FilaEsperaGateway gateway) {
        this.gateway = gateway;
    }

    public FilaEspera executar(BuscarFilaEsperaPorIdCommand command) {
        return gateway.buscarPorId(command.id());
    }
}

