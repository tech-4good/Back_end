package tech4good.cruds.dto.auxiliares;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto de resposta para auxiliar entre filhos e beneficiados")
public class BeneficiadoSummarizedResponseDto {

    @Schema(description = "CPF do beneficiado (somente números)", example = "12345678901")
    private String cpf;
    @Schema(description = "Nome completo do beneficiado", example = "Lucas Alves Matos")
    private String nome;

    public BeneficiadoSummarizedResponseDto(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public BeneficiadoSummarizedResponseDto() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
