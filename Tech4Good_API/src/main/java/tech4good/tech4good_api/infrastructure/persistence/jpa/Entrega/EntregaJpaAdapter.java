package tech4good.tech4good_api.infrastructure.persistence.jpa.Entrega;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech4good.tech4good_api.core.adapter.EntregaGateway;
import tech4good.tech4good_api.core.domain.entrega.Entrega;

import java.time.LocalDate;

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
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    @Cacheable(cacheNames = "historicoEntregas")
    public Page<Entrega> findAllWithPagination(Pageable pageable) {
        Page<EntregaEntity> entitiesPage = repository.findAllWithPagination(pageable);
        return entitiesPage.map(EntregaMapper::toDomain);
    }

    @Override
    @Cacheable(cacheNames = "historicoEntregasFiltro")
    public Page<Entrega> findByFiltroWithPagination(Integer idBeneficiado, LocalDate dataInicio, LocalDate dataFim, Pageable pageable) {
        Page<EntregaEntity> entitiesPage = repository.findByFiltroWithPagination(idBeneficiado, dataInicio, dataFim, pageable);
        return entitiesPage.map(EntregaMapper::toDomain);
    }
}
