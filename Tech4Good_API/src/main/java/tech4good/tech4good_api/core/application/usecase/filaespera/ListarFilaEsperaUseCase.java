package tech4good.tech4good_api.core.application.usecase.filaespera;

import tech4good.tech4good_api.core.adapter.FilaEsperaGateway;
import tech4good.tech4good_api.core.domain.filaespera.FilaEspera;
import java.util.List;

public class ListarFilaEsperaUseCase {
    private final FilaEsperaGateway gateway;

    public ListarFilaEsperaUseCase(FilaEsperaGateway gateway) {
        this.gateway = gateway;
    }

    public List<FilaEspera> executar() {
        return gateway.listarTodos();
    }
}

