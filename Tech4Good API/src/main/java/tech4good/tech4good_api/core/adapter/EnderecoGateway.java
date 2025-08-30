package tech4good.tech4good_api.core.adapter;

import tech4good.tech4good_api.core.domain.endereco.Endereco;

import java.util.Optional;

public interface EnderecoGateway {
    Optional<Endereco> findById(Integer id);
}
