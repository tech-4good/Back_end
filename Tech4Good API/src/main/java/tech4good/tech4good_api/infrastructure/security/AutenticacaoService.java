package tech4good.tech4good_api.infrastructure.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tech4good.tech4good_api.core.domain.voluntario.Voluntario;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Voluntario.VoluntarioJpaRepository;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {

    private final VoluntarioJpaRepository voluntarioJpaRepository;

    public AutenticacaoService(VoluntarioJpaRepository voluntarioJpaRepository) {
        this.voluntarioJpaRepository = voluntarioJpaRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Voluntario> voluntarioOpt = voluntarioJpaRepository.findByEmail(username);

        if (voluntarioOpt.isEmpty()) {
            throw new UsernameNotFoundException(String.format("Usuario: %s não encontrado", username));
        }

//        return new VoluntarioDetalhesDto(voluntarioOpt.get());
        return null;
    }
}
