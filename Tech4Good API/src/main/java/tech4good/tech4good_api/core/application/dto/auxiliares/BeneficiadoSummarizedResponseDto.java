package tech4good.tech4good_api.core.application.dto.auxiliares;

import io.swagger.v3.oas.annotations.media.Schema;
import tech4good.tech4good_api.core.domain.shared.valueobject.Cpf;

@Schema(description = "Objeto de resposta para auxiliar entre filhos e beneficiados")
public class BeneficiadoSummarizedResponseDto {

    @Schema(description = "CPF do beneficiado", example = "12345678901")
    private Cpf cpf;
    @Schema(description = "Nome completo do beneficiado", example = "Lucas Alves Matos")
    private String nome;

    public BeneficiadoSummarizedResponseDto(Cpf cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public BeneficiadoSummarizedResponseDto() {
    }

    public Cpf getCpf() {
        return cpf;
    }

    public void setCpf(Cpf cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
