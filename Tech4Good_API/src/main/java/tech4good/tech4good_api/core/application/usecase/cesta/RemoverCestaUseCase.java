package tech4good.tech4good_api.core.application.usecase.cesta;

import tech4good.tech4good_api.core.adapter.CestaGateway;
import tech4good.tech4good_api.core.application.command.cesta.RemoverCestaPorIdCommand;
import tech4good.tech4good_api.core.application.exception.EntidadeNaoEncontradaException;

public class RemoverCestaUseCase {

    private final CestaGateway cestaGateway;

    public RemoverCestaUseCase(CestaGateway cestaGateway) {
        this.cestaGateway = cestaGateway;
    }

    public void executar(RemoverCestaPorIdCommand command) {
        if (!cestaGateway.existsById(command.id())) {
            throw new EntidadeNaoEncontradaException("Cesta de id %d não encontrada".formatted(command.id()));
        }
        cestaGateway.deleteById(command.id());
    }
}
