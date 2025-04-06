package tech4good.cruds.service;

import org.springframework.stereotype.Service;
import tech4good.cruds.repository.BeneficiadoHasAuxilioRepository;

@Service
public class BeneficiadoHasAuxilioService {

    private final BeneficiadoHasAuxilioRepository beneficiadoHasAuxilioRepository;

    public BeneficiadoHasAuxilioService(BeneficiadoHasAuxilioRepository beneficiadoHasAuxilioRepository) {
        this.beneficiadoHasAuxilioRepository = beneficiadoHasAuxilioRepository;
    }
}
