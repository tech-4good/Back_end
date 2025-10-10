package tech4good.tech4good_api.infrastructure.persistence.jpa.Voluntario;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import tech4good.tech4good_api.core.domain.shared.valueobject.Cpf;
import tech4good.tech4good_api.core.domain.shared.valueobject.Telefone;
import tech4good.tech4good_api.core.domain.voluntario.valueobject.Email;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Voluntario.converter.CpfConverter;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Voluntario.converter.TelefoneConverter;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Voluntario.converter.EmailConverter;

@Schema(description = "Objeto de entidade de voluntário")
@Entity
@Table(name = "voluntario")
public class VoluntarioEntity {

    @Schema(description = "Identificador único do voluntário", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_voluntario")
    private Integer idVoluntario;

    @Schema(description = "Nome completo do voluntário", example = "Maria Clara da Silva")
    @Column(nullable = false)
    private String nome;

    @Schema(description = "CPF do voluntário (somente números)", example = "12345678901")
    @Column(nullable = false, unique = true)
    @Convert(converter = CpfConverter.class)
    private Cpf cpf;

    @Schema(description = "Telefone para contato com DDD", example = "(11)91234-5678")
    @Column(nullable = false)
    @Convert(converter = TelefoneConverter.class)
    private Telefone telefone;

    @Schema(description = "Senha para acesso ao sistema", example = "senhaSegura@123")
    @Column(nullable = false)
    private String senha;

    @Schema(description = "E-mail do voluntário", example = "maria.silva@tech4good.org")
    @Column(nullable = false, unique = true)
    @Convert(converter = EmailConverter.class)
    private Email email;

    @Schema(description = "É administrador?", example = "1")
    @Column(nullable = false)
    private Integer administrador;

    // Construtores
    public VoluntarioEntity() {}

    public VoluntarioEntity(String nome, Cpf cpf, Telefone telefone, String senha, Email email, Integer administrador) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.senha = senha;
        this.email = email;
        this.administrador = administrador;
    }

    // Getters e Setters
    public Integer getIdVoluntario() {
        return idVoluntario;
    }

    public void setIdVoluntario(Integer idVoluntario) {
        this.idVoluntario = idVoluntario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public void setCpf(Cpf cpf) {
        this.cpf = cpf;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Integer getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Integer administrador) {
        this.administrador = administrador;
    }
}
