package tech4good.cruds.dto;

import java.time.LocalDate;

public class FilhoBeneficiadoResponseDto {

    private Integer idFilhoBeneficiado;
    private LocalDate dataNascimento;
    private String isEstudante;
    private String hasCreche;

    public Integer getIdFilhoBeneficiado() {
        return idFilhoBeneficiado;
    }

    public void setIdFilhoBeneficiado(Integer idFilhoBeneficiado) {
        this.idFilhoBeneficiado = idFilhoBeneficiado;
    }

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
