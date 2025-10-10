package tech4good.tech4good_api.core.application.dto.beneficiado;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(description = "DTO para cadastro simplificado de beneficiado")
public class BeneficiadoSimplesRequestDto {

    @Schema(description = "CPF do beneficiado (somente números)", example = "12345678901")
    private String cpf;

    @Schema(description = "Nome completo do beneficiado", example = "Maria Silva Santos")
    private String nome;

    @Schema(description = "Data de nascimento do beneficiado", example = "1985-03-15")
    private LocalDate dataNascimento;

    @Schema(description = "ID do endereço cadastrado", example = "1")
    private Integer enderecoId;

    @Schema(description = "ID da foto do beneficiado", example = "1")
    private Integer fotoId;

    public BeneficiadoSimplesRequestDto() {}

    public BeneficiadoSimplesRequestDto(String cpf, String nome, LocalDate dataNascimento, Integer enderecoId, Integer fotoId) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.enderecoId = enderecoId;
        this.fotoId = fotoId;
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Integer enderecoId) {
        this.enderecoId = enderecoId;
    }

    public Integer getFotoId() {
        return fotoId;
    }

    public void setFotoId(Integer fotoId) {
        this.fotoId = fotoId;
    }
}
