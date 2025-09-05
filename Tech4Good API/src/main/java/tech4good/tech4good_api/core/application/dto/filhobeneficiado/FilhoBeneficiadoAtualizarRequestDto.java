package tech4good.tech4good_api.core.application.dto.filhobeneficiado;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto de atualização para filhos dos beneficiados")
public class FilhoBeneficiadoAtualizarRequestDto {

    @Schema(description = "O filho está estudando?", example = "false")
    private Boolean isEstudante;

    @Schema(description = "O filho está em uma creche?", example = "true")
    private Boolean hasCreche;

    public FilhoBeneficiadoAtualizarRequestDto() {
    }

    public FilhoBeneficiadoAtualizarRequestDto(Boolean isEstudante, Boolean hasCreche) {
        this.isEstudante = isEstudante;
        this.hasCreche = hasCreche;
    }

    public Boolean getIsEstudante() {
        return isEstudante;
    }

    public void setIsEstudante(Boolean isEstudante) {
        this.isEstudante = isEstudante;
    }

    public Boolean getHasCreche() {
        return hasCreche;
    }

    public void setHasCreche(Boolean hasCreche) {
        this.hasCreche = hasCreche;
    }
}
