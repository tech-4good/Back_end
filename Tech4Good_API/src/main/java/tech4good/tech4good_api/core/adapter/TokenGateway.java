package tech4good.tech4good_api.core.adapter;

import org.springframework.security.core.Authentication;

public interface TokenGateway {
    String generateToken(Authentication authentication);
}
