package tech4good.tech4good_api.core.application.usecase.entrega;

import tech4good.tech4good_api.core.adapter.EntregaGateway;
import tech4good.tech4good_api.core.application.command.entrega.BuscarEntregaPorIdCommand;
import tech4good.tech4good_api.core.domain.entrega.Entrega;

public class BuscarEntregaPorIdUseCase {
    private final EntregaGateway gateway;

    public BuscarEntregaPorIdUseCase(EntregaGateway gateway) {
        this.gateway = gateway;
    }

    public Entrega executar(BuscarEntregaPorIdCommand command) {
        return gateway.findById(command.id());
    }
}
