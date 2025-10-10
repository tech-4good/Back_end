package tech4good.tech4good_api.core.adapter;

import tech4good.tech4good_api.core.application.command.voluntario.AtualizarVoluntarioCommand;
import tech4good.tech4good_api.core.domain.voluntario.Voluntario;

import java.util.List;

public interface VoluntarioGateway {
    Voluntario salvar(Voluntario voluntario);
    Voluntario buscarPorId(Integer id);
    Voluntario buscarPorEmail(String email);
    List<Voluntario> listarTodos();
    Voluntario atualizar(AtualizarVoluntarioCommand command);
    void deletarPorId(Integer id);

    boolean existsById(Integer integer);
}
