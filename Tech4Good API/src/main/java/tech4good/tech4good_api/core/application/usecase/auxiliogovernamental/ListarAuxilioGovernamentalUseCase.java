package tech4good.tech4good_api.core.application.usecase.auxiliogovernamental;

import tech4good.tech4good_api.core.adapter.AuxilioGovernamentalGateway;
import tech4good.tech4good_api.core.domain.auxiliogovernamental.AuxilioGovernamental;
import java.util.List;

public class ListarAuxilioGovernamentalUseCase {
    private final AuxilioGovernamentalGateway gateway;

    public ListarAuxilioGovernamentalUseCase(AuxilioGovernamentalGateway gateway) {
        this.gateway = gateway;
    }

    public List<AuxilioGovernamental> executar() {
        return gateway.findAll();
    }
}
