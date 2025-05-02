package tech4good.cruds.dto.voluntario;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto de resposta para cadastro de voluntários")
public class VoluntarioResponseDto {

    @Schema(description = "Identificador único do voluntário", example = "1")
    private Integer idVoluntario;
    @Schema(description = "Nome completo do voluntário", example = "Maria Clara da Silva")
    private String nome;
    @Schema(description = "CPF do voluntário (somente números)", example = "12345678901")
    private String cpf;
    @Schema(description = "Telefone para contato com DDD", example = "(11)91234-5678")
    private String telefone;
    @Schema(description = "E-mail do voluntário", example = "maria.silva@tech4good.org")
    private String email;

    public VoluntarioResponseDto(Integer idVoluntario, String nome, String cpf, String telefone, String email) {
        this.idVoluntario = idVoluntario;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
    }

    public VoluntarioResponseDto() {
    }

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
