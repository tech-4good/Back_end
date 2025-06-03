package tech4good.cruds.dto.endereco;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Objeto de atualização para endereços")
public class EnderecoUpdateDto {

    @Schema(description = "Controle para saber se ainda está participando da ASA", example = "Fechado")
    @NotBlank
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
