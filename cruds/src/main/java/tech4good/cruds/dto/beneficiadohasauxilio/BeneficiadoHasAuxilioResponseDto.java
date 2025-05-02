package tech4good.cruds.dto.beneficiadohasauxilio;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto de resposta para auxiliar entre beneficiado e auxilio governamental")
public class BeneficiadoHasAuxilioResponseDto {

    @Schema(description = "Identificador único de auxiliar entre beneficiado e auxilio governamental", example = "1")
    private Integer beneficiadoHasAuxilio;

    public Integer getBeneficiadoHasAuxilio() {
        return beneficiadoHasAuxilio;
    }

    public void setBeneficiadoHasAuxilio(Integer beneficiadoHasAuxilio) {
        this.beneficiadoHasAuxilio = beneficiadoHasAuxilio;
    }
}
