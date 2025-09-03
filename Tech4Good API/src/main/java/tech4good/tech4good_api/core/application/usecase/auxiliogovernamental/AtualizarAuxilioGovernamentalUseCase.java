package tech4good.tech4good_api.core.application.usecase.auxiliogovernamental;

import tech4good.tech4good_api.core.adapter.AuxilioGovernamentalGateway;
import tech4good.tech4good_api.core.application.command.auxiliogovernamental.AtualizarAuxilioGovernamentalCommand;
import tech4good.tech4good_api.core.domain.auxiliogovernamental.AuxilioGovernamental;

public class AtualizarAuxilioGovernamentalUseCase {
    private final AuxilioGovernamentalGateway gateway;

    public AtualizarAuxilioGovernamentalUseCase(AuxilioGovernamentalGateway gateway) {
        this.gateway = gateway;
    }

    public AuxilioGovernamental executar(Integer id, AtualizarAuxilioGovernamentalCommand command) {
        AuxilioGovernamental auxilioExistente = gateway.findById(id);

        AuxilioGovernamental auxilioAtualizado = new AuxilioGovernamental(
            auxilioExistente.getId(),
            command.tipo() != null ? command.tipo() : auxilioExistente.getTipo()
        );

        return gateway.save(auxilioAtualizado);
    }
}
