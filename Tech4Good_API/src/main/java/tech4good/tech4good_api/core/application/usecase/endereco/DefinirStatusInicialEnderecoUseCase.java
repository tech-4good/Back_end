package tech4good.tech4good_api.core.application.usecase.endereco;

import tech4good.tech4good_api.core.adapter.CestaGateway;
import tech4good.tech4good_api.core.adapter.EnderecoGateway;
import tech4good.tech4good_api.core.domain.endereco.Endereco;
import tech4good.tech4good_api.core.domain.endereco.valueobjects.Status;
import tech4good.tech4good_api.core.domain.shared.valueobject.TipoCesta;

import java.time.LocalDate;

/**
 * Use Case responsável por definir o status inicial de um endereço ao cadastrá-lo.
 *
 * Regras de negócio:
 * 1. Verifica disponibilidade de cestas BÁSICAS
 * 2. Se houver vaga: Status = ATIVO
 * 3. Se NÃO houver vaga: Status = EM_FILA_DE_ESPERA (com dataEntradaFila = hoje)
 */
public class DefinirStatusInicialEnderecoUseCase {

    private final EnderecoGateway enderecoGateway;
    private final CestaGateway cestaGateway;

    public DefinirStatusInicialEnderecoUseCase(EnderecoGateway enderecoGateway, CestaGateway cestaGateway) {
        this.enderecoGateway = enderecoGateway;
        this.cestaGateway = cestaGateway;
    }

    /**
     * Define o status inicial do endereço baseado na disponibilidade de cestas BÁSICAS
     * @param endereco Endereço a ser configurado
     * @return Endereço com status definido
     */
    public Endereco executar(Endereco endereco) {
        // Contar cestas BÁSICAS disponíveis
        Long totalCestasBasicas = cestaGateway.countByTipo(TipoCesta.BASICA);

        // Contar endereços ATIVOS (antes de salvar o novo)
        Long totalEnderecosAtivos = enderecoGateway.countByStatus(Status.ATIVO);

        // Verificar se há vaga disponível
        // Exemplo: 2 cestas e 1 ativo → 2 > 1 = true (pode ativar o 2º)
        //          2 cestas e 2 ativos → 2 > 2 = false (vai pra fila)
        boolean temVagaDisponivel = totalCestasBasicas > totalEnderecosAtivos;

        if (temVagaDisponivel) {
            // Há vaga: definir como ATIVO
            endereco.setStatus(Status.ATIVO);
            endereco.setDataEntrada(LocalDate.now());
            endereco.setDataEntradaFila(null);
        } else {
            // Não há vaga: colocar em fila de espera
            endereco.setStatus(Status.EM_FILA_DE_ESPERA);
            endereco.setDataEntradaFila(LocalDate.now());
            endereco.setDataEntrada(null);
        }

        return endereco;
    }
}
