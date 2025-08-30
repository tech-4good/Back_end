package tech4good.tech4good_api.core.adapter;

import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;
import tech4good.tech4good_api.core.domain.shared.valueobject.Cpf;

import java.util.List;
import java.util.Optional;

public interface BeneficiadoGateway {
    Beneficiado save(Beneficiado beneficiado);

    boolean existsByCpf(String cpf);

    Beneficiado findByCpf(String cpf);

    Beneficiado findById(Integer id);

    boolean existsById(Integer id);

    List<Beneficiado> findAll();

    void deleteById(Integer id);
}
