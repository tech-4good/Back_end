package tech4good.cruds.dto.filho;

import tech4good.cruds.dto.auxiliares.FilhoBeneficiadoBeneficiadoResponseDto;
import tech4good.cruds.dto.auxiliares.FilhoBeneficiadoEnderecoResponseDto;

import java.time.LocalDate;

public class FilhoBeneficiadoResponseDto {

    private Integer idFilhoBeneficiado;
    private LocalDate dataNascimento;
    private String isEstudante;
    private String hasCreche;
    private FilhoBeneficiadoEnderecoResponseDto endereco;
    private FilhoBeneficiadoBeneficiadoResponseDto beneficiado;

    public FilhoBeneficiadoResponseDto(Integer idFilhoBeneficiado, LocalDate dataNascimento, String isEstudante, String hasCreche, FilhoBeneficiadoEnderecoResponseDto endereco, FilhoBeneficiadoBeneficiadoResponseDto beneficiado) {
        this.idFilhoBeneficiado = idFilhoBeneficiado;
        this.dataNascimento = dataNascimento;
        this.isEstudante = isEstudante;
        this.hasCreche = hasCreche;
        this.endereco = endereco;
        this.beneficiado = beneficiado;
    }

    public FilhoBeneficiadoResponseDto() {
    }

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

    public FilhoBeneficiadoEnderecoResponseDto getEndereco() {
        return endereco;
    }

    public void setEndereco(FilhoBeneficiadoEnderecoResponseDto endereco) {
        this.endereco = endereco;
    }

    public FilhoBeneficiadoBeneficiadoResponseDto getBeneficiado() {
        return beneficiado;
    }

    public void setBeneficiado(FilhoBeneficiadoBeneficiadoResponseDto beneficiado) {
        this.beneficiado = beneficiado;
    }
}
