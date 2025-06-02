package tech4good.cruds.service;

import org.springframework.stereotype.Service;
import tech4good.cruds.repository.FilaEsperaRepository;
import tech4good.cruds.entity.FilaEspera;
import java.util.List;

@Service
public class FilaEsperaService {

    private final FilaEsperaRepository filaEsperaRepository;

    public FilaEsperaService(FilaEsperaRepository filaEsperaRepository) {
        this.filaEsperaRepository = filaEsperaRepository;
    }

    public List<FilaEspera> listarFilaEspera() {
        return filaEsperaRepository.findAll();
    }

}
