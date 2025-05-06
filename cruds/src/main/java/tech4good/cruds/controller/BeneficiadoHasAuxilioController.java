package tech4good.cruds.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech4good.cruds.service.BeneficiadoHasAuxilioService;

@Tag(name = "Controller - Auxiliar entre Beneficiado e Auxílio", description = "Operações relacionadas aos beneficiados e seus respectivos auxílios.")
@RestController
@RequestMapping("/beneficiado-has-auxilios")
public class BeneficiadoHasAuxilioController {

    private final BeneficiadoHasAuxilioService beneficiadoHasAuxilioService;

    public BeneficiadoHasAuxilioController(BeneficiadoHasAuxilioService beneficiadoHasAuxilioService) {
        this.beneficiadoHasAuxilioService = beneficiadoHasAuxilioService;
    }
}
