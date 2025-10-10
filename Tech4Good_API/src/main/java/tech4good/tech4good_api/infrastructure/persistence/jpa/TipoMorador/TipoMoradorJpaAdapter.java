package tech4good.tech4good_api.infrastructure.persistence.jpa.TipoMorador;

import org.springframework.stereotype.Service;
import tech4good.tech4good_api.core.adapter.TipoMoradorGateway;
import tech4good.tech4good_api.core.domain.tipomorador.TipoMorador;

import java.util.List;
import java.util.Optional;

@Service
public class TipoMoradorJpaAdapter implements TipoMoradorGateway {

    private final TipoMoradorJpaRepository repository;

    public TipoMoradorJpaAdapter(TipoMoradorJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public TipoMorador save(TipoMorador tipoMorador) {
        var tipoMoradorEntity = TipoMoradorMapper.toEntity(tipoMorador);
        var tipoMoradorSalvo = repository.save(tipoMoradorEntity);
        return TipoMoradorMapper.toDomain(tipoMoradorSalvo);
    }

    @Override
    public Optional<TipoMorador> findById(Integer id) {
        var entityOpt = repository.findById(id);
        return entityOpt.map(TipoMoradorMapper::toDomain);
    }

    @Override
    public List<TipoMorador> findAll() {
        return repository.findAll().stream()
            .map(TipoMoradorMapper::toDomain)
            .toList();
    }

    @Override
    public boolean existsById(Integer id) {
        return repository.existsById(id);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
