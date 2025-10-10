package tech4good.tech4good_api.core.adapter;

import tech4good.tech4good_api.core.domain.auxiliogovernamental.AuxilioGovernamental;
import java.util.List;

public interface AuxilioGovernamentalGateway {
    AuxilioGovernamental save(AuxilioGovernamental auxilioGovernamental);

    AuxilioGovernamental findById(Integer id);

    boolean existsById(Integer id);

    List<AuxilioGovernamental> findAll();

    void deleteById(Integer id);
}
