package tech4good.cruds.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Schema(description = "Objeto de entidade para auxílios governamentais")
@Entity
@Table(name = "auxilio_governamental")
public class AuxilioGovernamental {

    @Schema(description = "Identificador único do auxílio governamental", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_auxilio")
    private Integer idAuxilio;
    @Schema(description = "Nome do tipo de auxílio", example = "Bolsa Família")
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
