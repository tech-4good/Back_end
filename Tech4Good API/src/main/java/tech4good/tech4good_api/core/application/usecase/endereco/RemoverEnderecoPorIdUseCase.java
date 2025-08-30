package tech4good.tech4good_api.core.application.usecase.endereco;

import tech4good.tech4good_api.core.adapter.EnderecoGateway;
import tech4good.tech4good_api.core.application.command.endereco.RemoverEnderecoPorIdCommand;
import tech4good.tech4good_api.core.application.exception.EntidadeNaoEncontradaException;

public class RemoverEnderecoPorIdUseCase {

    private final EnderecoGateway gateway;

    public RemoverEnderecoPorIdUseCase(EnderecoGateway gateway) {
        this.gateway = gateway;
    }

    public void executar(RemoverEnderecoPorIdCommand command) {
        Integer id = command.id();
        if (gateway.existsById(id)) {
            gateway.deleteById(id);
        } else {
            throw new EntidadeNaoEncontradaException("Endereço de id %d não encontrado".formatted(id));
        }
    }
}

