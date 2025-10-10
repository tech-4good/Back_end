package tech4good.tech4good_api.core.application.usecase.tipomorador;

import tech4good.tech4good_api.core.adapter.TipoMoradorGateway;
import tech4good.tech4good_api.core.domain.tipomorador.TipoMorador;

import java.util.List;

public class ListarTipoMoradoresUseCase {

    private final TipoMoradorGateway gateway;

    public ListarTipoMoradoresUseCase(TipoMoradorGateway gateway) {
        this.gateway = gateway;
    }

    public List<TipoMorador> execute() {
        return gateway.findAll();
    }
}
