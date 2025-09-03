package tech4good.tech4good_api.core.application.dto.beneficiadohasauxilio;

import io.swagger.v3.oas.annotations.media.Schema;
import tech4good.tech4good_api.core.application.dto.auxiliogovernamental.AuxilioGovernamentalResponseDto;
import tech4good.tech4good_api.core.application.dto.beneficiado.BeneficiadoResponseDto;

@Schema(description = "Objeto de resposta para auxiliar entre beneficiado e auxílio governamental")
public class BeneficiadoHasAuxilioResponseDto {

    @Schema(description = "Identificador único da relação beneficiado-auxílio", example = "1")
    private Integer id;

    @Schema(description = "Dados do beneficiado")
    private BeneficiadoResponseDto beneficiado;

    @Schema(description = "Dados do auxílio governamental")
    private AuxilioGovernamentalResponseDto auxilioGovernamental;

    public BeneficiadoHasAuxilioResponseDto() {
    }

    public BeneficiadoHasAuxilioResponseDto(Integer id, BeneficiadoResponseDto beneficiado, AuxilioGovernamentalResponseDto auxilioGovernamental) {
        this.id = id;
        this.beneficiado = beneficiado;
        this.auxilioGovernamental = auxilioGovernamental;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BeneficiadoResponseDto getBeneficiado() {
        return beneficiado;
    }

    public void setBeneficiado(BeneficiadoResponseDto beneficiado) {
        this.beneficiado = beneficiado;
    }

    public AuxilioGovernamentalResponseDto getAuxilioGovernamental() {
        return auxilioGovernamental;
    }

    public void setAuxilioGovernamental(AuxilioGovernamentalResponseDto auxilioGovernamental) {
        this.auxilioGovernamental = auxilioGovernamental;
    }
}
