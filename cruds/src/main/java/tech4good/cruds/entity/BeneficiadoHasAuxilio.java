package tech4good.cruds.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Schema(description = "Objeto de entidade para auxiliar entre beneficiado e auxilio governamental")
@Entity
@Table(name = "beneficiado_has_auxilio")
public class BeneficiadoHasAuxilio {

    @Schema(description = "Identificador único de auxiliar entre beneficiado e auxilio governamental", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_beneficiado_has_auxilio")
    private Integer idBeneficiadoHasAuxilio;
    @ManyToOne
    @JoinColumn(name = "id_auxilio")
    private AuxilioGovernamental auxilioGovernamental;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "id_beneficiado", referencedColumnName = "id_beneficiado"),
            @JoinColumn(name = "cpf", referencedColumnName = "cpf")
    })
    private Beneficiado beneficiado;

    public Beneficiado getBeneficiado() {
        return beneficiado;
    }

    public void setBeneficiado(Beneficiado beneficiado) {
        this.beneficiado = beneficiado;
    }

    public AuxilioGovernamental getAuxilioGovernamental() {
        return auxilioGovernamental;
    }

    public void setAuxilioGovernamental(AuxilioGovernamental auxilioGovernamental) {
        this.auxilioGovernamental = auxilioGovernamental;
    }

    public Integer getIdBeneficiadoHasAuxilio() {
        return idBeneficiadoHasAuxilio;
    }

    public void setIdBeneficiadoHasAuxilio(Integer idBeneficiadoHasAuxilio) {
        this.idBeneficiadoHasAuxilio = idBeneficiadoHasAuxilio;
    }
}
