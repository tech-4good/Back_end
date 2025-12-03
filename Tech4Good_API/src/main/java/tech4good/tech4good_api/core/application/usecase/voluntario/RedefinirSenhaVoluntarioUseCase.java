package tech4good.tech4good_api.core.application.usecase.voluntario;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import tech4good.tech4good_api.core.adapter.VoluntarioGateway;
import tech4good.tech4good_api.core.application.command.voluntario.RedefinirSenhaVoluntarioCommand;
import tech4good.tech4good_api.core.application.exception.EntidadeNaoEncontradaException;
import tech4good.tech4good_api.core.domain.voluntario.Voluntario;

@Slf4j
public class RedefinirSenhaVoluntarioUseCase {

    private final VoluntarioGateway voluntarioGateway;
    private final PasswordEncoder passwordEncoder;

    public RedefinirSenhaVoluntarioUseCase(VoluntarioGateway voluntarioGateway, PasswordEncoder passwordEncoder) {
        this.voluntarioGateway = voluntarioGateway;
        this.passwordEncoder = passwordEncoder;
    }

    public void execute(RedefinirSenhaVoluntarioCommand command) {
        log.info("Redefinindo senha para o email: {}", command.email());

        Voluntario voluntario = voluntarioGateway.buscarPorEmail(command.email());

        if (voluntario == null) {
            throw new EntidadeNaoEncontradaException("Voluntário com e-mail %s não encontrado".formatted(command.email()));
        }

        // Criptografa a nova senha
        String novaSenhaCriptografada = passwordEncoder.encode(command.novaSenha());
        voluntario.setSenha(novaSenhaCriptografada);

        voluntarioGateway.salvar(voluntario);

        log.info("Senha redefinida com sucesso para: {}", command.email());
    }
}
