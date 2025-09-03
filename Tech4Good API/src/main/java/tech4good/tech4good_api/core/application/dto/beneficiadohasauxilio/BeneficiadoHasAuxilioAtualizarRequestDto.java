package tech4good.tech4good_api.core.application.dto.beneficiadohasauxilio;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Objeto de atualização para auxiliar entre beneficiado e auxílio governamental")
public class BeneficiadoHasAuxilioAtualizarRequestDto {

    @Schema(description = "ID do beneficiado", example = "1")
    @NotNull
    private Integer beneficiadoId;

    @Schema(description = "ID do auxílio governamental", example = "1")
    @NotNull
    private Integer auxilioGovernamentalId;

    public BeneficiadoHasAuxilioAtualizarRequestDto() {
    }

    public BeneficiadoHasAuxilioAtualizarRequestDto(Integer beneficiadoId, Integer auxilioGovernamentalId) {
        this.beneficiadoId = beneficiadoId;
        this.auxilioGovernamentalId = auxilioGovernamentalId;
    }

    public Integer getBeneficiadoId() {
        return beneficiadoId;
    }

    public void setBeneficiadoId(Integer beneficiadoId) {
        this.beneficiadoId = beneficiadoId;
    }

    public Integer getAuxilioGovernamentalId() {
        return auxilioGovernamentalId;
    }

    public void setAuxilioGovernamentalId(Integer auxilioGovernamentalId) {
        this.auxilioGovernamentalId = auxilioGovernamentalId;
    }
}
