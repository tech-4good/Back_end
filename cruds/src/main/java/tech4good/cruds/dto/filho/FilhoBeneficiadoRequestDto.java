package tech4good.cruds.dto.filho;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class FilhoBeneficiadoRequestDto {

    @NotNull
    @PastOrPresent
    private LocalDate dataNascimento;
    @NotNull
    private String isEstudante;
    @NotNull
    private String hasCreche;

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getIsEstudante() {
        return isEstudante;
    }

    public void setIsEstudante(String isEstudante) {
        this.isEstudante = isEstudante;
    }

    public String getHasCreche() {
        return hasCreche;
    }

    public void setHasCreche(String hasCreche) {
        this.hasCreche = hasCreche;
    }
}
