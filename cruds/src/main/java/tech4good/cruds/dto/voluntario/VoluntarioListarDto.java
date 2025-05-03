package tech4good.cruds.dto.voluntario;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class VoluntarioListarDto {

    @Schema(description = "ID do voluntário", example = "1")
    private Integer idVoluntario;

    @Schema(description = "Nome completo do voluntário", example = "Maria Clara da Silva")
    private String nome;

    @Schema(description = "CPF do voluntário (somente números)", example = "12345678901")
    private String cpf;

    @Schema(description = "Telefone para contato com DDD", example = "11912345678")
    private String telefone;

    @Schema(description = "E-mail do voluntário", example = "maria.silva@tech4good.org")
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
