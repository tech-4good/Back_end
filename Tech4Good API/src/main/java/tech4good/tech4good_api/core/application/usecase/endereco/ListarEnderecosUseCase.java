package tech4good.tech4good_api.core.application.usecase.endereco;

import tech4good.tech4good_api.core.adapter.EnderecoGateway;
import tech4good.tech4good_api.core.domain.endereco.Endereco;
import java.util.List;

public class ListarEnderecosUseCase {

    private final EnderecoGateway gateway;

    public ListarEnderecosUseCase(EnderecoGateway gateway) {
        this.gateway = gateway;
    }

    public List<Endereco> executar() {
        return gateway.findAll();
    }
}

