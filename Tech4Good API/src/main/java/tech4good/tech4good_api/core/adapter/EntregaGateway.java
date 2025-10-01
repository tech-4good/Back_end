package tech4good.tech4good_api.core.adapter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tech4good.tech4good_api.core.domain.entrega.Entrega;
import java.time.LocalDate;

public interface EntregaGateway {
    Entrega save(Entrega entrega);

    Entrega findById(Integer id);

    boolean existsById(Integer id);

    void deleteById(Integer id);

    // Métodos de paginação - únicos necessários agora
    Page<Entrega> findAllWithPagination(Pageable pageable);

    Page<Entrega> findByFiltroWithPagination(Integer idBeneficiado, LocalDate dataInicio, LocalDate dataFim, Pageable pageable);
}
