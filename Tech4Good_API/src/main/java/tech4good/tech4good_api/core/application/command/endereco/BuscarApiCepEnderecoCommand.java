package tech4good.tech4good_api.core.application.command.endereco;

import tech4good.tech4good_api.core.domain.endereco.valueobjects.Bairro;
import tech4good.tech4good_api.core.domain.endereco.valueobjects.Cep;
import tech4good.tech4good_api.core.domain.endereco.valueobjects.Cidade;
import tech4good.tech4good_api.core.domain.endereco.valueobjects.Estado;

public record BuscarApiCepEnderecoCommand(Cep cep) {
}
