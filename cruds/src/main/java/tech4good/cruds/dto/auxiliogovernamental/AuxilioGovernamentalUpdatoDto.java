package tech4good.cruds.dto.auxiliogovernamental;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Objeto de atualização para auxílios governamentais")
public class AuxilioGovernamentalUpdatoDto {

    @Schema(description = "Nome do tipo de auxílio", example = "Auxilio Gas")
    @NotBlank
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
