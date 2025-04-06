package tech4good.cruds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech4good.cruds.entity.TipoMorador;

public interface TipoMoradorRepository extends JpaRepository<TipoMorador,Integer> {
}
