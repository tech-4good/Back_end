package tech4good.tech4good_api.core.application.usecase.beneficiado;

import tech4good.tech4good_api.core.adapter.BeneficiadoGateway;
import tech4good.tech4good_api.core.application.command.beneficiado.AtualizarBeneficiadoCommand;
import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;
import tech4good.tech4good_api.core.application.exception.EntidadeNaoEncontradaException;

public class AtualizarBeneficiadoUseCase {
    private final BeneficiadoGateway gateway;

    public AtualizarBeneficiadoUseCase(BeneficiadoGateway gateway) {
        this.gateway = gateway;
    }

    public Beneficiado executar(Integer id, AtualizarBeneficiadoCommand command) {

        if (gateway.existsById(id)) {
            throw new IllegalArgumentException("ID já existe na base de dados");
        }

        if (gateway.findById(id).isEmpty()) {
            throw new EntidadeNaoEncontradaException("Beneficiado com ID " + id + " não encontrado.");
        }

        Beneficiado beneficiadoExistente = gateway.findById(id).get();

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
                command.endereco(),
                command.quantidadeDependentes(),
                beneficiadoExistente.getFotoBeneficiado()
        );

        return gateway.save(beneficiadoAtualizado);
    }
}