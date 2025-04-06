package tech4good.cruds.dto;

import java.time.LocalDate;

public class FilhoBeneficiadoRequestDto {

    private LocalDate dataNascimento;
    private String isEstudante;
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
