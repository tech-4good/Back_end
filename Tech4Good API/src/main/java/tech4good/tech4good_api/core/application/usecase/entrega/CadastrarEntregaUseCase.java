package tech4good.tech4good_api.core.application.usecase.entrega;

import tech4good.tech4good_api.core.adapter.EntregaGateway;
import tech4good.tech4good_api.core.adapter.EnderecoGateway;
import tech4good.tech4good_api.core.adapter.BeneficiadoGateway;
import tech4good.tech4good_api.core.adapter.CestaGateway;
import tech4good.tech4good_api.core.adapter.VoluntarioGateway;
import tech4good.tech4good_api.core.application.command.entrega.CadastrarEntregaCommand;
import tech4good.tech4good_api.core.domain.entrega.Entrega;

public class CadastrarEntregaUseCase {
    private final EntregaGateway entregaGateway;
    private final EnderecoGateway enderecoGateway;
    private final BeneficiadoGateway beneficiadoGateway;
    private final CestaGateway cestaGateway;
    private final VoluntarioGateway voluntarioGateway;

    public CadastrarEntregaUseCase(EntregaGateway entregaGateway,
                                 EnderecoGateway enderecoGateway,
                                 BeneficiadoGateway beneficiadoGateway,
                                 CestaGateway cestaGateway,
                                 VoluntarioGateway voluntarioGateway) {
        this.entregaGateway = entregaGateway;
        this.enderecoGateway = enderecoGateway;
        this.beneficiadoGateway = beneficiadoGateway;
        this.cestaGateway = cestaGateway;
        this.voluntarioGateway = voluntarioGateway;
    }

    public Entrega executar(CadastrarEntregaCommand command) {
        // Verifica se as entidades relacionadas existem
        var endereco = enderecoGateway.findById(command.enderecoId());
        var beneficiado = beneficiadoGateway.findById(command.beneficiadoId());
        var cesta = cestaGateway.findById(command.cestaId());
        var voluntario = voluntarioGateway.findById(command.voluntarioId());

        // Cria a entrega
        var entrega = new Entrega(
            null,
            command.dataRetirada(),
            command.proximaRetirada(),
            endereco,
            cesta,
            voluntario,
            beneficiado
        );

        return entregaGateway.save(entrega);
    }
}
