package tech4good.tech4good_api.core.application.dto.beneficiado;

import io.swagger.v3.oas.annotations.media.Schema;
import tech4good.tech4good_api.core.application.dto.endereco.EnderecoSummarizedDto;
import java.time.LocalDate;

@Schema(description = "Resposta com dados do beneficiado")
public class BeneficiadoResponseDto {
    @Schema(description = "Identificador único do beneficiado", example = "1")
    private Integer id;

    @Schema(description = "CPF do beneficiado", example = "12345678901")
    private String cpf;

    @Schema(description = "Nome completo do beneficiado", example = "Maria Silva Santos")
    private String nome;

    @Schema(description = "RG do beneficiado", example = "123456789")
    private String rg;

    @Schema(description = "Data de nascimento do beneficiado", example = "1985-03-15")
    private LocalDate dataNascimento;

    @Schema(description = "Naturalidade do beneficiado", example = "Brasileira")
    private String naturalidade;

    @Schema(description = "Telefone para contato", example = "(11)98765-4321")
    private String telefone;

    @Schema(description = "Estado civil do beneficiado", example = "CASADO")
    private String estadoCivil;

    @Schema(description = "Nível de escolaridade", example = "Ensino médio completo")
    private String escolaridade;

    @Schema(description = "Profissão do beneficiado", example = "Auxiliar de limpeza")
    private String profissao;

    @Schema(description = "Renda mensal em reais", example = "1500.00")
    private Double rendaMensal;

    @Schema(description = "Nome da empresa onde trabalha", example = "Limpeza Total Ltda")
    private String empresa;

    @Schema(description = "Cargo que ocupa", example = "Auxiliar de serviços gerais")
    private String cargo;

    @Schema(description = "Religião do beneficiado", example = "Católica")
    private String religiao;

    @Schema(description = "Informações resumidas do endereço onde reside")
    private EnderecoSummarizedDto endereco;

    @Schema(description = "Quantidade de dependentes", example = "3")
    private Integer quantidadeDependentes;

    @Schema(description = "ID da foto do beneficiado", example = "1")
    private Integer fotoId;

    public BeneficiadoResponseDto() {
    }

    public BeneficiadoResponseDto(Integer id, String cpf, String nome, String rg, LocalDate dataNascimento,
                                 String naturalidade, String telefone, String estadoCivil, String escolaridade,
                                 String profissao, Double rendaMensal, String empresa, String cargo,
                                 String religiao, EnderecoSummarizedDto endereco, Integer quantidadeDependentes, Integer fotoId) {
        this.id = id;
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
        this.endereco = endereco;
        this.quantidadeDependentes = quantidadeDependentes;
        this.fotoId = fotoId;
    }

    // Getters e setters
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

    public EnderecoSummarizedDto getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoSummarizedDto endereco) {
        this.endereco = endereco;
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
