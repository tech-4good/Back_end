package tech4good.cruds.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Schema(description = "Objeto de entidade de voluntário")
@Entity
public class Voluntario {

    @Schema(description = "Identificador único do voluntário", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_voluntario")
    private Integer idVoluntario;
    @Schema(description = "Nome completo do voluntário", example = "Maria Clara da Silva")
    private String nome;
    @Schema(description = "CPF do voluntário (somente números)", example = "12345678901")
    private String cpf;
    @Schema(description = "Telefone para contato com DDD", example = "(11)91234-5678")
    private String telefone;
    @Schema(description = "Senha para acesso ao sistema", example = "senhaSegura@123")
    private String senha;
    @Schema(description = "E-mail do voluntário", example = "maria.silva@tech4good.org")
    private String email;
    @Schema(description = "É administrador?", example = "1")
    private Integer administrador;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Integer administrador) {
        this.administrador = administrador;
    }
}
