package tech4good.tech4good_api.core.application.dto.voluntario;

import jakarta.validation.constraints.NotBlank;

public class AtualizarVoluntarioRequestDto {

    @NotBlank
    private String telefone;

    @NotBlank
    private String email;

    // Construtores
    public AtualizarVoluntarioRequestDto() {}

    public AtualizarVoluntarioRequestDto(String telefone, String email) {
        this.telefone = telefone;
        this.email = email;
    }

    // Getters e Setters
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
