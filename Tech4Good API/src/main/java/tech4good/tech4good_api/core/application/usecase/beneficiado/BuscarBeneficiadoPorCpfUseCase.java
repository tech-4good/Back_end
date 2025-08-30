package tech4good.tech4good_api.core.application.usecase.beneficiado;

import tech4good.tech4good_api.core.adapter.BeneficiadoGateway;
import tech4good.tech4good_api.core.application.command.beneficiado.BuscarBeneficiadoPorCpfCommand;
import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;
import tech4good.tech4good_api.core.application.exception.EntidadeNaoEncontradaException;

public class BuscarBeneficiadoPorCpfUseCase {
    private final BeneficiadoGateway gateway;

    public BuscarBeneficiadoPorCpfUseCase(BeneficiadoGateway gateway) {
        this.gateway = gateway;
    }

    public Beneficiado executar(BuscarBeneficiadoPorCpfCommand command) {
        String cpf = command.cpf().toString();
        if (gateway.existsByCpf(cpf)) {
            return gateway.findByCpf(cpf);
        } else {
            throw new EntidadeNaoEncontradaException("Beneficiado com CPF %s não encontrado".formatted(cpf));
        }
    }
}

