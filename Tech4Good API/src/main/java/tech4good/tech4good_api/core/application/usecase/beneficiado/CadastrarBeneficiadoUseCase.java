package tech4good.tech4good_api.core.application.usecase.beneficiado;

import tech4good.tech4good_api.core.adapter.BeneficiadoGateway;
import tech4good.tech4good_api.core.adapter.EnderecoGateway;
import tech4good.tech4good_api.core.application.command.beneficiado.CadastrarBeneficiadoCommand;
import tech4good.tech4good_api.core.application.exception.EntidadeNaoEncontradaException;
import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;
import tech4good.tech4good_api.core.domain.endereco.Endereco;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Beneficiado.BeneficiadoMapper;

public class CadastrarBeneficiadoUseCase {
    private final BeneficiadoGateway gateway;
    private final EnderecoGateway enderecoGateway;

    public CadastrarBeneficiadoUseCase(BeneficiadoGateway gateway, EnderecoGateway enderecoGateway) {
        this.gateway = gateway;
        this.enderecoGateway = enderecoGateway;
    }

    public Beneficiado executar(CadastrarBeneficiadoCommand command) {
        if (gateway.existsByCpf(command.cpf().toString())) {
            throw new IllegalArgumentException("CPF já existe na base de dados");
        }

        // Cria o objeto beneficiado a partir do command
        var beneficiadoParaRegistrar = BeneficiadoMapper.toDomain(command);

        // Se tiver enderecoId, busca o endereço e associa ao beneficiado
        if (command.enderecoId() != null) {
            Endereco endereco = enderecoGateway.findById(command.enderecoId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Endereço não encontrado com ID: " + command.enderecoId()));

            beneficiadoParaRegistrar.setEndereco(endereco);
        }

        return gateway.save(beneficiadoParaRegistrar);
    }
}
