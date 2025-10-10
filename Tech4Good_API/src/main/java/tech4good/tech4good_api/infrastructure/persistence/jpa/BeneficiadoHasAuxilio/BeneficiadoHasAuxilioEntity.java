package tech4good.tech4good_api.infrastructure.persistence.jpa.BeneficiadoHasAuxilio;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import tech4good.tech4good_api.infrastructure.persistence.jpa.AuxilioGovernamental.AuxilioGovernamentalEntity;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Beneficiado.BeneficiadoEntity;

@Schema(description = "Entidade JPA para auxiliar entre beneficiado e auxílio governamental")
@Entity
@Table(name = "beneficiado_has_auxilio")
public class BeneficiadoHasAuxilioEntity {

    @Schema(description = "Identificador único da relação beneficiado-auxílio", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_beneficiado_has_auxilio")
    private Integer idBeneficiadoHasAuxilio;

    @ManyToOne
    @JoinColumn(name = "id_auxilio")
    private AuxilioGovernamentalEntity auxilioGovernamental;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "id_beneficiado", referencedColumnName = "id_beneficiado"),
            @JoinColumn(name = "cpf", referencedColumnName = "cpf")
    })
    private BeneficiadoEntity beneficiado;

    public BeneficiadoHasAuxilioEntity() {
    }

    public BeneficiadoHasAuxilioEntity(Integer idBeneficiadoHasAuxilio, AuxilioGovernamentalEntity auxilioGovernamental, BeneficiadoEntity beneficiado) {
        this.idBeneficiadoHasAuxilio = idBeneficiadoHasAuxilio;
        this.auxilioGovernamental = auxilioGovernamental;
        this.beneficiado = beneficiado;
    }

    public Integer getIdBeneficiadoHasAuxilio() {
        return idBeneficiadoHasAuxilio;
    }

    public void setIdBeneficiadoHasAuxilio(Integer idBeneficiadoHasAuxilio) {
        this.idBeneficiadoHasAuxilio = idBeneficiadoHasAuxilio;
    }

    public AuxilioGovernamentalEntity getAuxilioGovernamental() {
        return auxilioGovernamental;
    }

    public void setAuxilioGovernamental(AuxilioGovernamentalEntity auxilioGovernamental) {
        this.auxilioGovernamental = auxilioGovernamental;
    }

    public BeneficiadoEntity getBeneficiado() {
        return beneficiado;
    }

    public void setBeneficiado(BeneficiadoEntity beneficiado) {
        this.beneficiado = beneficiado;
    }
}
