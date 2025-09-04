package tech4good.tech4good_api.core.application.usecase.tipomorador;

import tech4good.tech4good_api.core.adapter.TipoMoradorGateway;
import tech4good.tech4good_api.core.application.command.tipomorador.AtualizarTipoMoradorCommand;
import tech4good.tech4good_api.core.application.exception.EntidadeNaoEncontradaException;
import tech4good.tech4good_api.core.domain.tipomorador.TipoMorador;
import tech4good.tech4good_api.infrastructure.persistence.jpa.TipoMorador.TipoMoradorMapper;

public class AtualizarTipoMoradorUseCase {

    private final TipoMoradorGateway gateway;

    public AtualizarTipoMoradorUseCase(TipoMoradorGateway gateway) {
        this.gateway = gateway;
    }

    public TipoMorador execute(AtualizarTipoMoradorCommand command) {
        TipoMorador tipoMoradorExistente = gateway.findById(command.id())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("TipoMorador de id %d não encontrado".formatted(command.id())));

        TipoMorador tipoMoradorAtualizado = TipoMoradorMapper.toDomain(command);
        // Manter as relações do objeto existente
        tipoMoradorAtualizado.setBeneficiado(tipoMoradorExistente.getBeneficiado());
        tipoMoradorAtualizado.setEndereco(tipoMoradorExistente.getEndereco());

        return gateway.save(tipoMoradorAtualizado);
    }
}
