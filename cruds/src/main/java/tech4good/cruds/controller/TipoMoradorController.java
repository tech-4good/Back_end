package tech4good.cruds.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech4good.cruds.service.TipoMoradorService;

@RestController
@RequestMapping("/tipo-moradores")
public class TipoMoradorController {

    private final TipoMoradorService tipoMoradorService;

    public TipoMoradorController(TipoMoradorService tipoMoradorService) {
        this.tipoMoradorService = tipoMoradorService;
    }
}
