package tech4good.tech4good_api.core.application.usecase.auxiliogovernamental;

import tech4good.tech4good_api.core.adapter.AuxilioGovernamentalGateway;
import tech4good.tech4good_api.core.application.command.auxiliogovernamental.BuscarAuxilioGovernamentalPorIdCommand;
import tech4good.tech4good_api.core.domain.auxiliogovernamental.AuxilioGovernamental;

public class BuscarAuxilioGovernamentalPorIdUseCase {
    private final AuxilioGovernamentalGateway gateway;

    public BuscarAuxilioGovernamentalPorIdUseCase(AuxilioGovernamentalGateway gateway) {
        this.gateway = gateway;
    }

    public AuxilioGovernamental executar(BuscarAuxilioGovernamentalPorIdCommand command) {
        return gateway.findById(command.id());
    }
}
