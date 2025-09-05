package tech4good.tech4good_api.core.application.dto.filhobeneficiado;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

@Schema(description = "Objeto de requisição para filhos dos beneficiados")
public class FilhoBeneficiadoRequestDto {

    @Schema(description = "Data de nascimento do filho", example = "2005-02-15")
    @NotNull
    @PastOrPresent
    private LocalDate dataNascimento;

    @Schema(description = "O filho está estudando?", example = "true")
    @NotNull
    private Boolean isEstudante;

    @Schema(description = "O filho está em uma creche?", example = "false")
    @NotNull
    private Boolean hasCreche;

    @Schema(description = "Chave estrangeira do beneficiado associado", example = "1")
    @NotNull
    private Integer beneficiadoId;

    @Schema(description = "Chave estrangeira do endereço associado", example = "1")
    @NotNull
    private Integer enderecoId;

    public FilhoBeneficiadoRequestDto() {
    }

    public FilhoBeneficiadoRequestDto(LocalDate dataNascimento, Boolean isEstudante, Boolean hasCreche, Integer beneficiadoId, Integer enderecoId) {
        this.dataNascimento = dataNascimento;
        this.isEstudante = isEstudante;
        this.hasCreche = hasCreche;
        this.beneficiadoId = beneficiadoId;
        this.enderecoId = enderecoId;
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

    public Integer getBeneficiadoId() {
        return beneficiadoId;
    }

    public void setBeneficiadoId(Integer beneficiadoId) {
        this.beneficiadoId = beneficiadoId;
    }

    public Integer getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Integer enderecoId) {
        this.enderecoId = enderecoId;
    }
}
