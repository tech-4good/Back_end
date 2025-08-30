package tech4good.tech4good_api.core.adapter;

import tech4good.tech4good_api.core.domain.endereco.Endereco;

import java.util.Optional;

public interface EnderecoGateway {
    Endereco save(Endereco endereco);
    Optional<Endereco> findById(Integer id);
    boolean existsByCepAndNumero(String cep, String numero);
    Optional<Endereco> findByLogradouroAndNumero(String logradouro, String numero);
}
