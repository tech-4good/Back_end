package tech4good.cruds.service;

import org.springframework.stereotype.Service;
import tech4good.cruds.repository.TipoMoradorRepository;

@Service
public class TipoMoradorService {

    private final TipoMoradorRepository tipoMoradorRepository;

    public TipoMoradorService(TipoMoradorRepository tipoMoradorRepository) {
        this.tipoMoradorRepository = tipoMoradorRepository;
    }
}
