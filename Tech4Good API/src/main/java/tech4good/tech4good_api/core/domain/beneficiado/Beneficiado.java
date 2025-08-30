package tech4good.tech4good_api.core.domain.beneficiado;

import org.apache.http.entity.FileEntity;
import tech4good.tech4good_api.core.domain.beneficiado.valueobject.EstadoCivil;
import tech4good.tech4good_api.core.domain.beneficiado.valueobject.Religiao;
import tech4good.tech4good_api.core.domain.beneficiado.valueobject.Renda;
import tech4good.tech4good_api.core.domain.beneficiado.valueobject.Rg;
import tech4good.tech4good_api.core.domain.endereco.Endereco;
import tech4good.tech4good_api.core.domain.shared.valueobject.Cpf;
import tech4good.tech4good_api.core.domain.shared.valueobject.Telefone;

import java.time.LocalDate;

public class Beneficiado {
    private Integer id;
    private Cpf cpf;
    private String nome;
    private Rg rg;
    private LocalDate dataNascimento;
    private String naturalidade;
    private Telefone telefone;
    private EstadoCivil estadoCivil;
    private String escolaridade;
    private String profissao;
    private Renda rendaMensal;
    private String empresa;
    private String cargo;
    private Religiao religiao;
    private Endereco endereco;
    private Integer quantidadeDependentes;
    private FileEntity fotoBeneficiado;


    public Beneficiado(Integer id, Cpf cpf, String nome, Rg rg, LocalDate dataNascimento, String naturalidade, Telefone telefone, EstadoCivil estadoCivil, String escolaridade, String profissao, Renda rendaMensal, String empresa, String cargo, Religiao religiao, Endereco endereco, Integer quantidadeDependentes, FileEntity fotoBeneficiado) {

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        if (dataNascimento == null) {
            throw new IllegalArgumentException("Data de nascimento não pode ser nula.");
        }
        if (dataNascimento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de nascimento não pode ser futura.");
        }
        if (quantidadeDependentes != null && quantidadeDependentes < 0) {
            throw new IllegalArgumentException("Quantidade de dependentes não pode ser negativa.");
        }

        this.id = id;
        this.cpf = cpf;
        this.nome = nome.trim();
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.naturalidade = naturalidade != null ? naturalidade.trim() : null;
        this.telefone = telefone;
        this.estadoCivil = estadoCivil;
        this.escolaridade = escolaridade != null ? escolaridade.trim() : null;
        this.profissao = profissao != null ? profissao.trim() : null;
        this.rendaMensal = rendaMensal;
        this.empresa = empresa != null ? empresa.trim() : null;
        this.cargo = cargo != null ? cargo.trim() : null;
        this.religiao = religiao;
        this.endereco = endereco;
        this.quantidadeDependentes = quantidadeDependentes;
        this.fotoBeneficiado = fotoBeneficiado;
    }

    public Beneficiado() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public void setCpf(Cpf cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Rg getRg() {
        return rg;
    }

    public void setRg(Rg rg) {
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

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
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

    public Renda getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(Renda rendaMensal) {
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

    public Religiao getReligiao() {
        return religiao;
    }

    public void setReligiao(Religiao religiao) {
        this.religiao = religiao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
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
