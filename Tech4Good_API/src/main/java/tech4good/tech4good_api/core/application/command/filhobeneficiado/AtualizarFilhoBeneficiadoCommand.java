package tech4good.tech4good_api.core.application.command.filhobeneficiado;

public record AtualizarFilhoBeneficiadoCommand(
    Integer id,
    Boolean isEstudante,
    Boolean hasCreche
) {
}
