package tech4good.tech4good_api.core.application.usecase.entrega;

import tech4good.tech4good_api.core.adapter.EntregaGateway;
import tech4good.tech4good_api.core.adapter.EnderecoGateway;
import tech4good.tech4good_api.core.adapter.BeneficiadoGateway;
import tech4good.tech4good_api.core.adapter.CestaGateway;
import tech4good.tech4good_api.core.adapter.VoluntarioGateway;
import tech4good.tech4good_api.core.application.command.entrega.CadastrarEntregaCommand;
import tech4good.tech4good_api.core.application.exception.EntidadeNaoEncontradaException;
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
        // Busca as entidades relacionadas e trata os Optional adequadamente
        var endereco = enderecoGateway.findById(command.enderecoId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Endereço com ID %d não encontrado".formatted(command.enderecoId())));

        var beneficiado = beneficiadoGateway.findById(command.beneficiadoId());

        var cesta = cestaGateway.findById(command.cestaId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Cesta com ID %d não encontrada".formatted(command.cestaId())));

        var voluntario = voluntarioGateway.buscarPorId(command.voluntarioId());

        // Cria a entrega
        var entrega = new Entrega(
            null,
            command.dataRetirada(),
            command.proximaRetirada(),
            voluntario,
            endereco,
            cesta,
            beneficiado
        );

        return entregaGateway.save(entrega);
    }
}
