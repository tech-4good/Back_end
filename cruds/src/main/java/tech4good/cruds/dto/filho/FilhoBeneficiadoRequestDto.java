package tech4good.cruds.dto.filho;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

@Schema(description = "Objeto de requisição para filhos dos beneficiados")
public class FilhoBeneficiadoRequestDto {

    @Schema(description = "Data de nascimento do filho", example = "2005/02/15")
    @NotNull
    @PastOrPresent
    private LocalDate dataNascimento;
    @Schema(description = "O filho está estudaando?", example = "1")
    @NotNull
    private Integer isEstudante;
    @Schema(description = "O filho está em uma creche?", example = "0")
    @NotNull
    private Integer hasCreche;

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public @NotNull Integer getIsEstudante() {
        return isEstudante;
    }

    public void setIsEstudante(@NotNull Integer isEstudante) {
        this.isEstudante = isEstudante;
    }

    public @NotNull Integer getHasCreche() {
        return hasCreche;
    }

    public void setHasCreche(@NotNull Integer hasCreche) {
        this.hasCreche = hasCreche;
    }
}
