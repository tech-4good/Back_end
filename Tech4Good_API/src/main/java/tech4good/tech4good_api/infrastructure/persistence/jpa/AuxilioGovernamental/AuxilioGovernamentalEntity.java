package tech4good.tech4good_api.infrastructure.persistence.jpa.AuxilioGovernamental;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import tech4good.tech4good_api.core.domain.auxiliogovernamental.valueobject.Auxilio;
import tech4good.tech4good_api.infrastructure.persistence.jpa.AuxilioGovernamental.converter.AuxilioConverter;

@Schema(description = "Entidade JPA para auxílios governamentais")
@Entity
@Table(name = "auxilio_governamental")
public class AuxilioGovernamentalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_auxilio")
    private Integer idAuxilio;

    @Schema(description = "Tipo do auxílio governamental", example = "Bolsa Família")
    @Column(name = "tipo", nullable = false)
    @Convert(converter = AuxilioConverter.class)
    private Auxilio tipo;

    public AuxilioGovernamentalEntity() {
    }

    public AuxilioGovernamentalEntity(Integer idAuxilio, Auxilio tipo) {
        this.idAuxilio = idAuxilio;
        this.tipo = tipo;
    }

    public Integer getIdAuxilio() {
        return idAuxilio;
    }

    public void setIdAuxilio(Integer idAuxilio) {
        this.idAuxilio = idAuxilio;
    }

    public Auxilio getTipo() {
        return tipo;
    }

    public void setTipo(Auxilio tipo) {
        this.tipo = tipo;
    }
}
