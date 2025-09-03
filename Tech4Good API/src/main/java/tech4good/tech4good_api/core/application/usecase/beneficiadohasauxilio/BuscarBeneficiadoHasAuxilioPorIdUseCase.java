package tech4good.tech4good_api.core.application.usecase.beneficiadohasauxilio;

import tech4good.tech4good_api.core.adapter.BeneficiadoHasAuxilioGateway;
import tech4good.tech4good_api.core.application.command.beneficiadohasauxilio.BuscarBeneficiadoHasAuxilioPorIdCommand;
import tech4good.tech4good_api.core.domain.beneficiadohasauxilio.BeneficiadoHasAuxilio;

public class BuscarBeneficiadoHasAuxilioPorIdUseCase {
    private final BeneficiadoHasAuxilioGateway gateway;

    public BuscarBeneficiadoHasAuxilioPorIdUseCase(BeneficiadoHasAuxilioGateway gateway) {
        this.gateway = gateway;
    }

    public BeneficiadoHasAuxilio executar(BuscarBeneficiadoHasAuxilioPorIdCommand command) {
        return gateway.findById(command.id());
    }
}
