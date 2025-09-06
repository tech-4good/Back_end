package tech4good.tech4good_api.core.application.usecase.filaespera;

import tech4good.tech4good_api.core.adapter.FilaEsperaGateway;
import tech4good.tech4good_api.core.application.command.filaespera.CadastrarFilaEsperaCommand;
import tech4good.tech4good_api.core.domain.filaespera.FilaEspera;

public class CadastrarFilaEsperaUseCase {
    private final FilaEsperaGateway gateway;

    public CadastrarFilaEsperaUseCase(FilaEsperaGateway gateway) {
        this.gateway = gateway;
    }

    public FilaEspera executar(CadastrarFilaEsperaCommand command) {
        FilaEspera fila = new FilaEspera();
        fila.setDataEntradaFila(command.dataEntradaFila());
        fila.setBeneficiado(command.beneficiado());
        return gateway.salvar(fila);
    }
}
