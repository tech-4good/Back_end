package tech4good.cruds.dto.voluntario;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class VoluntarioRedefinirSenhaDto {

    @Schema(description = "E-mail do voluntário", example = "maria.silva@tech4good.org")
    @NotBlank(message = "O e-mail é obrigatório.")
    @Email(message = "Formato de e-mail inválido.")
    private String email;

    @Schema(description = "Senha para acesso ao sistema", example = "senhaSegura@123")
    @NotBlank(message = "A senha atual é obrigatória.")
    @Size(min = 8, message = "A senha atual deve ter no mínimo 8 caracteres.")
    private String senhaAtual;

    @Schema(description = "Senha para acesso ao sistema", example = "casckito@123")
    @NotBlank(message = "A nova senha é obrigatória.")
    @Size(min = 8, message = "A nova senha deve ter no mínimo 8 caracteres.")
    private String novaSenha;

    public VoluntarioRedefinirSenhaDto() {
    }

    public VoluntarioRedefinirSenhaDto(String email, String senhaAtual, String novaSenha) {
        this.email = email;
        this.senhaAtual = senhaAtual;
        this.novaSenha = novaSenha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenhaAtual() {
        return senhaAtual;
    }

    public void setSenhaAtual(String senhaAtual) {
        this.senhaAtual = senhaAtual;
    }

    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }
}
