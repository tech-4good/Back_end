package tech4good.tech4good_api.core.application.usecase.auxiliogovernamental;

import tech4good.tech4good_api.core.adapter.AuxilioGovernamentalGateway;
import tech4good.tech4good_api.core.application.command.auxiliogovernamental.CadastrarAuxilioGovernamentalCommand;
import tech4good.tech4good_api.core.domain.auxiliogovernamental.AuxilioGovernamental;

public class CadastrarAuxilioGovernamentalUseCase {
    private final AuxilioGovernamentalGateway gateway;

    public CadastrarAuxilioGovernamentalUseCase(AuxilioGovernamentalGateway gateway) {
        this.gateway = gateway;
    }

    public AuxilioGovernamental executar(CadastrarAuxilioGovernamentalCommand command) {
        var auxilioGovernamental = new AuxilioGovernamental(null, command.tipo());
        return gateway.save(auxilioGovernamental);
    }
}
