package tech4good.tech4good_api.infrastructure.persistence.jpa.Cesta;

import org.springframework.stereotype.Service;
import tech4good.tech4good_api.core.adapter.CestaGateway;
import tech4good.tech4good_api.core.domain.cesta.Cesta;
import tech4good.tech4good_api.core.domain.shared.valueobject.TipoCesta;

import java.util.List;
import java.util.Optional;

@Service
public class CestaJpaAdapter implements CestaGateway {

    private final CestaJpaRepository cestaJpaRepository;

    public CestaJpaAdapter(CestaJpaRepository cestaJpaRepository) {
        this.cestaJpaRepository = cestaJpaRepository;
    }

    @Override
    public Cesta save(Cesta cesta) {
        CestaEntity entity = CestaMapper.toEntity(cesta);
        CestaEntity savedEntity = cestaJpaRepository.save(entity);
        return CestaMapper.toDomainFromEntity(savedEntity);
    }

    @Override
    public Optional<Cesta> findById(Integer id) {
        return cestaJpaRepository.findById(id)
                .map(CestaMapper::toDomainFromEntity);
    }

    @Override
    public boolean existsById(Integer id) {
        return cestaJpaRepository.existsById(id);
    }

    @Override
    public List<Cesta> findAll() {
        return cestaJpaRepository.findAll()
                .stream()
                .map(CestaMapper::toDomainFromEntity)
                .toList();
    }

    @Override
    public void deleteById(Integer id) {
        cestaJpaRepository.deleteById(id);
    }

    @Override
    public Long countByTipo(TipoCesta tipo) {
        // Retorna a SOMA de todas as quantidades de cestas do tipo, não a contagem de registros
        return cestaJpaRepository.sumQuantidadeByTipo(tipo);
    }
}
