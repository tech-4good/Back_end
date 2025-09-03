package tech4good.tech4good_api.core.application.usecase.entrega;

import tech4good.tech4good_api.core.adapter.EntregaGateway;
import tech4good.tech4good_api.core.domain.entrega.Entrega;
import java.util.List;

public class ListarEntregasUseCase {
    private final EntregaGateway gateway;

    public ListarEntregasUseCase(EntregaGateway gateway) {
        this.gateway = gateway;
    }

    public List<Entrega> executar() {
        return gateway.findAll();
    }
}
