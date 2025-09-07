package tech4good.tech4good_api.core.application.usecase.beneficiado;

import tech4good.tech4good_api.core.adapter.BeneficiadoGateway;
import tech4good.tech4good_api.core.adapter.EnderecoGateway;
import tech4good.tech4good_api.core.application.command.beneficiado.AtualizarBeneficiadoCommand;
import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;
import tech4good.tech4good_api.core.domain.endereco.Endereco;
import tech4good.tech4good_api.core.application.exception.EntidadeNaoEncontradaException;

import java.util.Optional;

public class AtualizarBeneficiadoUseCase {
    private final BeneficiadoGateway beneficiadoGateway;
    private final EnderecoGateway enderecoGateway;

    public AtualizarBeneficiadoUseCase(BeneficiadoGateway beneficiadoGateway, EnderecoGateway enderecoGateway) {
        this.beneficiadoGateway = beneficiadoGateway;
        this.enderecoGateway = enderecoGateway;
    }

    public Beneficiado executar(Integer id, AtualizarBeneficiadoCommand command) {

        if (!beneficiadoGateway.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Beneficiado não encontrado com ID: " + id);
        }

        Beneficiado beneficiadoExistente = beneficiadoGateway.findById(id);

        // Busca o endereço pelo ID se fornecido
        Endereco endereco = beneficiadoExistente.getEndereco(); // mantém o endereço atual por padrão
        if (command.enderecoId() != null) {
            Optional<Endereco> enderecoOpt = enderecoGateway.findById(command.enderecoId());
            if (enderecoOpt.isEmpty()) {
                throw new EntidadeNaoEncontradaException("Endereço não encontrado com ID: " + command.enderecoId());
            }
            endereco = enderecoOpt.get();
        }

        Beneficiado beneficiadoAtualizado = new Beneficiado(
                beneficiadoExistente.getId(),
                beneficiadoExistente.getCpf(),
                beneficiadoExistente.getNome(),
                beneficiadoExistente.getRg(),
                beneficiadoExistente.getDataNascimento(),
                command.naturalidade(),
                command.telefone(),
                command.estadoCivil(),
                command.escolaridade(),
                command.profissao(),
                command.rendaMensal(),
                command.empresa(),
                command.cargo(),
                command.religiao(),
                endereco,
                command.quantidadeDependentes(),
                beneficiadoExistente.getFotoBeneficiado()
        );

        return beneficiadoGateway.save(beneficiadoAtualizado);
    }
}