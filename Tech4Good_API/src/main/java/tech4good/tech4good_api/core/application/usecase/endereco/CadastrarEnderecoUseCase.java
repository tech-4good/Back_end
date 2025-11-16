package tech4good.tech4good_api.core.application.usecase.endereco;

import tech4good.tech4good_api.core.adapter.EnderecoGateway;
import tech4good.tech4good_api.core.application.command.endereco.CadastrarEnderecoCommand;
import tech4good.tech4good_api.core.application.exception.ConflitoEntidadeException;
import tech4good.tech4good_api.core.domain.endereco.Endereco;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco.EnderecoMapper;

public class CadastrarEnderecoUseCase {

    private final EnderecoGateway gateway;
    private final DefinirStatusInicialEnderecoUseCase definirStatusUseCase;

    public CadastrarEnderecoUseCase(EnderecoGateway gateway, DefinirStatusInicialEnderecoUseCase definirStatusUseCase) {
        this.gateway = gateway;
        this.definirStatusUseCase = definirStatusUseCase;
    }

    public Endereco executar(CadastrarEnderecoCommand command) {
        if (gateway.existsByCepAndNumero(command.cep().toString(), command.numero())){
            throw new ConflitoEntidadeException("O endereço já existe na base de dados");
        }
        Endereco endereco = EnderecoMapper.toDomain(command);

        // Definir status inicial baseado na disponibilidade de cestas BÁSICAS
        endereco = definirStatusUseCase.executar(endereco);

        return gateway.save(endereco);
    }
}
