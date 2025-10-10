package tech4good.tech4good_api.config.jwt;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import tech4good.tech4good_api.core.adapter.TokenGateway;

@Component
public class TokenGatewayAdapter implements TokenGateway {

    private final GerenciadorTokenJwt gerenciadorTokenJwt;

    public TokenGatewayAdapter(GerenciadorTokenJwt gerenciadorTokenJwt) {
        this.gerenciadorTokenJwt = gerenciadorTokenJwt;
    }

    @Override
    public String generateToken(Authentication authentication) {
        return gerenciadorTokenJwt.generateToken(authentication);
    }
}
