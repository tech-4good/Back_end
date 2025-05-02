package tech4good.cruds.dto.auxiliares;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto de resposta para auxiliar entre cestas e entregas")
public class CestaEntregaResponseDto {

    @Schema(description = "Nome do tipo de cesta", example = "Cesta básica")
    private String tipo;

    public CestaEntregaResponseDto(String tipo) {
        this.tipo = tipo;
    }
    public CestaEntregaResponseDto() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
