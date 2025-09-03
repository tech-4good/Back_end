package tech4good.tech4good_api.infrastructure.persistence.jpa.Entrega;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EntregaJpaRepository extends JpaRepository<EntregaEntity, Integer> {

    @Query("SELECT e FROM EntregaEntity e WHERE e.beneficiado.id = :idBeneficiado " +
           "AND (:dataInicio IS NULL OR e.dataRetirada >= :dataInicio) " +
           "AND (:dataFim IS NULL OR e.dataRetirada <= :dataFim)")
    List<EntregaEntity> findByFiltro(@Param("idBeneficiado") Integer idBeneficiado,
                                    @Param("dataInicio") LocalDate dataInicio,
                                    @Param("dataFim") LocalDate dataFim);
}
