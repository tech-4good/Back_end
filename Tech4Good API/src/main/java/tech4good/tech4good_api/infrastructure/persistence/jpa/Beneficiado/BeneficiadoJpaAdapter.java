package tech4good.tech4good_api.infrastructure.persistence.jpa.Beneficiado;

import org.springframework.stereotype.Service;
import tech4good.tech4good_api.core.adapter.BeneficiadoGateway;
import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;
import tech4good.tech4good_api.core.domain.shared.valueobject.Cpf;

@Service
public class BeneficiadoJpaAdapter implements BeneficiadoGateway {
    private final BeneficiadoJpaRepository repository;

    public BeneficiadoJpaAdapter(BeneficiadoJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Beneficiado save(Beneficiado beneficiado) {
        return null;
    }

    @Override
    public boolean existsByCpf(Cpf cpf) {
        return false;
    }
}
