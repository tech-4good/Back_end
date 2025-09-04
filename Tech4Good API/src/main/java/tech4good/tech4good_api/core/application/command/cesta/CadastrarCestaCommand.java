package tech4good.tech4good_api.core.application.command.cesta;

import java.time.LocalDate;

public record CadastrarCestaCommand(
        String tipo,
        Double pesoKg,
        LocalDate dataEntradaEstoque,
        Integer quantidadeCestas
) {}
