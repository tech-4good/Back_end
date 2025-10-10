package tech4good.tech4good_api.core.application.usecase.cesta;

import tech4good.tech4good_api.core.adapter.CestaGateway;
import tech4good.tech4good_api.core.domain.cesta.Cesta;

import java.util.List;

public class ListarCestasUseCase {

    private final CestaGateway cestaGateway;

    public ListarCestasUseCase(CestaGateway cestaGateway) {
        this.cestaGateway = cestaGateway;
    }

    public List<Cesta> executar() {
        return cestaGateway.findAll();
    }
}
