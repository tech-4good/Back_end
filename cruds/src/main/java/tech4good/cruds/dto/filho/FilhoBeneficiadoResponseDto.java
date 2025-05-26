package tech4good.cruds.dto.filho;

import io.swagger.v3.oas.annotations.media.Schema;
import tech4good.cruds.dto.auxiliares.BeneficiadoSummarizedResponseDto;
import tech4good.cruds.dto.auxiliares.EnderecoSummarizedFilhoBeneficiadoResponseDto;

import java.time.LocalDate;

@Schema(description = "Objeto de resposta para filhos dos beneficiados")
public class FilhoBeneficiadoResponseDto {

    @Schema(description = "Identificador único do filho do beneficiado", example = "1")
    private Integer idFilhoBeneficiado;
    @Schema(description = "Data de nascimento do filho", example = "2005/02/15")
    private LocalDate dataNascimento;
    @Schema(description = "O filho está estudaando?", example = "1")
    private Integer isEstudante;
    @Schema(description = "O filho está em uma creche?", example = "0")
    private Integer hasCreche;
    private EnderecoSummarizedFilhoBeneficiadoResponseDto endereco;
    private BeneficiadoSummarizedResponseDto beneficiado;

    public FilhoBeneficiadoResponseDto(Integer idFilhoBeneficiado, LocalDate dataNascimento, Integer isEstudante, Integer hasCreche, EnderecoSummarizedFilhoBeneficiadoResponseDto endereco, BeneficiadoSummarizedResponseDto beneficiado) {
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

    public EnderecoSummarizedFilhoBeneficiadoResponseDto getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoSummarizedFilhoBeneficiadoResponseDto endereco) {
        this.endereco = endereco;
    }

    public BeneficiadoSummarizedResponseDto getBeneficiado() {
        return beneficiado;
    }

    public void setBeneficiado(BeneficiadoSummarizedResponseDto beneficiado) {
        this.beneficiado = beneficiado;
    }
}
