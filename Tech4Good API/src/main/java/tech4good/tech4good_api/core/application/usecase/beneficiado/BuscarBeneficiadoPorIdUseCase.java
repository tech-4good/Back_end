package tech4good.tech4good_api.core.application.usecase.beneficiado;

import tech4good.tech4good_api.core.adapter.BeneficiadoGateway;
import tech4good.tech4good_api.core.application.command.beneficiado.BuscarBeneficiadoPorIdCommand;
import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;
import tech4good.tech4good_api.core.application.exception.EntidadeNaoEncontradaException;

public class BuscarBeneficiadoPorIdUseCase {
    private final BeneficiadoGateway gateway;

    public BuscarBeneficiadoPorIdUseCase(BeneficiadoGateway gateway) {
        this.gateway = gateway;
    }

    public Beneficiado executar(BuscarBeneficiadoPorIdCommand command) {
        return gateway.findById(command.id());
    }
}

