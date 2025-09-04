package tech4good.tech4good_api.core.application.usecase.tipomorador;

import tech4good.tech4good_api.core.adapter.TipoMoradorGateway;
import tech4good.tech4good_api.core.application.command.tipomorador.BuscarTipoMoradorPorIdCommand;
import tech4good.tech4good_api.core.application.exception.EntidadeNaoEncontradaException;
import tech4good.tech4good_api.core.domain.tipomorador.TipoMorador;
import tech4good.tech4good_api.infrastructure.persistence.jpa.TipoMorador.TipoMoradorMapper;

public class BuscarTipoMoradorPorIdUseCase {

    private final TipoMoradorGateway gateway;

    public BuscarTipoMoradorPorIdUseCase(TipoMoradorGateway gateway) {
        this.gateway = gateway;
    }

    public TipoMorador execute(BuscarTipoMoradorPorIdCommand command) {
        return gateway.findById(command.id())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("TipoMorador de id %d não encontrado".formatted(command.id())));
    }
}
