package tech4good.cruds.service;

import org.springframework.stereotype.Service;
import tech4good.cruds.repository.FilaEsperaRepository;

@Service
public class FilaEsperaService {

    private final FilaEsperaRepository filaEsperaRepository;

    public FilaEsperaService(FilaEsperaRepository filaEsperaRepository) {
        this.filaEsperaRepository = filaEsperaRepository;
    }



}
