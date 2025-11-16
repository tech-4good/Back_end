package tech4good.tech4good_api.core.adapter;

import tech4good.tech4good_api.core.domain.endereco.Endereco;
import tech4good.tech4good_api.core.domain.endereco.valueobjects.Status;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EnderecoGateway {
    Endereco save(Endereco endereco);
    Optional<Endereco> findById(Integer id);
    boolean existsById(Integer id);
    boolean existsByCepAndNumero(String cep, String numero);
    Optional<Endereco> findByLogradouroAndNumero(String logradouro, String numero);
    List<Endereco> findAll();
    void deleteById(Integer id);

    // Métodos para gerenciar fila de espera
    List<Endereco> findByStatus(Status status);
    List<Endereco> findByStatusOrderByDataEntradaFilaAsc(Status status);
    Long countByStatus(Status status);
    List<Endereco> findByStatusAndDataEntradaBefore(Status status, LocalDate dataLimite);
}
