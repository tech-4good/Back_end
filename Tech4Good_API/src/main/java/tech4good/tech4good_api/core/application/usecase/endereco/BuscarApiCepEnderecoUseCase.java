package tech4good.tech4good_api.core.application.usecase.endereco;

import tech4good.tech4good_api.core.adapter.ViaCepGateway;
import tech4good.tech4good_api.core.application.command.endereco.BuscarApiCepEnderecoCommand;
import tech4good.tech4good_api.core.domain.endereco.Endereco;

public class BuscarApiCepEnderecoUseCase {
    private final ViaCepGateway viaCepGateway;

    public BuscarApiCepEnderecoUseCase(ViaCepGateway viaCepGateway) {
        this.viaCepGateway = viaCepGateway;
    }

    public Endereco executar(BuscarApiCepEnderecoCommand command) {
        if (command == null || command.cep() == null) {
            throw new IllegalArgumentException("CEP inválido.");
        }

        return viaCepGateway.buscarEnderecoPorCep(command.cep().toString());
    }
}
