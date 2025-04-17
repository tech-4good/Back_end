package tech4good.cruds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tech4good.cruds.entity.Beneficiado;

public interface BeneficiadoRepository extends JpaRepository<Beneficiado, Integer> {

    public Beneficiado findByIdCpf(String cpf);

    public Boolean existsByIdCpf(String cpf);
}
