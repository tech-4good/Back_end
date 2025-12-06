package tech4good.tech4good_api.infrastructure.persistence.jpa.Entrega;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface EntregaJpaRepository extends JpaRepository<EntregaEntity, Integer>, PagingAndSortingRepository<EntregaEntity, Integer> {

    @Query("SELECT e FROM EntregaEntity e WHERE " +
           "(:idBeneficiado IS NULL OR e.beneficiado.id = :idBeneficiado) " +
           "AND (:dataInicio IS NULL OR e.dataRetirada >= :dataInicio) " +
           "AND (:dataFim IS NULL OR e.dataRetirada <= :dataFim) " +
           "ORDER BY e.dataRetirada DESC, e.idEntrega DESC")
    Page<EntregaEntity> findByFiltroWithPagination(@Param("idBeneficiado") Integer idBeneficiado,
                                                   @Param("dataInicio") LocalDate dataInicio,
                                                   @Param("dataFim") LocalDate dataFim,
                                                   Pageable pageable);

    @Query("SELECT e FROM EntregaEntity e ORDER BY e.dataRetirada DESC")
    Page<EntregaEntity> findAllWithPagination(Pageable pageable);
}
