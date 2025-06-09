package tech4good.cruds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech4good.cruds.entity.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
    boolean existsByCepAndNumero(String cep, Integer numero);
}
