package tech4good.tech4good_api.core.application.usecase.auxiliogovernamental;

import tech4good.tech4good_api.core.adapter.AuxilioGovernamentalGateway;
import tech4good.tech4good_api.core.application.command.auxiliogovernamental.RemoverAuxilioGovernamentalPorIdCommand;
import tech4good.tech4good_api.core.application.exception.EntidadeNaoEncontradaException;

public class RemoverAuxilioGovernamentalPorIdUseCase {
    private final AuxilioGovernamentalGateway gateway;

    public RemoverAuxilioGovernamentalPorIdUseCase(AuxilioGovernamentalGateway gateway) {
        this.gateway = gateway;
    }

    public void executar(RemoverAuxilioGovernamentalPorIdCommand command) {
        Integer id = command.id();
        if (gateway.existsById(id)) {
            gateway.deleteById(id);
        } else {
            throw new EntidadeNaoEncontradaException("AuxilioGovernamental de id %d não encontrado".formatted(id));
        }
    }
}
