package tech4good.tech4good_api.core.application.dto.beneficiado;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto de resposta resumido para beneficiado")
public class BeneficiadoSummarizedDto {

    @Schema(description = "Identificador único do beneficiado", example = "1")
    private Integer id;

    @Schema(description = "CPF do beneficiado", example = "12345678901")
    private String cpf;

    @Schema(description = "Nome completo do beneficiado", example = "Maria Silva Santos")
    private String nome;

    @Schema(description = "Telefone para contato", example = "(11)98765-4321")
    private String telefone;

    @Schema(description = "Quantidade de dependentes", example = "3")
    private Integer quantidadeDependentes;

    public BeneficiadoSummarizedDto() {
    }

    public BeneficiadoSummarizedDto(Integer id, String cpf, String nome, String telefone, Integer quantidadeDependentes) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.quantidadeDependentes = quantidadeDependentes;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getQuantidadeDependentes() {
        return quantidadeDependentes;
    }

    public void setQuantidadeDependentes(Integer quantidadeDependentes) {
        this.quantidadeDependentes = quantidadeDependentes;
    }
}
