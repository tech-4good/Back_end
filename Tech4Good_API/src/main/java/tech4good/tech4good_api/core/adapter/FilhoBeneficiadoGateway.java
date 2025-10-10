package tech4good.tech4good_api.core.adapter;

import tech4good.tech4good_api.core.domain.filhobeneficiado.FilhoBeneficiado;

import java.util.List;

public interface FilhoBeneficiadoGateway {
    FilhoBeneficiado save(FilhoBeneficiado filhoBeneficiado);
    FilhoBeneficiado findById(Integer id);
    List<FilhoBeneficiado> findAll();
    void deleteById(Integer id);
}
