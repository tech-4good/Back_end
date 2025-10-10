package tech4good.tech4good_api.core.application.command.voluntario;

public record AutenticarVoluntarioCommand(
        String email,
        String senha
) {
}
