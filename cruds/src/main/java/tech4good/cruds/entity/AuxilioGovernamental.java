package tech4good.cruds.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AuxilioGovernamental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAuxilio;
    private String tipo;

    public Integer getIdAuxilio() {
        return idAuxilio;
    }

    public void setIdAuxilio(Integer idAuxilio) {
        this.idAuxilio = idAuxilio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
