package tech4good.tech4good_api.infrastructure.persistence.jpa.BeneficiadoHasAuxilio;

import org.springframework.stereotype.Service;
import tech4good.tech4good_api.core.adapter.BeneficiadoHasAuxilioGateway;
import tech4good.tech4good_api.core.domain.beneficiadohasauxilio.BeneficiadoHasAuxilio;
import tech4good.tech4good_api.infrastructure.persistence.jpa.BeneficiadoHasAuxilio.BeneficiadoHasAuxilioJpaRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BeneficiadoHasAuxilioJpaAdapter implements BeneficiadoHasAuxilioGateway {
    private final BeneficiadoHasAuxilioJpaRepository repository;

    public BeneficiadoHasAuxilioJpaAdapter(BeneficiadoHasAuxilioJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public BeneficiadoHasAuxilio save(BeneficiadoHasAuxilio beneficiadoHasAuxilio) {
        var entity = BeneficiadoHasAuxilioMapper.toEntity(beneficiadoHasAuxilio);
        var entitySalva = repository.save(entity);
        return BeneficiadoHasAuxilioMapper.toDomain(entitySalva);
    }

    @Override
    public BeneficiadoHasAuxilio findById(Integer id) {
        if (repository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("BeneficiadoHasAuxilio com ID %d não encontrado".formatted(id));
        }
        return BeneficiadoHasAuxilioMapper.toDomain(repository.findById(id).get());
    }

    @Override
    public boolean existsById(Integer id) {
        return repository.existsById(id);
    }

    @Override
    public List<BeneficiadoHasAuxilio> findAll() {
        return repository.findAll().stream()
                .map(BeneficiadoHasAuxilioMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
