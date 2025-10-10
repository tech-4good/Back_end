package tech4good.tech4good_api.core.application.command.filhobeneficiado;

import java.time.LocalDate;

public record CriarFilhoBeneficiadoCommand(
    LocalDate dataNascimento,
    Boolean isEstudante,
    Boolean hasCreche,
    Integer beneficiadoId,
    Integer enderecoId
) {
}
