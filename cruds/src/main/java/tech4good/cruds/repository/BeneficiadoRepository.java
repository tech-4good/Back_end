package tech4good.cruds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech4good.cruds.entity.Beneficiado;

public interface BeneficiadoRepository extends JpaRepository<Beneficiado, Integer> {

    public Beneficiado findByCpf(String cpf);

    public Boolean existsByCpf(String cpf);
}
