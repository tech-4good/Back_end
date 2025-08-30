package tech4good.tech4good_api.core.application.dto.beneficiado;

import tech4good.tech4good_api.core.domain.beneficiado.valueobject.EstadoCivil;
import tech4good.tech4good_api.core.domain.beneficiado.valueobject.Religiao;
import tech4good.tech4good_api.core.domain.beneficiado.valueobject.Renda;
import tech4good.tech4good_api.core.domain.beneficiado.valueobject.Rg;
import tech4good.tech4good_api.core.domain.endereco.Endereco;
import tech4good.tech4good_api.core.domain.shared.valueobject.Cpf;
import tech4good.tech4good_api.core.domain.shared.valueobject.Telefone;

import java.time.LocalDate;

public class BeneficiadoRequestDto {
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

    public BeneficiadoRequestDto(Cpf cpf, String nome, Rg rg, LocalDate dataNascimento, String naturalidade, Telefone telefone, EstadoCivil estadoCivil, String escolaridade, String profissao, Renda rendaMensal, String empresa, String cargo, Religiao religiao, Endereco endereco, Integer quantidadeDependentes) {
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
    }

    public Cpf getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public Rg getRg() {
        return rg;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public String getProfissao() {
        return profissao;
    }

    public Renda getRendaMensal() {
        return rendaMensal;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public Religiao getReligiao() {
        return religiao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Integer getQuantidadeDependentes() {
        return quantidadeDependentes;
    }
}
