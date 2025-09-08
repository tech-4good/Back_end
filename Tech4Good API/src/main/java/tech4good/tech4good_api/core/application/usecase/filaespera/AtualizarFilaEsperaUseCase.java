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
        FilaEspera filaExistente = gateway.buscarPorId(command.id());
        if (filaExistente == null) {
            throw new RuntimeException("Fila de espera não encontrada com ID: " + command.id());
        }

        // Atualizar apenas os campos fornecidos no command
        if (command.dataEntradaFila() != null) {
            filaExistente.setDataEntradaFila(command.dataEntradaFila());
        }
        if (command.dataSaidaFila() != null) {
            filaExistente.setDataSaidaFila(command.dataSaidaFila());
        }
        if (command.beneficiado() != null) {
            filaExistente.setBeneficiado(command.beneficiado());
        }

        return gateway.atualizar(filaExistente);
    }
}
