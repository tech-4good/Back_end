package tech4good.cruds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tech4good.cruds.entity.Entrega;
import java.util.List;
import java.time.LocalDate;

public interface EntregaRepository extends JpaRepository<Entrega,Integer> {
    List<Entrega> findByBeneficiadoId(Integer id);

    @Query("""
    SELECT e FROM Entrega e
    WHERE (:idBeneficiado IS NULL OR e.beneficiado.id = :idBeneficiado)
    AND (:dataInicio IS NULL OR e.dataRetirada >= :dataInicio)
    AND (:dataFim IS NULL OR e.dataRetirada <= :dataFim)
""")
    List<Entrega> findByFiltro(
            @Param("idBeneficiado") Integer idBeneficiado,
            @Param("dataInicio") LocalDate dataInicio,
            @Param("dataFim") LocalDate dataFim
    );

}
