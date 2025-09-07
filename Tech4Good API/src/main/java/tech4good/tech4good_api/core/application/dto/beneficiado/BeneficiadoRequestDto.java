package tech4good.tech4good_api.core.application.dto.beneficiado;

import java.time.LocalDate;

public class BeneficiadoRequestDto {
    private String cpf;           // Mudado de Cpf para String
    private String nome;
    private String rg;            // Mudado de Rg para String
    private LocalDate dataNascimento;
    private String naturalidade;
    private String telefone;      // Mudado de Telefone para String
    private String estadoCivil;   // Mudado de EstadoCivil para String
    private String escolaridade;
    private String profissao;
    private Double rendaMensal;   // Mudado de Renda para Double
    private String empresa;
    private String cargo;
    private String religiao;     // Mudado de Religiao para String
    private Integer enderecoId;  // Mudado de Endereco para Integer (ID do endereço)
    private Integer quantidadeDependentes;

    public BeneficiadoRequestDto() {
    }

    public BeneficiadoRequestDto(String cpf, String nome, String rg, LocalDate dataNascimento, String naturalidade,
                                String telefone, String estadoCivil, String escolaridade, String profissao,
                                Double rendaMensal, String empresa, String cargo, String religiao,
                                Integer enderecoId, Integer quantidadeDependentes) {
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
}
