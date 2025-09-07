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
        System.out.println("[DEBUG AUTH] Tentando buscar usuário: " + username);
        try {
            Voluntario voluntario = voluntarioGateway.buscarPorEmail(username);
            System.out.println("[DEBUG AUTH] Usuário encontrado: " + voluntario.getNome());
            System.out.println("[DEBUG AUTH] Email do usuário: " + voluntario.getEmail());
            System.out.println("[DEBUG AUTH] Senha hash: " + voluntario.getSenha());
            return new VoluntarioDetalhesDto(voluntario);
        } catch (Exception e) {
            System.out.println("[DEBUG AUTH] Erro ao buscar usuário: " + e.getMessage());
            throw new UsernameNotFoundException(String.format("Usuario: %s não encontrado", username));
        }
    }
}
