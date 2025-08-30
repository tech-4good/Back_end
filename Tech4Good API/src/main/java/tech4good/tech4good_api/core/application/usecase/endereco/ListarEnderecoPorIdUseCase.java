package tech4good.tech4good_api.core.application.usecase.endereco;

import tech4good.tech4good_api.core.adapter.EnderecoGateway;
import tech4good.tech4good_api.core.application.command.endereco.ListarEnderecoPorIdCommand;
import tech4good.tech4good_api.core.application.exception.EntidadeNaoEncontradaException;
import tech4good.tech4good_api.core.domain.endereco.Endereco;

public class ListarEnderecoPorIdUseCase {

    private final EnderecoGateway gateway;

    public ListarEnderecoPorIdUseCase(EnderecoGateway gateway) {
        this.gateway = gateway;
    }

    public Endereco executar(ListarEnderecoPorIdCommand command) {
        Integer id = command.id();
        return gateway.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Endereço de id %d não encontrado".formatted(id)
                ));
    }
}
