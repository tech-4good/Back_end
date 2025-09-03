package tech4good.tech4good_api.core.application.usecase.voluntario;

import tech4good.tech4good_api.core.adapter.VoluntarioGateway;
import tech4good.tech4good_api.core.application.command.voluntario.AtualizarVoluntarioCommand;
import tech4good.tech4good_api.core.domain.voluntario.Voluntario;

public class AtualizarVoluntarioUseCase {

    private final VoluntarioGateway voluntarioGateway;

    public AtualizarVoluntarioUseCase(VoluntarioGateway voluntarioGateway) {
        this.voluntarioGateway = voluntarioGateway;
    }

    public Voluntario executar(AtualizarVoluntarioCommand command) {
        return voluntarioGateway.atualizar(command);
    }
}
