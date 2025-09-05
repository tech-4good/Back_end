package tech4good.tech4good_api.core.application.usecase.filhobeneficiado;

import tech4good.tech4good_api.core.adapter.FilhoBeneficiadoGateway;
import tech4good.tech4good_api.core.application.command.filhobeneficiado.BuscarFilhoBeneficiadoPorIdCommand;
import tech4good.tech4good_api.core.domain.filhobeneficiado.FilhoBeneficiado;

public class BuscarFilhoBeneficiadoPorIdUseCase {
    private final FilhoBeneficiadoGateway gateway;

    public BuscarFilhoBeneficiadoPorIdUseCase(FilhoBeneficiadoGateway gateway) {
        this.gateway = gateway;
    }

    public FilhoBeneficiado executar(BuscarFilhoBeneficiadoPorIdCommand command) {
        return gateway.findById(command.id());
    }
}
