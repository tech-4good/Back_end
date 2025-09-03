package tech4good.tech4good_api.core.adapter;

import tech4good.tech4good_api.core.domain.entrega.Entrega;
import java.time.LocalDate;
import java.util.List;

public interface EntregaGateway {
    Entrega save(Entrega entrega);

    Entrega findById(Integer id);

    boolean existsById(Integer id);

    List<Entrega> findAll();

    void deleteById(Integer id);

    List<Entrega> findByFiltro(Integer idBeneficiado, LocalDate dataInicio, LocalDate dataFim);
}
