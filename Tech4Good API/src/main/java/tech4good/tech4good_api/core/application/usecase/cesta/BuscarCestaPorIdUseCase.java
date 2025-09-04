package tech4good.tech4good_api.core.application.usecase.cesta;

import tech4good.tech4good_api.core.adapter.CestaGateway;
import tech4good.tech4good_api.core.application.command.cesta.ListarCestaPorIdCommand;
import tech4good.tech4good_api.core.application.exception.EntidadeNaoEncontradaException;
import tech4good.tech4good_api.core.domain.cesta.Cesta;

public class BuscarCestaPorIdUseCase {

    private final CestaGateway cestaGateway;

    public BuscarCestaPorIdUseCase(CestaGateway cestaGateway) {
        this.cestaGateway = cestaGateway;
    }

    public Cesta executar(ListarCestaPorIdCommand command) {
        return cestaGateway.findById(command.id())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Cesta de id %d não encontrada".formatted(command.id())));
    }
}
