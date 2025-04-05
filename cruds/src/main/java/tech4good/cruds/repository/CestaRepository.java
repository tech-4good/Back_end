package tech4good.cruds.cesta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech4good.cruds.entity.Cesta;

public interface CestaRepository extends JpaRepository<Cesta, Integer> {
}

