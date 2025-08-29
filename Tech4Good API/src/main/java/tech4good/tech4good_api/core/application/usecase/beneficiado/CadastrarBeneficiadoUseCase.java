package tech4good.tech4good_api.core.application.usecase.beneficiado;

import tech4good.tech4good_api.core.application.adapter.BeneficiadoGateway;
import tech4good.tech4good_api.core.application.command.beneficiado.CadastrarBeneficiadoCommand;
import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;

public class CadastrarBeneficiadoUseCase {
    private final BeneficiadoGateway gateway;

    public CadastrarBeneficiadoUseCase(BeneficiadoGateway gateway) {
        this.gateway = gateway;
    }

    public Beneficiado executar(CadastrarBeneficiadoCommand command) {
        if (gateway.existsByCpf(command.cpf())) {
            throw new IllegalArgumentException("CPF já existe na base de dados");
        }

        var beneficiadoParaRegistrar = new Beneficiado(
                null,
                command.cpf(),
                command.nome(),
                command.rg(),
                command.dataNascimento(),
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
                null
        );

        return gateway.save(beneficiadoParaRegistrar);
    }
}
