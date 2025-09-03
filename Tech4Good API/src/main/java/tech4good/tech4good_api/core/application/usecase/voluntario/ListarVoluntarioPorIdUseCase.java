package tech4good.tech4good_api.core.application.usecase.voluntario;

import tech4good.tech4good_api.core.adapter.VoluntarioGateway;
import tech4good.tech4good_api.core.application.command.voluntario.ListarVoluntarioPorIdCommand;
import tech4good.tech4good_api.core.domain.voluntario.Voluntario;

public class ListarVoluntarioPorIdUseCase {

    private final VoluntarioGateway voluntarioGateway;

    public ListarVoluntarioPorIdUseCase(VoluntarioGateway voluntarioGateway) {
        this.voluntarioGateway = voluntarioGateway;
    }

    public Voluntario executar(ListarVoluntarioPorIdCommand command) {
        return voluntarioGateway.buscarPorId(command.id());
    }
}
