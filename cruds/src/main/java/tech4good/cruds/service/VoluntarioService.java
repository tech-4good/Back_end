package tech4good.cruds.service;

import org.springframework.stereotype.Service;
import tech4good.cruds.repository.VoluntarioRepository;

@Service
public class VoluntarioService {

    private final VoluntarioRepository voluntarioRepository;

    public VoluntarioService(VoluntarioRepository voluntarioRepository) {
        this.voluntarioRepository = voluntarioRepository;
    }
}
