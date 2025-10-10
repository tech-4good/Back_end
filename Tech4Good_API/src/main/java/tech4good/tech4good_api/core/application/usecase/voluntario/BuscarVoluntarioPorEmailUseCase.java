package tech4good.tech4good_api.core.application.usecase.voluntario;

import tech4good.tech4good_api.core.adapter.VoluntarioGateway;
import tech4good.tech4good_api.core.application.command.voluntario.BuscarVoluntarioPorEmailCommand;
import tech4good.tech4good_api.core.domain.voluntario.Voluntario;

public class BuscarVoluntarioPorEmailUseCase {

    private final VoluntarioGateway voluntarioGateway;

    public BuscarVoluntarioPorEmailUseCase(VoluntarioGateway voluntarioGateway) {
        this.voluntarioGateway = voluntarioGateway;
    }

    public Voluntario executar(BuscarVoluntarioPorEmailCommand command) {
        return voluntarioGateway.buscarPorEmail(command.email());
    }
}
