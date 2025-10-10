package tech4good.tech4good_api.core.application.usecase.tipomorador;

import tech4good.tech4good_api.core.adapter.TipoMoradorGateway;
import tech4good.tech4good_api.core.application.command.tipomorador.RemoverTipoMoradorCommand;
import tech4good.tech4good_api.core.application.exception.EntidadeNaoEncontradaException;
import tech4good.tech4good_api.infrastructure.persistence.jpa.TipoMorador.TipoMoradorMapper;

public class RemoverTipoMoradorUseCase {

    private final TipoMoradorGateway gateway;

    public RemoverTipoMoradorUseCase(TipoMoradorGateway gateway) {
        this.gateway = gateway;
    }

    public void execute(RemoverTipoMoradorCommand command) {
        if (gateway.existsById(command.id())) {
            gateway.deleteById(command.id());
        } else {
            throw new EntidadeNaoEncontradaException("TipoMorador de id %d não encontrado".formatted(command.id()));
        }
    }
}
