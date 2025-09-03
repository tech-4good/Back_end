package tech4good.tech4good_api.core.domain.beneficiadohasauxilio;

import tech4good.tech4good_api.core.domain.auxiliogovernamental.AuxilioGovernamental;
import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;

public class BeneficiadoHasAuxilio {
    private Integer id;
    private AuxilioGovernamental auxilio;
    private Beneficiado beneficiado;

    public BeneficiadoHasAuxilio(Integer id, AuxilioGovernamental auxilio, Beneficiado beneficiado) {
        this.id = id;
        this.auxilio = auxilio;
        this.beneficiado = beneficiado;
    }

    public BeneficiadoHasAuxilio() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AuxilioGovernamental getAuxilio() {
        return auxilio;
    }

    public void setAuxilio(AuxilioGovernamental auxilio) {
        this.auxilio = auxilio;
    }

    public Beneficiado getBeneficiado() {
        return beneficiado;
    }

    public void setBeneficiado(Beneficiado beneficiado) {
        this.beneficiado = beneficiado;
    }
}
