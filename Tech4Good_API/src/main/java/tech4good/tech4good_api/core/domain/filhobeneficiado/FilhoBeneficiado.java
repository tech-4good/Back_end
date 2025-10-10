package tech4good.tech4good_api.core.domain.filhobeneficiado;

import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;
import tech4good.tech4good_api.core.domain.endereco.Endereco;

import java.time.LocalDate;

public class FilhoBeneficiado {
    private Integer id;
    private LocalDate dataNascimento;
    private Boolean isEstudante;
    private Boolean hasCreche;
    private Beneficiado beneficiado;
    private Endereco endereco;

    public FilhoBeneficiado(Integer id, LocalDate dataNascimento, Boolean isEstudante, Boolean hasCreche, Beneficiado beneficiado, Endereco endereco) {
        this.id = id;
        this.dataNascimento = dataNascimento;
        this.isEstudante = isEstudante;
        this.hasCreche = hasCreche;
        this.beneficiado = beneficiado;
        this.endereco = endereco;
    }

    public FilhoBeneficiado() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Boolean getEstudante() {
        return isEstudante;
    }

    public void setEstudante(Boolean estudante) {
        isEstudante = estudante;
    }

    public Boolean getHasCreche() {
        return hasCreche;
    }

    public void setHasCreche(Boolean hasCreche) {
        this.hasCreche = hasCreche;
    }

    public Beneficiado getBeneficiado() {
        return beneficiado;
    }

    public void setBeneficiado(Beneficiado beneficiado) {
        this.beneficiado = beneficiado;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
