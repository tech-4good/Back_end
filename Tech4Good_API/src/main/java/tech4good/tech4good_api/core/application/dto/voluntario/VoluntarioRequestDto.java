package tech4good.tech4good_api.core.application.dto.voluntario;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class VoluntarioRequestDto {

    @Schema(description = "Nome completo do voluntário", example = "Maria Clara da Silva")
    @NotBlank
    private String nome;
    @Schema(description = "CPF do voluntário (somente números)", example = "12345678901")
    @NotBlank
    @Size(min = 11, max = 11)
    private String cpf;
    @Schema(description = "Telefone para contato com DDD", example = "11912345678")
    @NotBlank
    private String telefone;
    @Schema(description = "Senha para acesso ao sistema", example = "senhaSegura@123")
    @NotBlank
    private String senha;
    @Email
    @Schema(description = "E-mail do voluntário", example = "maria.silva@tech4good.org")
    @NotBlank
    private String email;

    private Integer administrador;

    public VoluntarioRequestDto() {}

    public VoluntarioRequestDto(String nome, String cpf, String telefone, String senha, String email, Integer administrador) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.senha = senha;
        this.email = email;
        this.administrador = administrador;
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
