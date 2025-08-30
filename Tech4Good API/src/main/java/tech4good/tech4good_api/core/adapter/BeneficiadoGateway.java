package tech4good.tech4good_api.core.adapter;

import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;
import tech4good.tech4good_api.core.domain.shared.valueobject.Cpf;

import java.util.Optional;

public interface BeneficiadoGateway {
    Beneficiado save(Beneficiado beneficiado);

    boolean existsByCpf(Cpf cpf);

    /*Optional<Beneficiado> findById(Integer id);*/
}
