package tech4good.tech4good_api.core.application.usecase.entrega;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech4good.tech4good_api.core.adapter.EntregaGateway;
import tech4good.tech4good_api.core.domain.entrega.Entrega;

import java.time.LocalDate;

@Service
public class ListarHistoricoEntregasUseCase {

    private final EntregaGateway entregaGateway;

    public ListarHistoricoEntregasUseCase(EntregaGateway entregaGateway) {
        this.entregaGateway = entregaGateway;
    }

    public Page<Entrega> executar(Integer idBeneficiado, LocalDate dataInicio, LocalDate dataFim, Pageable pageable) {
        return entregaGateway.findByFiltroWithPagination(idBeneficiado, dataInicio, dataFim, pageable);
    }
}
