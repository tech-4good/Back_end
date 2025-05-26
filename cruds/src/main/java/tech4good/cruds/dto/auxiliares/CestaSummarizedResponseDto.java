package tech4good.cruds.dto.auxiliares;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto de resposta para auxiliar entre cestas e entregas")
public class CestaSummarizedResponseDto {

    @Schema(description = "Nome do tipo de cesta", example = "Cesta básica")
    private String tipo;

    public CestaSummarizedResponseDto(String tipo) {
        this.tipo = tipo;
    }
    public CestaSummarizedResponseDto() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
