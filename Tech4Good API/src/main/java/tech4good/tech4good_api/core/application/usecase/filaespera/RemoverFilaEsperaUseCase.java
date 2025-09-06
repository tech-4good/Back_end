package tech4good.tech4good_api.core.application.usecase.filaespera;

import tech4good.tech4good_api.core.adapter.FilaEsperaGateway;
import tech4good.tech4good_api.core.application.command.filaespera.RemoverFilaEsperaCommand;

public class RemoverFilaEsperaUseCase {
    private final FilaEsperaGateway gateway;

    public RemoverFilaEsperaUseCase(FilaEsperaGateway gateway) {
        this.gateway = gateway;
    }

    public void executar(RemoverFilaEsperaCommand command) {
        gateway.remover(command.id());
    }
}

