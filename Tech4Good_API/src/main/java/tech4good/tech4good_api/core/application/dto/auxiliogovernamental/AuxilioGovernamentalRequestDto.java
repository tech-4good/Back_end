package tech4good.tech4good_api.core.application.dto.auxiliogovernamental;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Objeto de requisição para auxílios governamentais")
public class AuxilioGovernamentalRequestDto {

    @Schema(description = "Nome do tipo de auxílio", example = "Bolsa Família")
    @NotBlank
    private String tipo;

    public AuxilioGovernamentalRequestDto() {
    }

    public AuxilioGovernamentalRequestDto(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
