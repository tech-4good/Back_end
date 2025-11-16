package tech4good.tech4good_api.infrastructure.persistence.jpa.Cesta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech4good.tech4good_api.core.domain.shared.valueobject.TipoCesta;

@Repository
public interface CestaJpaRepository extends JpaRepository<CestaEntity, Integer> {

    /**
     * Soma TODAS as quantidades de cestas do tipo especificado
     * Exemplo: Se tem 2 registros (um com qtd=2 e outro com qtd=3), retorna 5
     */
    @Query("SELECT COALESCE(SUM(c.quantidadeCestas), 0) FROM CestaEntity c WHERE c.tipo = :tipo")
    Long sumQuantidadeByTipo(@Param("tipo") TipoCesta tipo);
}
