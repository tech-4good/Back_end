package tech4good.tech4good_api.core.application.usecase.filhobeneficiado;

import tech4good.tech4good_api.core.adapter.FilhoBeneficiadoGateway;
import tech4good.tech4good_api.core.adapter.BeneficiadoGateway;
import tech4good.tech4good_api.core.adapter.EnderecoGateway;
import tech4good.tech4good_api.core.application.command.filhobeneficiado.CriarFilhoBeneficiadoCommand;
import tech4good.tech4good_api.core.domain.filhobeneficiado.FilhoBeneficiado;
import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;
import tech4good.tech4good_api.core.domain.endereco.Endereco;

public class CriarFilhoBeneficiadoUseCase {
    private final FilhoBeneficiadoGateway gateway;
    private final BeneficiadoGateway beneficiadoGateway;
    private final EnderecoGateway enderecoGateway;

    public CriarFilhoBeneficiadoUseCase(FilhoBeneficiadoGateway gateway, BeneficiadoGateway beneficiadoGateway, EnderecoGateway enderecoGateway) {
        this.gateway = gateway;
        this.beneficiadoGateway = beneficiadoGateway;
        this.enderecoGateway = enderecoGateway;
    }

    public FilhoBeneficiado executar(CriarFilhoBeneficiadoCommand command) {
        Beneficiado beneficiado = beneficiadoGateway.findById(command.beneficiadoId());
        Endereco endereco = enderecoGateway.findById(command.enderecoId()).orElseThrow(
            () -> new IllegalArgumentException("Endereço não encontrado com ID: " + command.enderecoId())
        );

        FilhoBeneficiado filho = new FilhoBeneficiado(
            null,
            command.dataNascimento(),
            command.isEstudante(),
            command.hasCreche(),
            beneficiado,
            endereco
        );

        return gateway.save(filho);
    }
}
