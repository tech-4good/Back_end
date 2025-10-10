package tech4good.tech4good_api.core.application.dto.cesta;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Schema(description = "Objeto de atualização para cestas básicas e kits")
public class CestaUpdateDto {

    @Schema(description = "Quantidade de cestas no estoque", example = "31")
    @NotNull
    @Positive
    private Integer quantidadeCestas;

    public Integer getQuantidadeCestas() {
        return quantidadeCestas;
    }

    public void setQuantidadeCestas(Integer quantidadeCestas) {
        this.quantidadeCestas = quantidadeCestas;
    }
}
