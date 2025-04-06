package tech4good.cruds.service;

import org.springframework.stereotype.Service;
import tech4good.cruds.repository.AuxilioGovernamentalRepository;

@Service
public class AuxilioGovernamentalService {

    private final AuxilioGovernamentalRepository auxilioGovernamentalRepository;

    public AuxilioGovernamentalService(AuxilioGovernamentalRepository auxilioGovernamentalRepository) {
        this.auxilioGovernamentalRepository = auxilioGovernamentalRepository;
    }
}
