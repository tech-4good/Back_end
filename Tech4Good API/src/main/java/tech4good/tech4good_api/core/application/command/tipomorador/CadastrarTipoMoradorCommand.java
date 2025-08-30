package tech4good.tech4good_api.core.application.command.tipomorador;

import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;
import tech4good.tech4good_api.core.domain.endereco.Endereco;

public record CadastrarTipoMoradorCommand(Integer quantidadeCrianca,
 Integer quantidadeAdolescente,
 Integer quantidadeJovem,
 Integer quantidadeIdoso,
 Integer quantidadeGestante,
 Integer quantidadeDeficiente,
 Integer quantidadeOutros,
 Integer beneficiadoId,
 Integer enderecoId) {
}
