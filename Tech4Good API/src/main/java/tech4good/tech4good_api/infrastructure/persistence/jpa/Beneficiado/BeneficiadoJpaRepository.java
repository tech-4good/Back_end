package tech4good.tech4good_api.infrastructure.persistence.jpa.Beneficiado;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiadoJpaRepository extends JpaRepository<BeneficiadoEntity, Integer> {
    boolean existsByCpf(String cpf);
}
