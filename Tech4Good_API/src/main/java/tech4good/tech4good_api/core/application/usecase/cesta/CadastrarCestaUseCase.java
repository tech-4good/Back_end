package tech4good.tech4good_api.core.application.usecase.cesta;

import tech4good.tech4good_api.core.adapter.CestaGateway;
import tech4good.tech4good_api.core.application.command.cesta.CadastrarCestaCommand;
import tech4good.tech4good_api.core.application.usecase.endereco.ProcessarFilaEsperaAoCadastrarCestaUseCase;
import tech4good.tech4good_api.core.application.usecase.endereco.VerificarEnderecosInativosUseCase;
import tech4good.tech4good_api.core.domain.cesta.Cesta;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Cesta.CestaMapper;

public class CadastrarCestaUseCase {

    private final CestaGateway cestaGateway;
    private final ProcessarFilaEsperaAoCadastrarCestaUseCase processarFilaUseCase;
    private final VerificarEnderecosInativosUseCase verificarInativosUseCase;

    public CadastrarCestaUseCase(
            CestaGateway cestaGateway,
            ProcessarFilaEsperaAoCadastrarCestaUseCase processarFilaUseCase,
            VerificarEnderecosInativosUseCase verificarInativosUseCase) {
        this.cestaGateway = cestaGateway;
        this.processarFilaUseCase = processarFilaUseCase;
        this.verificarInativosUseCase = verificarInativosUseCase;
    }

    public Cesta executar(CadastrarCestaCommand command) {
        Cesta cesta = CestaMapper.toDomain(command);
        Cesta cestaSalva = cestaGateway.save(cesta);

        // Primeiro: verificar e inativar endereços que completaram 4 meses
        verificarInativosUseCase.executar();

        // Depois: processar fila de espera se for cesta BÁSICA, passando a quantidade correta
        processarFilaUseCase.executar(cestaSalva.getTipo(), cestaSalva.getQuantidadeCestas());

        return cestaSalva;
    }
}
