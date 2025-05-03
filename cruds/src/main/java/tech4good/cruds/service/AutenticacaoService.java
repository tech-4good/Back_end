package tech4good.cruds.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tech4good.cruds.dto.voluntario.VoluntarioDetalhesDto;
import tech4good.cruds.entity.Voluntario;
import tech4good.cruds.repository.VoluntarioRepository;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {

    private final VoluntarioRepository voluntarioRepository;

    public AutenticacaoService(VoluntarioRepository voluntarioRepository) {
        this.voluntarioRepository = voluntarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Voluntario> voluntarioOpt = voluntarioRepository.findByEmail(username);

        if (voluntarioOpt.isEmpty()) {
            throw new UsernameNotFoundException(String.format("Usuario: %s não encontrado", username));
        }

        return new VoluntarioDetalhesDto(voluntarioOpt.get());
    }
}
