package tech4good.tech4good_api.core.application.usecase.entrega;

import tech4good.tech4good_api.core.adapter.EntregaGateway;
import tech4good.tech4good_api.core.application.command.entrega.RemoverEntregaPorIdCommand;
import tech4good.tech4good_api.core.application.exception.EntidadeNaoEncontradaException;

public class RemoverEntregaPorIdUseCase {
    private final EntregaGateway gateway;

    public RemoverEntregaPorIdUseCase(EntregaGateway gateway) {
        this.gateway = gateway;
    }

    public void executar(RemoverEntregaPorIdCommand command) {
        Integer id = command.id();
        if (gateway.existsById(id)) {
            gateway.deleteById(id);
        } else {
            throw new EntidadeNaoEncontradaException("Entrega de id %d não encontrada".formatted(id));
        }
    }
}
