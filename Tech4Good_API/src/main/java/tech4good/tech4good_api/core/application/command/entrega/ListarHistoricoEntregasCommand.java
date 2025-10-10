package tech4good.tech4good_api.core.application.command.entrega;

import java.time.LocalDate;

public record ListarHistoricoEntregasCommand(
    Integer idBeneficiado,
    LocalDate dataInicio,
    LocalDate dataFim
) {
}
