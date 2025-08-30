package tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco;

import org.springframework.data.jpa.repository.JpaRepository;
import tech4good.tech4good_api.core.domain.endereco.Endereco;

import java.util.Optional;

public interface EnderecoJpaRepository extends JpaRepository<EnderecoEntity, Integer> {
    boolean existsByCepAndNumero(String cep, String numero);

    Optional<EnderecoEntity> findByLogradouroAndNumero(String logradouro, String numero);
}
