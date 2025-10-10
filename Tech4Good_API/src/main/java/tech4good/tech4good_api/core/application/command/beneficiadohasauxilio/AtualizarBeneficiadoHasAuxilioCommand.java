package tech4good.tech4good_api.core.application.command.beneficiadohasauxilio;

public record AtualizarBeneficiadoHasAuxilioCommand(
    Integer beneficiadoId,
    Integer auxilioGovernamentalId
) {
}
