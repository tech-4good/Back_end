package tech4good.tech4good_api.infrastructure.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tech4good.tech4good_api.core.adapter.VoluntarioGateway;
import tech4good.tech4good_api.core.application.dto.voluntario.VoluntarioDetalhesDto;
import tech4good.tech4good_api.core.domain.voluntario.Voluntario;

@Service
public class AutenticacaoService implements UserDetailsService {

    private final VoluntarioGateway voluntarioGateway;

    public AutenticacaoService(VoluntarioGateway voluntarioGateway) {
        this.voluntarioGateway = voluntarioGateway;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Voluntario voluntario = voluntarioGateway.buscarPorEmail(username);
            return new VoluntarioDetalhesDto(voluntario);
        } catch (Exception e) {
            throw new UsernameNotFoundException(String.format("Usuario: %s não encontrado", username));
        }
    }
}
