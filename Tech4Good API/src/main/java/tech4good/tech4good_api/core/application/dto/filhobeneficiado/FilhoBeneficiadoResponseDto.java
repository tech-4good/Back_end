package tech4good.tech4good_api.core.application.dto.filhobeneficiado;

import io.swagger.v3.oas.annotations.media.Schema;
import tech4good.tech4good_api.core.application.dto.auxiliares.BeneficiadoSummarizedResponseDto;
import tech4good.tech4good_api.core.application.dto.auxiliares.EnderecoSummarizedFilhoBeneficiadoResponseDto;

import java.time.LocalDate;

@Schema(description = "Objeto de resposta para filhos dos beneficiados")
public class FilhoBeneficiadoResponseDto {

    @Schema(description = "Identificador único do filho do beneficiado", example = "1")
    private Integer idFilhoBeneficiado;

    @Schema(description = "Data de nascimento do filho", example = "2005-02-15")
    private LocalDate dataNascimento;

    @Schema(description = "O filho está estudando?", example = "true")
    private Boolean isEstudante;

    @Schema(description = "O filho está em uma creche?", example = "false")
    private Boolean hasCreche;

    private EnderecoSummarizedFilhoBeneficiadoResponseDto endereco;
    private BeneficiadoSummarizedResponseDto beneficiado;

    public FilhoBeneficiadoResponseDto() {
    }

    public FilhoBeneficiadoResponseDto(Integer idFilhoBeneficiado, LocalDate dataNascimento, Boolean isEstudante, Boolean hasCreche, EnderecoSummarizedFilhoBeneficiadoResponseDto endereco, BeneficiadoSummarizedResponseDto beneficiado) {
        this.idFilhoBeneficiado = idFilhoBeneficiado;
        this.dataNascimento = dataNascimento;
        this.isEstudante = isEstudante;
        this.hasCreche = hasCreche;
        this.endereco = endereco;
        this.beneficiado = beneficiado;
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

    public Boolean getIsEstudante() {
        return isEstudante;
    }

    public void setIsEstudante(Boolean isEstudante) {
        this.isEstudante = isEstudante;
    }

    public Boolean getHasCreche() {
        return hasCreche;
    }

    public void setHasCreche(Boolean hasCreche) {
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
