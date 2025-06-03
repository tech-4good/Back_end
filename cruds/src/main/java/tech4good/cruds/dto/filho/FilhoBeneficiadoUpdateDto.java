package tech4good.cruds.dto.filho;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Objeto de atualização para filhos dos beneficiados")
public class FilhoBeneficiadoUpdateDto {

    @Schema(description = "O filho está estudaando?", example = "0")
    @NotNull
    private Integer isEstudante;
    @Schema(description = "O filho está em uma creche?", example = "1")
    @NotNull
    private Integer hasCreche;

    public Integer getIsEstudante() {
        return isEstudante;
    }

    public void setIsEstudante(Integer isEstudante) {
        this.isEstudante = isEstudante;
    }

    public Integer getHasCreche() {
        return hasCreche;
    }

    public void setHasCreche(Integer hasCreche) {
        this.hasCreche = hasCreche;
    }
}
