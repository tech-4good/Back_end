package tech4good.tech4good_api.core.application.usecase.cesta;

import tech4good.tech4good_api.core.adapter.CestaGateway;
import tech4good.tech4good_api.core.application.command.cesta.CadastrarCestaCommand;
import tech4good.tech4good_api.core.domain.cesta.Cesta;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Cesta.CestaMapper;

public class CadastrarCestaUseCase {

    private final CestaGateway cestaGateway;

    public CadastrarCestaUseCase(CestaGateway cestaGateway) {
        this.cestaGateway = cestaGateway;
    }

    public Cesta executar(CadastrarCestaCommand command) {
        Cesta cesta = CestaMapper.toDomain(command);
        return cestaGateway.save(cesta);
    }
}
