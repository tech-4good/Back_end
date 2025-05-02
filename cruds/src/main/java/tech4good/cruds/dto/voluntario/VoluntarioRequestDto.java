package tech4good.cruds.dto.voluntario;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Objeto de requisição para cadastro de voluntários")
public class VoluntarioRequestDto {

    @Schema(description = "Nome completo do voluntário", example = "Maria Clara da Silva")
    @NotBlank
    private String nome;
    @Schema(description = "CPF do voluntário (somente números)", example = "12345678901")
    @NotBlank
    @Size(min = 11, max = 11)
    private String cpf;
    @Schema(description = "Telefone para contato com DDD", example = "(11)91234-5678")
    @NotBlank
    private String telefone;
    @Schema(description = "Senha para acesso ao sistema", example = "senhaSegura@123")
    @NotBlank
    private String senha;
    @Schema(description = "E-mail do voluntário", example = "maria.silva@tech4good.org")
    @NotBlank
    private String email;

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
}
