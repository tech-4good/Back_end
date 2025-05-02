package tech4good.cruds.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech4good.cruds.service.FilaEsperaService;

@Tag(name = "Controller - Fila de Espera", description = "Operações relacionadas a fila de espera das cestas básicas.")
@RestController
@RequestMapping("/fila-esperas")
public class FilaEsperaController {

    private final FilaEsperaService filaEsperaService;

    public FilaEsperaController(FilaEsperaService filaEsperaService) {
        this.filaEsperaService = filaEsperaService;
    }
}
