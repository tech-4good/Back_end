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
    private final Integer id;
    private final Cpf cpf;
    private final String nome;
    private final Rg rg;
    private final LocalDate dataNascimento;
    private final String naturalidade;
    private final Telefone telefone;
    private final EstadoCivil estadoCivil;
    private final String escolaridade;
    private final String profissao;
    private final Renda rendaMensal;
    private final String empresa;
    private final String cargo;
    private final Religiao religiao;
    private final Endereco endereco;
    private final Integer quantidadeDependentes;
    private final FileEntity fotoBeneficiado;


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

    public Integer getId() {
        return id;
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

    public FileEntity getFotoBeneficiado() {
        return fotoBeneficiado;
    }
}
