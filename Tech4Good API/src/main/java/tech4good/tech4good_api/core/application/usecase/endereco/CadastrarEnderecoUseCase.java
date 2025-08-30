package tech4good.tech4good_api.core.application.usecase.endereco;

import tech4good.tech4good_api.core.adapter.EnderecoGateway;
import tech4good.tech4good_api.core.application.command.endereco.CadastrarEnderecoCommand;
import tech4good.tech4good_api.core.application.exception.ConflitoEntidadeException;
import tech4good.tech4good_api.core.domain.endereco.Endereco;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco.EnderecoMapper;

public class CadastrarEnderecoUseCase {

    private final EnderecoGateway gateway;

    public CadastrarEnderecoUseCase(EnderecoGateway gateway) {
        this.gateway = gateway;
    }

    public Endereco executar(CadastrarEnderecoCommand command) {
        if (gateway.existsByCepAndNumero(command.cep().toString(), command.numero())){
            throw new ConflitoEntidadeException("O endereço já existe na base de dados");
        }
        Endereco endereco = EnderecoMapper.toDomain(command);
        return gateway.save(endereco);
    }
}
