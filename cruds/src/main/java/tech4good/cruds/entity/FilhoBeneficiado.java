package tech4good.cruds.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class FilhoBeneficiado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
