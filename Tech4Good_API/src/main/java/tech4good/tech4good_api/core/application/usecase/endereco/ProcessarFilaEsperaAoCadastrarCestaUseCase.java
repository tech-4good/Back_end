package tech4good.tech4good_api.core.application.usecase.endereco;

import tech4good.tech4good_api.core.adapter.CestaGateway;
import tech4good.tech4good_api.core.adapter.EnderecoGateway;
import tech4good.tech4good_api.core.domain.endereco.Endereco;
import tech4good.tech4good_api.core.domain.endereco.valueobjects.Status;
import tech4good.tech4good_api.core.domain.shared.valueobject.TipoCesta;

import java.time.LocalDate;
import java.util.List;

/**
 * Use Case responsável por processar a fila de espera quando cestas BÁSICAS são cadastradas.
 *
 * Regras de negócio:
 * 1. Apenas cestas do tipo BASICA participam dessa lógica
 * 2. Busca endereços EM_FILA_DE_ESPERA ordenados por dataEntradaFila (FIFO)
 * 3. Ativa endereços conforme disponibilidade de cestas
 */
public class ProcessarFilaEsperaAoCadastrarCestaUseCase {

    private final EnderecoGateway enderecoGateway;
    private final CestaGateway cestaGateway;

    public ProcessarFilaEsperaAoCadastrarCestaUseCase(EnderecoGateway enderecoGateway, CestaGateway cestaGateway) {
        this.enderecoGateway = enderecoGateway;
        this.cestaGateway = cestaGateway;
    }

    /**
     * Processa a fila de espera ao cadastrar novas cestas BÁSICAS
     * @param tipoCesta Tipo da cesta cadastrada
     * @param quantidadeCadastrada Quantidade de cestas cadastradas NESTE insert
     */
    public void executar(TipoCesta tipoCesta, Integer quantidadeCadastrada) {
        // Apenas processar se for cesta BASICA
        if (tipoCesta != TipoCesta.BASICA) {
            return;
        }

        // A quantidade de vagas disponíveis é exatamente a quantidade de cestas cadastradas
        // Exemplo: Se cadastrou 3 cestas, temos 3 novas vagas para ativar da fila
        int vagasDisponiveis = quantidadeCadastrada;

        if (vagasDisponiveis <= 0) {
            return; // Não há vagas disponíveis
        }

        // Buscar endereços em fila de espera ordenados por data de entrada (FIFO)
        List<Endereco> enderecosNaFila = enderecoGateway.findByStatusOrderByDataEntradaFilaAsc(Status.EM_FILA_DE_ESPERA);

        // Ativar endereços conforme vagas disponíveis
        int enderecosAtivados = 0;
        for (Endereco endereco : enderecosNaFila) {
            if (enderecosAtivados >= vagasDisponiveis) {
                break;
            }

            // Mudar status para ATIVO e definir data de entrada
            endereco.setStatus(Status.ATIVO);
            endereco.setDataEntrada(LocalDate.now());
            endereco.setDataEntradaFila(null); // Limpar data da fila

            enderecoGateway.save(endereco);
            enderecosAtivados++;
        }
    }
}
