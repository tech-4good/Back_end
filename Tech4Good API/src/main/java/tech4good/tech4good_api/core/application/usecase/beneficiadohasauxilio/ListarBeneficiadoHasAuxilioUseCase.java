package tech4good.tech4good_api.core.application.usecase.beneficiadohasauxilio;

import tech4good.tech4good_api.core.adapter.BeneficiadoHasAuxilioGateway;
import tech4good.tech4good_api.core.domain.beneficiadohasauxilio.BeneficiadoHasAuxilio;
import java.util.List;

public class ListarBeneficiadoHasAuxilioUseCase {
    private final BeneficiadoHasAuxilioGateway gateway;

    public ListarBeneficiadoHasAuxilioUseCase(BeneficiadoHasAuxilioGateway gateway) {
        this.gateway = gateway;
    }

    public List<BeneficiadoHasAuxilio> executar() {
        return gateway.findAll();
    }
}
