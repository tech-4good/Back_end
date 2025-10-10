package tech4good.tech4good_api.core.application.usecase.beneficiado;

import tech4good.tech4good_api.core.adapter.BeneficiadoGateway;
import tech4good.tech4good_api.core.application.command.beneficiado.RemoverBeneficiadoPorIdCommand;
import tech4good.tech4good_api.core.application.exception.EntidadeNaoEncontradaException;

public class RemoverBeneficiadoPorIdUseCase {
    private final BeneficiadoGateway gateway;

    public RemoverBeneficiadoPorIdUseCase(BeneficiadoGateway gateway) {
        this.gateway = gateway;
    }

    public void executar(RemoverBeneficiadoPorIdCommand command) {
        Integer id = command.id();
        if (gateway.existsById(id)) {
            gateway.deleteById(id);
        } else {
            throw new EntidadeNaoEncontradaException("Beneficiado de id %d não encontrado".formatted(id));
        }
    }
}

