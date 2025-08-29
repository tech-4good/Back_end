package tech4good.tech4good_api.infrastructure.persistence.jpa.Voluntario;

import org.springframework.data.jpa.repository.JpaRepository;
import tech4good.tech4good_api.core.domain.voluntario.Voluntario;

import java.util.Optional;

public interface VoluntarioJpaRepository extends JpaRepository<VoluntarioEntity, Integer> {
    Optional<Voluntario> findByEmail(String username);
}
