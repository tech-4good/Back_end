package tech4good.tech4good_api.core.application.command.auxiliogovernamental;

import tech4good.tech4good_api.core.domain.auxiliogovernamental.valueobject.Auxilio;

public record CadastrarAuxilioGovernamentalCommand(
    Auxilio tipo
) {
}
