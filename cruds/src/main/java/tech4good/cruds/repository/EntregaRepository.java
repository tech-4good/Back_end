package tech4good.cruds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech4good.cruds.entity.Entrega;

public interface EntregaRepository extends JpaRepository<Entrega,Integer> {
}
