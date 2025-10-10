package tech4good.tech4good_api.core.application.usecase.voluntario;

import tech4good.tech4good_api.core.adapter.VoluntarioGateway;
import tech4good.tech4good_api.core.application.dto.voluntario.VoluntarioListarDto;
import tech4good.tech4good_api.core.domain.voluntario.Voluntario;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Voluntario.VoluntarioMapper;

import java.util.List;

public class ListarVoluntariosUseCase {

    private final VoluntarioGateway voluntarioGateway;

    public ListarVoluntariosUseCase(VoluntarioGateway voluntarioGateway) {
        this.voluntarioGateway = voluntarioGateway;
    }

    public List<VoluntarioListarDto> execute() {
        List<Voluntario> voluntarios = voluntarioGateway.listarTodos();
        return voluntarios.stream()
                .map(VoluntarioMapper::toVoluntarioListarDto)
                .toList();
    }
}
