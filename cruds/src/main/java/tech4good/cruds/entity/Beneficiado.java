package tech4good.cruds.entity;

import jakarta.persistence.*;

import java.sql.Blob;
import java.time.LocalDate;

@Entity
public class Beneficiado {

    @EmbeddedId
    private BeneficiadoId id;

    private String nome;
    private String rg;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    private String naturalidade;
    private String telefone;

    @Column(name = "estado_civil")
    private String estadoCivil;
    private String escolaridade;
    private String profissao;

    @Column(name = "renda_mensal")
    private Double rendaMensal;
    private String empresa;
    private String cargo;
    private String religiao;

    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @Column(name = "quantidade_dependentes")
    private Integer quantidadeDependentes;

    @Column(name = "foto_beneficiado")
    private byte[] fotoBeneficiado;

    public Beneficiado() {
    }

    public Beneficiado(BeneficiadoId id, String nome, String rg, LocalDate dataNascimento, String naturalidade, String telefone, String estadoCivil, String escolaridade, String profissao, Double rendaMensal, String empresa, String cargo, String religiao, Endereco endereco, Integer quantidadeDependentes, byte[] fotoBeneficiado) {
        this.id = id;
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
        this.fotoBeneficiado = fotoBeneficiado;
    }

    public BeneficiadoId getId() {
        return id;
    }

    public void setId(BeneficiadoId id) {
        this.id = id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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

    public byte[] getFotoBeneficiado() {
        return fotoBeneficiado;
    }

    public void setFotoBeneficiado(byte[] fotoBeneficiado) {
        this.fotoBeneficiado = fotoBeneficiado;
    }
}
