package tech4good.tech4good_api.infrastructure.persistence.jpa.Entrega;

import org.springframework.cache.annotation.CacheEvict;
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
    private EntregaJpaAdapter self;

    public EntregaJpaAdapter(EntregaJpaRepository repository) {
        this.repository = repository;
    }

    @org.springframework.beans.factory.annotation.Autowired
    public void setSelf(EntregaJpaAdapter self) {
        this.self = self;
    }

    @Override
    @CacheEvict(cacheNames = {"historicoEntregas", "historicoEntregasFiltro"}, allEntries = true)
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
    @CacheEvict(cacheNames = {"historicoEntregas", "historicoEntregasFiltro"}, allEntries = true)
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Entrega> findAllWithPagination(Pageable pageable) {
        // Usa self para chamar método cacheado através do proxy
        PageDTO<Entrega> dto = self.findAllWithPaginationDTO(pageable);
        // Converte PageDTO de volta para Page
        return dto.toPage();
    }

    @Cacheable(cacheNames = "historicoEntregas", key = "#pageable.pageNumber + '-' + #pageable.pageSize")
    public PageDTO<Entrega> findAllWithPaginationDTO(Pageable pageable) {
        Page<EntregaEntity> entitiesPage = repository.findAllWithPagination(pageable);
        Page<Entrega> entregaPage = entitiesPage.map(EntregaMapper::toDomain);
        // Retorna PageDTO que é serializável pelo Redis
        return PageDTO.fromPage(entregaPage);
    }

    @Override
    public Page<Entrega> findByFiltroWithPagination(Integer idBeneficiado, LocalDate dataInicio, LocalDate dataFim, Pageable pageable) {
        // Usa self para chamar método cacheado através do proxy
        PageDTO<Entrega> dto = self.findByFiltroWithPaginationDTO(idBeneficiado, dataInicio, dataFim, pageable);
        // Converte PageDTO de volta para Page
        return dto.toPage();
    }

    @Cacheable(cacheNames = "historicoEntregasFiltro",
               key = "#idBeneficiado + '-' + #dataInicio + '-' + #dataFim + '-' + #pageable.pageNumber + '-' + #pageable.pageSize")
    public PageDTO<Entrega> findByFiltroWithPaginationDTO(Integer idBeneficiado, LocalDate dataInicio, LocalDate dataFim, Pageable pageable) {
        Page<EntregaEntity> entitiesPage = repository.findByFiltroWithPagination(idBeneficiado, dataInicio, dataFim, pageable);
        Page<Entrega> entregaPage = entitiesPage.map(EntregaMapper::toDomain);
        // Retorna PageDTO que é serializável pelo Redis
        return PageDTO.fromPage(entregaPage);
    }
}
