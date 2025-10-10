package tech4good.tech4good_api.core.application.usecase.filhobeneficiado;

import tech4good.tech4good_api.core.adapter.FilhoBeneficiadoGateway;
import tech4good.tech4good_api.core.application.command.filhobeneficiado.RemoverFilhoBeneficiadoPorIdCommand;

public class RemoverFilhoBeneficiadoPorIdUseCase {
    private final FilhoBeneficiadoGateway gateway;

    public RemoverFilhoBeneficiadoPorIdUseCase(FilhoBeneficiadoGateway gateway) {
        this.gateway = gateway;
    }

    public void executar(RemoverFilhoBeneficiadoPorIdCommand command) {
        gateway.deleteById(command.id());
    }
}
