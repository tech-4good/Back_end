package tech4good.tech4good_api.core.application.dto.beneficiado;

import tech4good.tech4good_api.core.domain.endereco.Endereco;
import tech4good.tech4good_api.core.domain.shared.valueobject.Cpf;

import java.time.LocalDate;

public class BeneficiadoSimplesRequestDto {
    private Cpf cpf;
    private String nome;
    private LocalDate dataNascimento;
    private Endereco endereco;

    public BeneficiadoSimplesRequestDto() {}

    public BeneficiadoSimplesRequestDto(Cpf cpf, String nome, LocalDate dataNascimento, Endereco endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
