package tech4good.tech4good_api.core.adapter;

import tech4good.tech4good_api.core.domain.endereco.Endereco;

public interface ViaCepGateway {
    Endereco buscarEnderecoPorCep(String cep);
}
