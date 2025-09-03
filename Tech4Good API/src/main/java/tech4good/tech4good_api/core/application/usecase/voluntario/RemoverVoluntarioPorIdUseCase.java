package tech4good.tech4good_api.core.application.usecase.voluntario;

import tech4good.tech4good_api.core.adapter.VoluntarioGateway;
import tech4good.tech4good_api.core.application.command.voluntario.RemoverVoluntarioPorIdCommand;

public class RemoverVoluntarioPorIdUseCase {

    private final VoluntarioGateway voluntarioGateway;

    public RemoverVoluntarioPorIdUseCase(VoluntarioGateway voluntarioGateway) {
        this.voluntarioGateway = voluntarioGateway;
    }

    public void executar(RemoverVoluntarioPorIdCommand command) {
        voluntarioGateway.deletarPorId(command.id());
    }
}
