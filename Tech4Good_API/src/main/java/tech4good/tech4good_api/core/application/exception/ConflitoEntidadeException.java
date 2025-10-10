package tech4good.tech4good_api.core.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ConflitoEntidadeException extends RuntimeException {
    public ConflitoEntidadeException(String message) {
        super(message);
    }
}
