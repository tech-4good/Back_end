package tech4good.tech4good_api.infrastructure.persistence.jpa.Cesta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CestaJpaRepository extends JpaRepository<CestaEntity, Integer> {
}
