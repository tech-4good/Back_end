package tech4good.tech4good_api.infrastructure.persistence.jpa.Voluntario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface VoluntarioJpaRepository extends JpaRepository<VoluntarioEntity, Integer> {

    @Query(value = "SELECT * FROM voluntario WHERE email = :email", nativeQuery = true)
    Optional<VoluntarioEntity> findByEmail(@Param("email") String email);
}
