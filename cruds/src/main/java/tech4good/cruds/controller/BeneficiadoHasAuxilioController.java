package tech4good.cruds.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech4good.cruds.service.BeneficiadoHasAuxilioService;

@RestController
@RequestMapping("/beneficiado-has-auxilios")
public class BeneficiadoHasAuxilioController {

    private final BeneficiadoHasAuxilioService beneficiadoHasAuxilioService;

    public BeneficiadoHasAuxilioController(BeneficiadoHasAuxilioService beneficiadoHasAuxilioService) {
        this.beneficiadoHasAuxilioService = beneficiadoHasAuxilioService;
    }
}
