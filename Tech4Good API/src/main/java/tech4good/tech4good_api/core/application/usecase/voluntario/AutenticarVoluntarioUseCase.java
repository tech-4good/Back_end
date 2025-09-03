package tech4good.tech4good_api.core.application.usecase.voluntario;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.server.ResponseStatusException;
import tech4good.tech4good_api.config.jwt.GerenciadorTokenJwt;
import tech4good.tech4good_api.core.adapter.VoluntarioGateway;
import tech4good.tech4good_api.core.application.command.voluntario.AutenticarVoluntarioCommand;
import tech4good.tech4good_api.core.application.dto.voluntario.VoluntarioTokenDto;
import tech4good.tech4good_api.core.domain.voluntario.Voluntario;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Voluntario.VoluntarioMapper;

public class AutenticarVoluntarioUseCase {

    private final VoluntarioGateway voluntarioGateway;
    private final GerenciadorTokenJwt gerenciadorTokenJwt;
    private final AuthenticationManager authenticationManager;

    public AutenticarVoluntarioUseCase(VoluntarioGateway voluntarioGateway,
                                     GerenciadorTokenJwt gerenciadorTokenJwt,
                                     AuthenticationManager authenticationManager) {
        this.voluntarioGateway = voluntarioGateway;
        this.gerenciadorTokenJwt = gerenciadorTokenJwt;
        this.authenticationManager = authenticationManager;
    }

    public VoluntarioTokenDto executar(AutenticarVoluntarioCommand command) {
        final UsernamePasswordAuthenticationToken credentials = new UsernamePasswordAuthenticationToken(
                command.email(), command.senha()
        );

        final Authentication authentication = this.authenticationManager.authenticate(credentials);

        Voluntario voluntarioAutenticado = voluntarioGateway.buscarPorEmail(command.email());

        if (voluntarioAutenticado == null) {
            throw new ResponseStatusException(404, "Email do usuário não cadastrado", null);
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        final String token = gerenciadorTokenJwt.generateToken(authentication);

        return VoluntarioMapper.toVoluntarioTokenDto(voluntarioAutenticado, token);
    }
}
