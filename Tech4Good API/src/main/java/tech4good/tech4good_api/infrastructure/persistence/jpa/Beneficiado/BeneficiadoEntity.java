package tech4good.tech4good_api.infrastructure.persistence.jpa.Beneficiado;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import tech4good.tech4good_api.core.domain.beneficiado.valueobject.EstadoCivil;
import tech4good.tech4good_api.core.domain.endereco.Endereco;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco.EnderecoEntity;
import tech4good.tech4good_api.infrastructure.persistence.jpa.File.FileEntity;

import java.time.LocalDate;

@Schema(description = "Objeto de entidade para beneficiado da ASA")
@Entity
public class BeneficiadoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_beneficiado")
    private Integer id;

    @Schema(description = "CPF do beneficiado (somente números)", example = "12345678901")
    private String cpf;

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
    private EstadoCivil estadoCivil;
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
    @JoinColumn(name = "fk_endereco")
    private EnderecoEntity endereco;

    @Schema(description = "Quantidade de pessoas que dependem financeiramente do beneficiado", example = "3")
    @Column(name = "quantidade_dependentes")
    private Integer quantidadeDependentes;

    @Schema(description = "Foto do beneficiado")
    @OneToOne
    @JoinColumn(name = "id_foto")
    private FileEntity fotoBeneficiado;

    public BeneficiadoEntity() {
    }

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

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
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

    public EnderecoEntity getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
    }

    public Integer getQuantidadeDependentes() {
        return quantidadeDependentes;
    }

    public void setQuantidadeDependentes(Integer quantidadeDependentes) {
        this.quantidadeDependentes = quantidadeDependentes;
    }

    public FileEntity getFotoBeneficiado() {
        return fotoBeneficiado;
    }

    public void setFotoBeneficiado(FileEntity fotoBeneficiado) {
        this.fotoBeneficiado = fotoBeneficiado;
    }
}
