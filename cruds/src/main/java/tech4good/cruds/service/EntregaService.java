package tech4good.cruds.service;

import org.springframework.stereotype.Service;
import tech4good.cruds.repository.EntregaRepository;

@Service
public class EntregaService {

    private final EntregaRepository entregaRepository;

    public EntregaService(EntregaRepository entregaRepository) {
        this.entregaRepository = entregaRepository;
    }
}
