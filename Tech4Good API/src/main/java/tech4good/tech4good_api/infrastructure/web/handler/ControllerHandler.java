package tech4good.tech4good_api.infrastructure.web.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tech4good.tech4good_api.core.application.exception.ConflitoEntidadeException;
import tech4good.tech4good_api.core.application.exception.EntidadeNaoEncontradaException;

import java.util.Map;

@RestControllerAdvice
public class ControllerHandler {

    public ResponseEntity<Map<String, String>> conflito (ConflitoEntidadeException ex) {
        Map<String, String> error = Map.of(
                "erro:", "Erro de conflito de entidade: %s".formatted(ex.getMessage())
        );

        return ResponseEntity.status(409).body(error);
    }

    public ResponseEntity<Map<String, String>> naoEncontrada (EntidadeNaoEncontradaException ex) {
        Map<String, String> error = Map.of(
                "erro:", "Erro de entidade não encontrada: %s".formatted(ex.getMessage())
        );

        return ResponseEntity.status(404).body(error);
    }
}
