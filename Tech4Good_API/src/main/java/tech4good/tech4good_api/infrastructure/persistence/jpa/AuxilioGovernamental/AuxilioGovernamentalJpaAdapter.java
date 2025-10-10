package tech4good.tech4good_api.infrastructure.persistence.jpa.AuxilioGovernamental;

import org.springframework.stereotype.Service;
import tech4good.tech4good_api.core.adapter.AuxilioGovernamentalGateway;
import tech4good.tech4good_api.core.domain.auxiliogovernamental.AuxilioGovernamental;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuxilioGovernamentalJpaAdapter implements AuxilioGovernamentalGateway {
    private final AuxilioGovernamentalJpaRepository repository;

    public AuxilioGovernamentalJpaAdapter(AuxilioGovernamentalJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public AuxilioGovernamental save(AuxilioGovernamental auxilioGovernamental) {
        var auxilioEntity = AuxilioGovernamentalMapper.toEntity(auxilioGovernamental);
        var auxilioSalvo = repository.save(auxilioEntity);
        return AuxilioGovernamentalMapper.toDomain(auxilioSalvo);
    }

    @Override
    public AuxilioGovernamental findById(Integer id) {
        if (repository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("AuxilioGovernamental com ID %d não encontrado".formatted(id));
        }
        return AuxilioGovernamentalMapper.toDomain(repository.findById(id).get());
    }

    @Override
    public boolean existsById(Integer id) {
        return repository.existsById(id);
    }

    @Override
    public List<AuxilioGovernamental> findAll() {
        return repository.findAll().stream()
                .map(AuxilioGovernamentalMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
