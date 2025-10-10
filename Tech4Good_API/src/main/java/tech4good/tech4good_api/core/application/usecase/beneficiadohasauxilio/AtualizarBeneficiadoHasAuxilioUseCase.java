package tech4good.tech4good_api.core.application.usecase.beneficiadohasauxilio;

import tech4good.tech4good_api.core.adapter.BeneficiadoHasAuxilioGateway;
import tech4good.tech4good_api.core.adapter.BeneficiadoGateway;
import tech4good.tech4good_api.core.adapter.AuxilioGovernamentalGateway;
import tech4good.tech4good_api.core.application.command.beneficiadohasauxilio.AtualizarBeneficiadoHasAuxilioCommand;
import tech4good.tech4good_api.core.domain.beneficiadohasauxilio.BeneficiadoHasAuxilio;

public class AtualizarBeneficiadoHasAuxilioUseCase {
    private final BeneficiadoHasAuxilioGateway gateway;
    private final BeneficiadoGateway beneficiadoGateway;
    private final AuxilioGovernamentalGateway auxilioGovernamentalGateway;

    public AtualizarBeneficiadoHasAuxilioUseCase(BeneficiadoHasAuxilioGateway gateway,
                                               BeneficiadoGateway beneficiadoGateway,
                                               AuxilioGovernamentalGateway auxilioGovernamentalGateway) {
        this.gateway = gateway;
        this.beneficiadoGateway = beneficiadoGateway;
        this.auxilioGovernamentalGateway = auxilioGovernamentalGateway;
    }

    public BeneficiadoHasAuxilio executar(Integer id, AtualizarBeneficiadoHasAuxilioCommand command) {
        // Busca a relação existente
        BeneficiadoHasAuxilio existente = gateway.findById(id);

        // Verifica se o beneficiado existe
        var beneficiado = beneficiadoGateway.findById(command.beneficiadoId());

        // Verifica se o auxílio governamental existe
        var auxilioGovernamental = auxilioGovernamentalGateway.findById(command.auxilioGovernamentalId());

        // Cria a relação atualizada
        var beneficiadoHasAuxilioAtualizado = new BeneficiadoHasAuxilio(
            existente.getId(),
            auxilioGovernamental,
            beneficiado
        );

        return gateway.save(beneficiadoHasAuxilioAtualizado);
    }
}
