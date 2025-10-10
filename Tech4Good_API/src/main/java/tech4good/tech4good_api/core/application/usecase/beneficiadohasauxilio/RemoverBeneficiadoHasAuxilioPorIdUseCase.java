package tech4good.tech4good_api.core.application.usecase.beneficiadohasauxilio;

import tech4good.tech4good_api.core.adapter.BeneficiadoHasAuxilioGateway;
import tech4good.tech4good_api.core.application.command.beneficiadohasauxilio.RemoverBeneficiadoHasAuxilioPorIdCommand;
import tech4good.tech4good_api.core.application.exception.EntidadeNaoEncontradaException;

public class RemoverBeneficiadoHasAuxilioPorIdUseCase {
    private final BeneficiadoHasAuxilioGateway gateway;

    public RemoverBeneficiadoHasAuxilioPorIdUseCase(BeneficiadoHasAuxilioGateway gateway) {
        this.gateway = gateway;
    }

    public void executar(RemoverBeneficiadoHasAuxilioPorIdCommand command) {
        Integer id = command.id();
        if (gateway.existsById(id)) {
            gateway.deleteById(id);
        } else {
            throw new EntidadeNaoEncontradaException("BeneficiadoHasAuxilio de id %d não encontrado".formatted(id));
        }
    }
}
