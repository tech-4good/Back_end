package tech4good.tech4good_api.core.application.command.endereco;

import tech4good.tech4good_api.core.domain.endereco.valueobjects.Status;

public record AtualizarEnderecoCommand(Integer id, Status status) {
}

