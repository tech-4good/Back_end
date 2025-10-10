package tech4good.tech4good_api.core.domain.auxiliogovernamental;

import tech4good.tech4good_api.core.domain.auxiliogovernamental.valueobject.Auxilio;

public class AuxilioGovernamental {
    private Integer id;
    private Auxilio tipo;

    public AuxilioGovernamental(Integer id, Auxilio tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public AuxilioGovernamental() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Auxilio getTipo() {
        return tipo;
    }

    public void setTipo(Auxilio tipo) {
        this.tipo = tipo;
    }
}
