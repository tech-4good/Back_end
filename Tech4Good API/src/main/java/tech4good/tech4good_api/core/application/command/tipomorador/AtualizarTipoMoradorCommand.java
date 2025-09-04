package tech4good.tech4good_api.core.application.command.tipomorador;

public record AtualizarTipoMoradorCommand(
        Integer id,
        Integer quantidadeCrianca,
        Integer quantidadeAdolescente,
        Integer quantidadeJovem,
        Integer quantidadeIdoso,
        Integer quantidadeGestante,
        Integer quantidadeDeficiente,
        Integer quantidadeOutros
) {
}
