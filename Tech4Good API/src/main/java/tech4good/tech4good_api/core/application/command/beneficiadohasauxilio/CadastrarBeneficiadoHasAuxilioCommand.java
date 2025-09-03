package tech4good.tech4good_api.core.application.command.beneficiadohasauxilio;

public record CadastrarBeneficiadoHasAuxilioCommand(
    Integer beneficiadoId,
    Integer auxilioGovernamentalId
) {
}
