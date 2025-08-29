package tech4good.tech4good_api.core.application.adapter;

import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;
import tech4good.tech4good_api.core.domain.shared.valueobject.Cpf;

public interface BeneficiadoGateway {
    Beneficiado save(Beneficiado beneficiado);

    boolean existsByCpf(Cpf cpf);
}
