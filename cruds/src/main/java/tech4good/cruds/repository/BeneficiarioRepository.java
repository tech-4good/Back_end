package tech4good.cruds.beneficiario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech4good.cruds.entity.Beneficiario;

public interface BeneficiarioRepository extends JpaRepository<Beneficiario, String> {
}
