package tech4good.tech4good_api.core.application.usecase.voluntario;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import tech4good.tech4good_api.core.adapter.TokenGateway;
import tech4good.tech4good_api.core.adapter.VoluntarioGateway;
import tech4good.tech4good_api.core.application.command.voluntario.AutenticarVoluntarioCommand;
import tech4good.tech4good_api.core.application.dto.voluntario.VoluntarioTokenDto;
import tech4good.tech4good_api.core.application.exception.EntidadeNaoEncontradaException;
import tech4good.tech4good_api.core.domain.voluntario.Voluntario;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Voluntario.VoluntarioMapper;

public class AutenticarVoluntarioUseCase {

    private final VoluntarioGateway voluntarioGateway;
    private final TokenGateway tokenGateway;
    private final AuthenticationManager authenticationManager;

    public AutenticarVoluntarioUseCase(VoluntarioGateway voluntarioGateway,
                                     TokenGateway tokenGateway,
                                     AuthenticationManager authenticationManager) {
        this.voluntarioGateway = voluntarioGateway;
        this.tokenGateway = tokenGateway;
        this.authenticationManager = authenticationManager;
    }

    public VoluntarioTokenDto execute(AutenticarVoluntarioCommand command) {
        final UsernamePasswordAuthenticationToken credentials = new UsernamePasswordAuthenticationToken(
                command.email(), command.senha()
        );

        final Authentication authentication = this.authenticationManager.authenticate(credentials);

        Voluntario voluntarioAutenticado = voluntarioGateway.buscarPorEmail(command.email());

        if (voluntarioAutenticado == null) {
            throw new EntidadeNaoEncontradaException("Email do usuário não cadastrado");
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        final String token = tokenGateway.generateToken(authentication);

        return VoluntarioMapper.toVoluntarioTokenDto(voluntarioAutenticado, token);
    }
}
