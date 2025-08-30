package tech4good.tech4good_api.core.application.usecase.beneficiado;

import tech4good.tech4good_api.core.adapter.BeneficiadoGateway;
import tech4good.tech4good_api.core.application.command.beneficiado.CadastrarBeneficiadoCommand;
import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Beneficiado.BeneficiadoMapper;

public class CadastrarBeneficiadoUseCase {
    private final BeneficiadoGateway gateway;

    public CadastrarBeneficiadoUseCase(BeneficiadoGateway gateway) {
        this.gateway = gateway;
    }

    public Beneficiado executar(CadastrarBeneficiadoCommand command) {
        if (gateway.existsByCpf(command.cpf().toString())) {
            throw new IllegalArgumentException("CPF já existe na base de dados");
        }

        var beneficiadoParaRegistrar = BeneficiadoMapper.toDomain(command);

        return gateway.save(beneficiadoParaRegistrar);
    }
}
