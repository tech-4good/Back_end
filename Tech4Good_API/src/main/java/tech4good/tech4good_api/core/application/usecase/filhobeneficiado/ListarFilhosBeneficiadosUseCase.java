package tech4good.tech4good_api.core.application.usecase.filhobeneficiado;

import tech4good.tech4good_api.core.adapter.FilhoBeneficiadoGateway;
import tech4good.tech4good_api.core.domain.filhobeneficiado.FilhoBeneficiado;

import java.util.List;

public class ListarFilhosBeneficiadosUseCase {
    private final FilhoBeneficiadoGateway gateway;

    public ListarFilhosBeneficiadosUseCase(FilhoBeneficiadoGateway gateway) {
        this.gateway = gateway;
    }

    public List<FilhoBeneficiado> executar() {
        return gateway.findAll();
    }
}
