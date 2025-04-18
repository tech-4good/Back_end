package tech4good.cruds.dto.filho;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class FilhoBeneficiadoRequestDto {

    @NotNull
    @PastOrPresent
    private LocalDate dataNascimento;
    @NotNull
    private Integer isEstudante;
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
