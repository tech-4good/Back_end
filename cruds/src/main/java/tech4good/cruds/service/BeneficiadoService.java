package tech4good.cruds.service;

import org.springframework.stereotype.Service;
import tech4good.cruds.repository.BeneficiadoRepository;

@Service
public class BeneficiadoService {

    private final BeneficiadoRepository beneficiadoRepository;

    public BeneficiadoService(BeneficiadoRepository beneficiadoRepository) {
        this.beneficiadoRepository = beneficiadoRepository;
    }
}
