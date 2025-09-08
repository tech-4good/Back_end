package tech4good.tech4good_api.core.application.usecase.tipomorador;

import tech4good.tech4good_api.core.adapter.TipoMoradorGateway;
import tech4good.tech4good_api.core.application.command.tipomorador.AtualizarTipoMoradorCommand;
import tech4good.tech4good_api.core.application.exception.EntidadeNaoEncontradaException;
import tech4good.tech4good_api.core.domain.tipomorador.TipoMorador;

public class AtualizarTipoMoradorUseCase {

    private final TipoMoradorGateway gateway;

    public AtualizarTipoMoradorUseCase(TipoMoradorGateway gateway) {
        this.gateway = gateway;
    }

    public TipoMorador execute(AtualizarTipoMoradorCommand command) {
        TipoMorador tipoMoradorExistente = gateway.findById(command.id())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("TipoMorador de id %d não encontrado".formatted(command.id())));

        // Atualizar apenas os campos modificáveis, mantendo as relações existentes
        tipoMoradorExistente.setQuantidadeCrianca(command.quantidadeCrianca());
        tipoMoradorExistente.setQuantidadeAdolescente(command.quantidadeAdolescente());
        tipoMoradorExistente.setQuantidadeJovem(command.quantidadeJovem());
        tipoMoradorExistente.setQuantidadeIdoso(command.quantidadeIdoso());
        tipoMoradorExistente.setQuantidadeGestante(command.quantidadeGestante());
        tipoMoradorExistente.setQuantidadeDeficiente(command.quantidadeDeficiente());
        tipoMoradorExistente.setQuantidadeOutros(command.quantidadeOutros());

        return gateway.save(tipoMoradorExistente);
    }
}
