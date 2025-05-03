package tech4good.cruds.dto.voluntario;

import io.swagger.v3.oas.annotations.media.Schema;

public class VoluntarioLoginDto {
    @Schema(description = "E-mail do voluntário", example = "maria.silva@tech4good.org")
    private String email;

    @Schema(description = "Senha do voluntário", example = "senhaSegura@123")
    private String senha;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
