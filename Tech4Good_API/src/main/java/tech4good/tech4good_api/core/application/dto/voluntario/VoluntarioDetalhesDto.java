package tech4good.tech4good_api.core.application.dto.voluntario;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import tech4good.tech4good_api.core.domain.voluntario.Voluntario;

import java.util.Collection;
import java.util.List;

public class VoluntarioDetalhesDto implements UserDetails {
    private final String nome;
    private final String email;
    private final String senha;

    public VoluntarioDetalhesDto(Voluntario voluntario) {
        this.nome = voluntario.getNome();
        this.email = voluntario.getEmail() != null ? voluntario.getEmail().toString() : null;
        this.senha = voluntario.getSenha();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
