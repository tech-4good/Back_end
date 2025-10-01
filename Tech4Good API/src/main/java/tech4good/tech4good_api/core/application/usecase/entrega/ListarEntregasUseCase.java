package tech4good.tech4good_api.core.application.usecase.entrega;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech4good.tech4good_api.core.adapter.EntregaGateway;
import tech4good.tech4good_api.core.domain.entrega.Entrega;

@Service
public class ListarEntregasUseCase {

    private final EntregaGateway entregaGateway;

    public ListarEntregasUseCase(EntregaGateway entregaGateway) {
        this.entregaGateway = entregaGateway;
    }

    public Page<Entrega> executar(Pageable pageable) {
        return entregaGateway.findAllWithPagination(pageable);
    }
}
