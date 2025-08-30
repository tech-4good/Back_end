package tech4good.tech4good_api.core.application.usecase.endereco;

import tech4good.tech4good_api.core.adapter.EnderecoGateway;
import tech4good.tech4good_api.core.application.command.endereco.AtualizarEnderecoCommand;
import tech4good.tech4good_api.core.application.exception.EntidadeNaoEncontradaException;
import tech4good.tech4good_api.core.domain.endereco.Endereco;

public class AtualizarEnderecoUseCase {

    private final EnderecoGateway gateway;

    public AtualizarEnderecoUseCase(EnderecoGateway gateway) {
        this.gateway = gateway;
    }

    public Endereco executar(AtualizarEnderecoCommand command) {
        Endereco enderecoExistente = gateway.findById(command.id())
            .orElseThrow(() -> new EntidadeNaoEncontradaException(
                "Endereço de id %d não encontrado".formatted(command.id())
            ));

        enderecoExistente.setStatus(command.status());

        return gateway.save(enderecoExistente);
    }
}

