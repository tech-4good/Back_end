package tech4good.tech4good_api.infrastructure.persistence.jpa.FilhoBeneficiado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilhoBeneficiadoJpaRepository extends JpaRepository<FilhoBeneficiadoEntity, Integer> {
}
