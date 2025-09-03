package tech4good.tech4good_api.infrastructure.persistence.jpa.Entrega;

import org.springframework.stereotype.Service;
import tech4good.tech4good_api.core.adapter.EntregaGateway;
import tech4good.tech4good_api.core.domain.entrega.Entrega;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntregaJpaAdapter implements EntregaGateway {
    private final EntregaJpaRepository repository;

    public EntregaJpaAdapter(EntregaJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Entrega save(Entrega entrega) {
        var entity = EntregaMapper.toEntity(entrega);
        var entitySalva = repository.save(entity);
        return EntregaMapper.toDomain(entitySalva);
    }

    @Override
    public Entrega findById(Integer id) {
        if (repository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("Entrega com ID %d não encontrada".formatted(id));
        }
        return EntregaMapper.toDomain(repository.findById(id).get());
    }

    @Override
    public boolean existsById(Integer id) {
        return repository.existsById(id);
    }

    @Override
    public List<Entrega> findAll() {
        return repository.findAll().stream()
                .map(EntregaMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Entrega> findByFiltro(Integer idBeneficiado, LocalDate dataInicio, LocalDate dataFim) {
        return repository.findByFiltro(idBeneficiado, dataInicio, dataFim).stream()
                .map(EntregaMapper::toDomain)
                .collect(Collectors.toList());
    }
}
