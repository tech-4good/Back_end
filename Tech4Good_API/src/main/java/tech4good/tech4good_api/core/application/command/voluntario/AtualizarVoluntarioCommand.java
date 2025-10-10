package tech4good.tech4good_api.core.application.command.voluntario;

import tech4good.tech4good_api.core.domain.shared.valueobject.Telefone;
import tech4good.tech4good_api.core.domain.voluntario.valueobject.Email;

public record AtualizarVoluntarioCommand(Integer id, Telefone telefone, Email email) {
}
