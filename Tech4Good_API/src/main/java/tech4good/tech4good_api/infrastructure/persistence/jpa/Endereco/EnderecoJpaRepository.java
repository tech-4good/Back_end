package tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EnderecoJpaRepository extends JpaRepository<EnderecoEntity, Integer> {

    @Query(value = "SELECT COUNT(*) FROM endereco WHERE cep = :cep AND numero = :numero", nativeQuery = true)
    Long countByCepAndNumero(@Param("cep") String cep, @Param("numero") String numero);

    Optional<EnderecoEntity> findByLogradouroAndNumero(String logradouro, String numero);
}
