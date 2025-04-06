package tech4good.cruds.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech4good.cruds.service.FilaEsperaService;

@RestController
@RequestMapping("/fila-esperas")
public class FilaEsperaController {

    private final FilaEsperaService filaEsperaService;

    public FilaEsperaController(FilaEsperaService filaEsperaService) {
        this.filaEsperaService = filaEsperaService;
    }
}
