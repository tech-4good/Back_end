package tech4good.cruds.usecase;

import tech4good.cruds.adapter.EnderecoGateway;
import tech4good.cruds.command.CadastrarEnderecoCommand;
import tech4good.cruds.entity.Endereco;
import tech4good.cruds.exception.ConflitoEntidadeException;
import tech4good.cruds.mapper.EnderecoMapper;

public class CadastrarEnderecoUseCase {
    private final EnderecoGateway gateway;

    public CadastrarEnderecoUseCase(EnderecoGateway gateway) {
        this.gateway = gateway;
    }

    public Endereco executar(CadastrarEnderecoCommand command) {
        if (gateway.existsByCepAndNumero(command.cep().toString(), command.numero())) {
            throw new ConflitoEntidadeException(
                "O endereço com CEP: %s e número: %s já existe no banco de dados"
                .formatted(command.cep(), command.numero())
            );
        }
        var enderecoParaRegistrar = EnderecoMapper.toEntity(command);
        return gateway.save(enderecoParaRegistrar);
    }
}
