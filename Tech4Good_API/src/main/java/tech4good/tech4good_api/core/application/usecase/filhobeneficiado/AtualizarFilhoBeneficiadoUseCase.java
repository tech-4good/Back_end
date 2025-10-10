package tech4good.tech4good_api.core.application.usecase.filhobeneficiado;

import tech4good.tech4good_api.core.adapter.FilhoBeneficiadoGateway;
import tech4good.tech4good_api.core.application.command.filhobeneficiado.AtualizarFilhoBeneficiadoCommand;
import tech4good.tech4good_api.core.domain.filhobeneficiado.FilhoBeneficiado;

public class AtualizarFilhoBeneficiadoUseCase {
    private final FilhoBeneficiadoGateway gateway;

    public AtualizarFilhoBeneficiadoUseCase(FilhoBeneficiadoGateway gateway) {
        this.gateway = gateway;
    }

    public FilhoBeneficiado executar(AtualizarFilhoBeneficiadoCommand command) {
        FilhoBeneficiado filhoExistente = gateway.findById(command.id());

        if (command.isEstudante() != null) {
            filhoExistente.setEstudante(command.isEstudante());
        }

        if (command.hasCreche() != null) {
            filhoExistente.setHasCreche(command.hasCreche());
        }

        return gateway.save(filhoExistente);
    }
}
