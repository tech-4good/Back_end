package tech4good.tech4good_api.core.application.usecase.cesta;

import tech4good.tech4good_api.core.adapter.CestaGateway;
import tech4good.tech4good_api.core.application.command.cesta.AtualizarCestaCommand;
import tech4good.tech4good_api.core.application.exception.EntidadeNaoEncontradaException;
import tech4good.tech4good_api.core.domain.cesta.Cesta;

public class AtualizarCestaUseCase {

    private final CestaGateway cestaGateway;

    public AtualizarCestaUseCase(CestaGateway cestaGateway) {
        this.cestaGateway = cestaGateway;
    }

    public Cesta executar(AtualizarCestaCommand command) {
        Cesta cestaExistente = cestaGateway.findById(command.id())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Cesta de id %d não encontrada".formatted(command.id())));

        if (command.quantidadeCestas() != null) {
            cestaExistente.setQuantidadeCestas(command.quantidadeCestas());
        }

        return cestaGateway.save(cestaExistente);
    }
}
