package tech4good.tech4good_api.core.adapter;

import tech4good.tech4good_api.core.domain.beneficiadohasauxilio.BeneficiadoHasAuxilio;
import java.util.List;

public interface BeneficiadoHasAuxilioGateway {
    BeneficiadoHasAuxilio save(BeneficiadoHasAuxilio beneficiadoHasAuxilio);

    BeneficiadoHasAuxilio findById(Integer id);

    boolean existsById(Integer id);

    List<BeneficiadoHasAuxilio> findAll();

    void deleteById(Integer id);
}
