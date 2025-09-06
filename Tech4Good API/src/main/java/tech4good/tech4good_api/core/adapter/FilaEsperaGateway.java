package tech4good.tech4good_api.core.adapter;

import tech4good.tech4good_api.core.domain.filaespera.FilaEspera;
import java.util.List;

public interface FilaEsperaGateway {
    FilaEspera salvar(FilaEspera filaEspera);
    List<FilaEspera> listarTodos();
    FilaEspera buscarPorId(Integer id);
    FilaEspera atualizar(FilaEspera filaEspera);
    void remover(Integer id);
}

