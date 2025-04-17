package tech4good.cruds.dto;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Type;
import tech4good.cruds.entity.Endereco;
import java.time.LocalDate;

public class BeneficiadoRequestDto {

    @NotBlank
    @Size(min = 11, max = 11)
    private String cpf;
    @NotBlank
    private String nome;
    @NotBlank
    private String rg;
    @NotBlank
    private LocalDate dataNascimento;
    @NotBlank
    private String naturalidade;
    @NotBlank
    private String telefone;
    @NotBlank
    private String estadoCivil;
    @NotBlank
    private String escolaridade;
    @NotBlank
    private String profissao;
    @NotBlank
    private Double rendaMensal;
    private String empresa;
    private String cargo;
    @NotBlank
    private String religiao;
    @NotBlank
    private Endereco endereco;
    @NotBlank
    private Integer quantidadeDependentes;
    @Lob
    private byte[] fotoBeneficiado;

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

    public byte[] getFotoBeneficiado() {
        return fotoBeneficiado;
    }

    public void setFotoBeneficiado(byte[] fotoBeneficiado) {
        this.fotoBeneficiado = fotoBeneficiado;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
