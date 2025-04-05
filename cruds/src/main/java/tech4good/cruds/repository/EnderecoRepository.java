package tech4good.cruds.endereco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech4good.cruds.entity.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
