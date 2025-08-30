package tech4good.tech4good_api.core.application.usecase.beneficiado;

import tech4good.tech4good_api.core.adapter.BeneficiadoGateway;
import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;
import java.util.List;

public class ListarBeneficiadosUseCase {
    private final BeneficiadoGateway gateway;

    public ListarBeneficiadosUseCase(BeneficiadoGateway gateway) {
        this.gateway = gateway;
    }

    public List<Beneficiado> executar() {
        return gateway.findAll();
    }
}

