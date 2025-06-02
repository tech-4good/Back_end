package tech4good.cruds.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech4good.cruds.service.FilaEsperaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import tech4good.cruds.entity.FilaEspera;
import java.util.List;

@Tag(name = "Controller - Fila de Espera", description = "Operações relacionadas a fila de espera das cestas básicas.")
@RestController
@RequestMapping("/fila-esperas")
public class FilaEsperaController {

    private final FilaEsperaService filaEsperaService;

    public FilaEsperaController(FilaEsperaService filaEsperaService) {
        this.filaEsperaService = filaEsperaService;
    }

    @GetMapping
    public ResponseEntity<List<FilaEspera>> listar() {
        List<FilaEspera> fila = filaEsperaService.listarFilaEspera();
        if (fila.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(fila);
    }
}
