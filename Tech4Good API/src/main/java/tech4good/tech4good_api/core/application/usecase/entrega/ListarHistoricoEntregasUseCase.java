package tech4good.tech4good_api.core.application.usecase.entrega;

import tech4good.tech4good_api.core.adapter.EntregaGateway;
import tech4good.tech4good_api.core.application.command.entrega.ListarHistoricoEntregasCommand;
import tech4good.tech4good_api.core.domain.entrega.Entrega;
import java.util.List;

public class ListarHistoricoEntregasUseCase {
    private final EntregaGateway gateway;

    public ListarHistoricoEntregasUseCase(EntregaGateway gateway) {
        this.gateway = gateway;
    }

    public List<Entrega> executar(ListarHistoricoEntregasCommand command) {
        return gateway.findByFiltro(command.idBeneficiado(), command.dataInicio(), command.dataFim());
    }
}
