package tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tech4good.tech4good_api.core.domain.endereco.valueobjects.Status;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EnderecoJpaRepository extends JpaRepository<EnderecoEntity, Integer> {

    @Query(value = "SELECT COUNT(*) FROM endereco WHERE cep = :cep AND numero = :numero", nativeQuery = true)
    Long countByCepAndNumero(@Param("cep") String cep, @Param("numero") String numero);

    Optional<EnderecoEntity> findByLogradouroAndNumero(String logradouro, String numero);

    // Buscar endereços por status
    List<EnderecoEntity> findByStatus(Status status);

    // Buscar endereços em fila de espera ordenados por data de entrada na fila (FIFO)
    List<EnderecoEntity> findByStatusOrderByDataEntradaFilaAsc(Status status);

    // Contar endereços ativos
    Long countByStatus(Status status);

    // Buscar endereços ativos que completaram 4 meses
    @Query("SELECT e FROM EnderecoEntity e WHERE e.status = :status AND e.dataEntrada <= :dataLimite")
    List<EnderecoEntity> findByStatusAndDataEntradaBefore(@Param("status") Status status, @Param("dataLimite") LocalDate dataLimite);
}
