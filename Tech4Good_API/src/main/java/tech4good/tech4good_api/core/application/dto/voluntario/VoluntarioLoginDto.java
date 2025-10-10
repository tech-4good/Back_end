package tech4good.tech4good_api.core.application.dto.voluntario;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public class VoluntarioLoginDto {
    @Schema(description = "E-mail do voluntário", example = "maria.silva@tech4good.org")
    private String email;
    @Schema(description = "Senha para acesso ao sistema", example = "senhaSegura@123")
    private String senha;

    public VoluntarioLoginDto() {}

    public VoluntarioLoginDto(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
