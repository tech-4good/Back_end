package tech4good.tech4good_api.core.application.usecase.filaespera;

import tech4good.tech4good_api.core.adapter.FilaEsperaGateway;
import tech4good.tech4good_api.core.application.command.filaespera.AtualizarFilaEsperaCommand;
import tech4good.tech4good_api.core.domain.filaespera.FilaEspera;

public class AtualizarFilaEsperaUseCase {
    private final FilaEsperaGateway gateway;

    public AtualizarFilaEsperaUseCase(FilaEsperaGateway gateway) {
        this.gateway = gateway;
    }

    public FilaEspera executar(AtualizarFilaEsperaCommand command) {
        FilaEspera fila = new FilaEspera();
        fila.setId(command.id());
        fila.setDataEntradaFila(command.dataEntradaFila());
        fila.setDataSaidaFila(command.dataSaidaFila());
        fila.setBeneficiado(command.beneficiado());
        return gateway.atualizar(fila);
    }
}
