package tech4good.cruds.dto.voluntario;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import tech4good.cruds.entity.Voluntario;

import java.util.Collection;
import java.util.List;

public class VoluntarioDetalhesDto implements UserDetails {
    private final String nome;
    private final String email;
    private final String senha;

    public VoluntarioDetalhesDto(Voluntario voluntario) {
        this.nome = voluntario.getNome();
        this.email = voluntario.getEmail();
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
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
