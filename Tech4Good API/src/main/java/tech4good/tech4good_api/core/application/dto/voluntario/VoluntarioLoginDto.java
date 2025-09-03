package tech4good.tech4good_api.core.application.dto.voluntario;

import jakarta.validation.constraints.NotBlank;

public class VoluntarioLoginDto {

    private String email;

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
