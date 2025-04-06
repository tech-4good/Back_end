package tech4good.cruds.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech4good.cruds.service.FilhoBeneficiadoService;

@RestController
@RequestMapping("/filhos-beneficiados")
public class FilhoBeneficiadoController {

    private final FilhoBeneficiadoService filhoBeneficiadoService;

    public FilhoBeneficiadoController(FilhoBeneficiadoService filhoBeneficiadoService) {
        this.filhoBeneficiadoService = filhoBeneficiadoService;
    }
}
