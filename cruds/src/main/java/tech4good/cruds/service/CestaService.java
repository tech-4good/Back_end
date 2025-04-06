package tech4good.cruds.service;

import org.springframework.stereotype.Service;
import tech4good.cruds.repository.CestaRepository;

@Service
public class CestaService {

    private final CestaRepository cestaRepository;

    public CestaService(CestaRepository cestaRepository) {
        this.cestaRepository = cestaRepository;
    }
}
