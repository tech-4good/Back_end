package tech4good.cruds.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "auxilio_governamental")
public class AuxilioGovernamental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_auxilio")
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
