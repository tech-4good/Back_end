package tech4good.tech4good_api.core.application.dto.auxiliogovernamental;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Objeto de atualização para auxílios governamentais")
public class AuxilioGovernamentalAtualizarRequestDto {

    @Schema(description = "Nome do tipo de auxílio", example = "Auxílio Gás")
    @NotBlank
    private String tipo;

    public AuxilioGovernamentalAtualizarRequestDto() {
    }

    public AuxilioGovernamentalAtualizarRequestDto(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
