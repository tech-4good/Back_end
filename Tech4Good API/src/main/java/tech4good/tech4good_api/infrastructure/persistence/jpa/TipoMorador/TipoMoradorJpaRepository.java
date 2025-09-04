package tech4good.tech4good_api.infrastructure.persistence.jpa.TipoMorador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoMoradorJpaRepository extends JpaRepository<TipoMoradorEntity, Integer> {

}
