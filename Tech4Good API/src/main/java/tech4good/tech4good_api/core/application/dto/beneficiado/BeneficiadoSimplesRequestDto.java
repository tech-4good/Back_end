package tech4good.tech4good_api.core.application.dto.beneficiado;

import tech4good.tech4good_api.core.domain.endereco.Endereco;
import tech4good.tech4good_api.core.domain.shared.valueobject.Cpf;

import java.time.LocalDate;

public class BeneficiadoSimplesRequestDto {
    private Cpf cpf;
    private String nome;
    private LocalDate dataNascimento;
    private Endereco endereco;

    public BeneficiadoSimplesRequestDto(Cpf cpf, String nome, LocalDate dataNascimento, Endereco endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
