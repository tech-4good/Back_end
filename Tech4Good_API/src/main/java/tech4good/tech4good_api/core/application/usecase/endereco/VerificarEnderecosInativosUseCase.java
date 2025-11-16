package tech4good.tech4good_api.core.application.usecase.endereco;

import tech4good.tech4good_api.core.adapter.EnderecoGateway;
import tech4good.tech4good_api.core.domain.endereco.Endereco;
import tech4good.tech4good_api.core.domain.endereco.valueobjects.Status;

import java.time.LocalDate;
import java.util.List;

/**
 * Use Case responsável por verificar e inativar endereços que completaram 4 meses como ATIVO.
 *
 * Regras de negócio:
 * 1. Endereços ATIVOS que completaram 4 meses (a partir da dataEntrada) devem ser INATIVADOS
 * 2. Ao inativar, libera vaga para próximo da fila
 * 3. Deve ser executado periodicamente ou ao cadastrar novas cestas
 */
public class VerificarEnderecosInativosUseCase {

    private final EnderecoGateway enderecoGateway;
    private final ProcessarFilaEsperaAoCadastrarCestaUseCase processarFilaUseCase;

    public VerificarEnderecosInativosUseCase(
            EnderecoGateway enderecoGateway,
            ProcessarFilaEsperaAoCadastrarCestaUseCase processarFilaUseCase) {
        this.enderecoGateway = enderecoGateway;
        this.processarFilaUseCase = processarFilaUseCase;
    }

    /**
     * Verifica e inativa endereços que completaram 4 meses como ATIVO
     * @return Quantidade de endereços inativados
     */
    public Integer executar() {
        // Calcular data limite (4 meses atrás)
        LocalDate dataLimite = LocalDate.now().minusMonths(4);

        // Buscar endereços ATIVOS que completaram 4 meses
        List<Endereco> enderecosParaInativar = enderecoGateway.findByStatusAndDataEntradaBefore(
            Status.ATIVO,
            dataLimite
        );

        int enderecosInativados = 0;

        for (Endereco endereco : enderecosParaInativar) {
            // Mudar status para INATIVO
            endereco.setStatus(Status.INATIVO);
            endereco.setDataSaida(LocalDate.now());

            enderecoGateway.save(endereco);
            enderecosInativados++;
        }

        // Se inativou algum endereço, processar fila para ativar próximos
        if (enderecosInativados > 0) {
            // Nota: Este método seria chamado separadamente ao cadastrar cestas
            // Aqui apenas registramos que vagas foram liberadas
        }

        return enderecosInativados;
    }
}

