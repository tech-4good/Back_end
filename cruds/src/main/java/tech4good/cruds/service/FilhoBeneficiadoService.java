package tech4good.cruds.service;

import org.springframework.stereotype.Service;
import tech4good.cruds.repository.FilhoBeneficiadoRepository;

@Service
public class FilhoBeneficiadoService {

    private final FilhoBeneficiadoRepository filhoBeneficiadoRepository;

    public FilhoBeneficiadoService(FilhoBeneficiadoRepository filhoBeneficiadoRepository) {
        this.filhoBeneficiadoRepository = filhoBeneficiadoRepository;
    }
}
