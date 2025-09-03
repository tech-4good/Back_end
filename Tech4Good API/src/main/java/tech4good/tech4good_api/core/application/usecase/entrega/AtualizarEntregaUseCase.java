package tech4good.tech4good_api.core.application.usecase.entrega;

import tech4good.tech4good_api.core.adapter.EntregaGateway;
import tech4good.tech4good_api.core.application.command.entrega.AtualizarEntregaCommand;
import tech4good.tech4good_api.core.domain.entrega.Entrega;

public class AtualizarEntregaUseCase {
    private final EntregaGateway gateway;

    public AtualizarEntregaUseCase(EntregaGateway gateway) {
        this.gateway = gateway;
    }

    public Entrega executar(Integer id, AtualizarEntregaCommand command) {
        Entrega entregaExistente = gateway.findById(id);

        // Atualiza apenas os campos que foram fornecidos
        Entrega entregaAtualizada = new Entrega(
            entregaExistente.getId(),
            command.dataRetirada() != null ? command.dataRetirada() : entregaExistente.getDataRetirada(),
            command.proximaRetirada() != null ? command.proximaRetirada() : entregaExistente.getProximaRetirada(),
            entregaExistente.getEndereco(),
            entregaExistente.getCesta(),
            entregaExistente.getVoluntario(),
            entregaExistente.getBeneficiado()
        );

        return gateway.save(entregaAtualizada);
    }
}
