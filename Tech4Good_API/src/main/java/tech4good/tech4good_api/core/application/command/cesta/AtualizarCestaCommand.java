package tech4good.tech4good_api.core.application.command.cesta;

public record AtualizarCestaCommand(
        Integer id,
        Integer quantidadeCestas
) {}
