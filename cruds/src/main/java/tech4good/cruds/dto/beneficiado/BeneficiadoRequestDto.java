package tech4good.cruds.dto.beneficiado;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import tech4good.cruds.entity.Endereco;
import tech4good.cruds.entity.FileEntity;

import java.time.LocalDate;

@Schema(description = "Objeto de requisição para beneficiado da ASA")
public class BeneficiadoRequestDto {

    @Schema(description = "CPF do beneficiado (somente números)", example = "12345678901")
    @NotBlank
    @Size(min = 11, max = 11)
    private String cpf;
    @Schema(description = "Nome completo do beneficiado", example = "Lucas Alves Matos")
    @NotBlank
    private String nome;
    @Schema(description = "RG do beneficiado (somente números)", example = "5583567")
    @NotBlank
    private String rg;
    @Schema(description = "Data de nascimento do beneficiado", example = "1978-03-21")
    @NotBlank
    @PastOrPresent
    private LocalDate dataNascimento;
    @Schema(description = "Naturalidade do beneficiado", example = "Brasileiro")
    @NotBlank
    private String naturalidade;
    @Schema(description = "Telefone para contato com DDD", example = "11912345678")
    @NotBlank
    private String telefone;
    @Schema(description = "Estado civil do beneficiado", example = "Divorciado")
    @NotBlank
    private String estadoCivil;
    @Schema(description = "Nível de escolaridade do beneficiado", example = "Ensino médio completo")
    @NotBlank
    private String escolaridade;
    @Schema(description = "Profissão do beneficiado", example = "Técnico de Limpeza")
    @NotBlank
    private String profissao;
    @Schema(description = "Renda mensal do beneficiado", example = "2000,0")
    @NotBlank
    private Double rendaMensal;
    @Schema(description = "Nome da empresa em que o beneficiado trabalha", example = "Limpeza Total")
    private String empresa;
    @Schema(description = "Cargo profissional do beneficiado", example = "Auxiliar")
    private String cargo;
    @Schema(description = "Religião do beneficiado", example = "Evangélico")
    @NotBlank
    private String religiao;
    @Schema(description = "Chave estrangeira do endereco relacionado ao beneficiado", example = "1")
    @NotBlank
    private Integer enderecoId;
    @Schema(description = "Quantidade de pessoas que dependem financeiramente do beneficiado", example = "3")
    @NotBlank
    private Integer quantidadeDependentes;
    @Schema(description = "Foto do beneficiado codificada", example = "1")
    private Integer fotoBeneficiadoId;

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

    public Integer getQuantidadeDependentes() {
        return quantidadeDependentes;
    }

    public void setQuantidadeDependentes(Integer quantidadeDependentes) {
        this.quantidadeDependentes = quantidadeDependentes;
    }

    public Integer getFotoBeneficiadoId() {
        return fotoBeneficiadoId;
    }

    public void setFotoBeneficiadoId(Integer fotoBeneficiadoId) {
        this.fotoBeneficiadoId = fotoBeneficiadoId;
    }

    public @NotBlank Integer getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(@NotBlank Integer enderecoId) {
        this.enderecoId = enderecoId;
    }
}
