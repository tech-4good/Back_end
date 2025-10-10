package tech4good.tech4good_api.core.adapter;

import tech4good.tech4good_api.core.domain.cesta.Cesta;

import java.util.List;
import java.util.Optional;

public interface CestaGateway {
    Cesta save(Cesta cesta);
    Optional<Cesta> findById(Integer id);
    boolean existsById(Integer id);
    List<Cesta> findAll();
    void deleteById(Integer id);
}
