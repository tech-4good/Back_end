package tech4good.tech4good_api.config.jwt;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import tech4good.tech4good_api.infrastructure.security.AutenticacaoService;

public class AutenticacaoProvider implements AuthenticationProvider {

    private final AutenticacaoService usuarioAutorizacaoService;
    private final PasswordEncoder passwordEncoder;

    public AutenticacaoProvider(AutenticacaoService usuarioAutorizacaoService, PasswordEncoder passwordEncoder) {
        this.usuarioAutorizacaoService = usuarioAutorizacaoService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
        final String username = authentication.getName();
        final String password = authentication.getCredentials().toString();

        System.out.println("[DEBUG PROVIDER] Iniciando autenticação para: " + username);
        System.out.println("[DEBUG PROVIDER] Senha fornecida: " + password);

        UserDetails userDetails = this.usuarioAutorizacaoService.loadUserByUsername(username);

        System.out.println("[DEBUG PROVIDER] UserDetails carregado - Username: " + userDetails.getUsername());
        System.out.println("[DEBUG PROVIDER] Hash da senha no banco: " + userDetails.getPassword());

        if (this.passwordEncoder.matches(password, userDetails.getPassword())) {
            System.out.println("[DEBUG PROVIDER] ✅ Senha VÁLIDA - Autenticação bem-sucedida!");
            return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        } else {
            System.out.println("[DEBUG PROVIDER] ❌ Senha INVÁLIDA - Falha na autenticação!");
            throw new BadCredentialsException("Usuário ou Senha inválidos");
        }
    }

    @Override
    public boolean supports(final Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
