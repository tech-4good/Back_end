package tech4good.cruds.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.sql.Blob;
import java.time.LocalDate;

@Schema(description = "Objeto de entidade para beneficiado da ASA")
@Entity
public class Beneficiado {

    @Schema(description = "CPF do beneficiado (somente números)", example = "12345678901")
    @EmbeddedId
    private BeneficiadoId id;

    @Schema(description = "Nome completo do beneficiado", example = "Lucas Alves Matos")
    private String nome;
    @Schema(description = "RG do beneficiado (somente números)", example = "5583567")
    private String rg;

    @Schema(description = "Data de nascimento do beneficiado", example = "1978/03/21")
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    @Schema(description = "Naturalidade do beneficiado", example = "Brasileiro")
    private String naturalidade;
    @Schema(description = "Telefone para contato com DDD", example = "(11)91234-5678")
    private String telefone;

    @Schema(description = "Estado civil do beneficiado", example = "Divorciado")
    @Column(name = "estado_civil")
    private String estadoCivil;
    @Schema(description = "Nível de escolaridade do beneficiado", example = "Ensino médio completo")
    private String escolaridade;
    @Schema(description = "Profissão do beneficiado", example = "Técnico de Limpeza")
    private String profissao;

    @Schema(description = "Renda mensal do beneficiado", example = "2000,0")
    @Column(name = "renda_mensal")
    private Double rendaMensal;
    @Schema(description = "Nome da empresa em que o beneficiado trabalha", example = "Limpeza Total")
    private String empresa;
    @Schema(description = "Cargo profissional do beneficiado", example = "Auxiliar")
    private String cargo;
    @Schema(description = "Religião do beneficiado", example = "Evangélico")
    private String religiao;

    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @Schema(description = "Quantidade de pessoas que dependem financeiramente do beneficiado", example = "3")
    @Column(name = "quantidade_dependentes")
    private Integer quantidadeDependentes;

    @Schema(description = "Foto do beneficiado")
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
