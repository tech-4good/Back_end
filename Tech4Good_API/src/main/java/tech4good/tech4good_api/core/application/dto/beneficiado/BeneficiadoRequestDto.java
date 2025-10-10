package tech4good.tech4good_api.core.application.dto.beneficiado;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

@Schema(description = "DTO para cadastro de beneficiado")
public class BeneficiadoRequestDto {

    @Schema(description = "CPF do beneficiado (somente números)", example = "12345678901", required = true)
    @NotBlank(message = "CPF é obrigatório")
    private String cpf;

    @Schema(description = "Nome completo do beneficiado", example = "Maria Silva Santos", required = true)
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Schema(description = "RG do beneficiado (somente números)", example = "123456789", required = true)
    @NotBlank(message = "RG é obrigatório")
    private String rg;

    @Schema(description = "Data de nascimento do beneficiado", example = "1985-03-15", required = true)
    @NotNull(message = "Data de nascimento é obrigatória")
    private LocalDate dataNascimento;

    @Schema(description = "Naturalidade do beneficiado", example = "Brasileira", required = true)
    @NotBlank(message = "Naturalidade é obrigatória")
    private String naturalidade;

    @Schema(description = "Telefone para contato com DDD", example = "(11)98765-4321", required = true)
    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;

    @Schema(description = "Estado civil do beneficiado", example = "CASADO", required = true)
    @NotBlank(message = "Estado civil é obrigatório")
    private String estadoCivil;

    @Schema(description = "Nível de escolaridade do beneficiado", example = "Ensino médio completo", required = true)
    @NotBlank(message = "Escolaridade é obrigatória")
    private String escolaridade;

    @Schema(description = "Profissão do beneficiado", example = "Auxiliar de limpeza", required = true)
    @NotBlank(message = "Profissão é obrigatória")
    private String profissao;

    @Schema(description = "Renda mensal do beneficiado em reais", example = "1500.00", required = true)
    @NotNull(message = "Renda mensal é obrigatória")
    @Positive(message = "Renda mensal deve ser positiva")
    private Double rendaMensal;

    @Schema(description = "Nome da empresa onde trabalha", example = "Limpeza Total Ltda", required = false)
    private String empresa;

    @Schema(description = "Cargo que ocupa na empresa", example = "Auxiliar de serviços gerais", required = false)
    private String cargo;

    @Schema(description = "Religião do beneficiado", example = "Católica", required = false)
    private String religiao;

    @Schema(description = "ID do endereço onde reside", example = "1", required = true)
    @NotNull(message = "ID do endereço é obrigatório")
    @Positive(message = "ID do endereço deve ser positivo")
    private Integer enderecoId;

    @Schema(description = "Quantidade de pessoas que dependem financeiramente do beneficiado", example = "3", required = true)
    @NotNull(message = "Quantidade de dependentes é obrigatória")
    @PositiveOrZero(message = "Quantidade de dependentes deve ser zero ou positiva")
    private Integer quantidadeDependentes;

    @Schema(description = "ID da foto do beneficiado", example = "1", required = false)
    @Positive(message = "ID da foto deve ser positivo")
    private Integer fotoId;

    public BeneficiadoRequestDto() {
    }

    public BeneficiadoRequestDto(String cpf, String nome, String rg, LocalDate dataNascimento, String naturalidade,
                                String telefone, String estadoCivil, String escolaridade, String profissao,
                                Double rendaMensal, String empresa, String cargo, String religiao,
                                Integer enderecoId, Integer quantidadeDependentes, Integer fotoId) {
        this.cpf = cpf;
        this.nome = nome;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.naturalidade = naturalidade;
        this.telefone = telefone;
        this.estadoCivil = estadoCivil;
        this.escolaridade = escolaridade;
        this.profissao = profissao;
        this.rendaMensal = rendaMensal;
        this.empresa = empresa;
        this.cargo = cargo;
        this.religiao = religiao;
        this.enderecoId = enderecoId;
        this.quantidadeDependentes = quantidadeDependentes;
        this.fotoId = fotoId;
    }

    // Getters e setters
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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public Double getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(Double rendaMensal) {
        this.rendaMensal = rendaMensal;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getReligiao() {
        return religiao;
    }

    public void setReligiao(String religiao) {
        this.religiao = religiao;
    }

    public Integer getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Integer enderecoId) {
        this.enderecoId = enderecoId;
    }

    public Integer getQuantidadeDependentes() {
        return quantidadeDependentes;
    }

    public void setQuantidadeDependentes(Integer quantidadeDependentes) {
        this.quantidadeDependentes = quantidadeDependentes;
    }

    public Integer getFotoId() {
        return fotoId;
    }

    public void setFotoId(Integer fotoId) {
        this.fotoId = fotoId;
    }
}
