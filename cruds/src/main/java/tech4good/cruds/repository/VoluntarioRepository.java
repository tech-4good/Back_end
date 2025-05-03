package tech4good.cruds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech4good.cruds.entity.Voluntario;

import java.util.Optional;

public interface VoluntarioRepository extends JpaRepository<Voluntario,Integer> {
    Optional<Voluntario> findByEmail(String email);
}
