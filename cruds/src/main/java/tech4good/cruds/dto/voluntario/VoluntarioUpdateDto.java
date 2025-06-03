package tech4good.cruds.dto.voluntario;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Objeto de atualização para cadastro de voluntários")
public class VoluntarioUpdateDto {

    @Schema(description = "Telefone para contato com DDD", example = "11910043178")
    @NotBlank
    private String telefone;
    @Schema(description = "E-mail do voluntário", example = "maria.silvaexemplo@tech4good.org")
    @NotBlank
    private String email;

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
