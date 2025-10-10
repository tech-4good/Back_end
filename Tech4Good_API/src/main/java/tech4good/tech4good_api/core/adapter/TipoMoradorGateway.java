package tech4good.tech4good_api.core.adapter;

import tech4good.tech4good_api.core.domain.tipomorador.TipoMorador;

import java.util.List;
import java.util.Optional;

public interface TipoMoradorGateway {
    TipoMorador save(TipoMorador tipoMorador);
    Optional<TipoMorador> findById(Integer id);
    List<TipoMorador> findAll();
    boolean existsById(Integer id);
    void deleteById(Integer id);
}
