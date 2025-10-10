package tech4good.tech4good_api.core.application.command.entrega;

import java.time.LocalDate;

public record CadastrarEntregaCommand(
    LocalDate dataRetirada,
    LocalDate proximaRetirada,
    Integer enderecoId,
    Integer cestaId,
    Integer voluntarioId,
    Integer beneficiadoId
) {
}
