package tech4good.cruds.dto.cesta;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

@Schema(description = "Objeto de requisição para cestas básicas e kits")
public class CestaRequestDto {

    @Schema(description = "Tipo da cesta", example = "Kit")
    @NotBlank
    private String tipo;
    @Schema(description = "Peso da cesta em kilogramas", example = "3.5")
    @NotNull
    @Positive
    private Double pesoKg;
    @Schema(description = "Data em que a cesta entrou no estoque da ASA", example = "2025-01-20")
    @NotNull
    @PastOrPresent
    private LocalDate dataEntradaEstoque;
    @Schema(description = "Quantidade de cestas no estoque", example = "37")
    @NotNull
    @Positive
    private Integer quantidadeCestas;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(Double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public LocalDate getDataEntradaEstoque() {
        return dataEntradaEstoque;
    }

    public void setDataEntradaEstoque(LocalDate dataEntradaEstoque) {
        this.dataEntradaEstoque = dataEntradaEstoque;
    }

    public Integer getQuantidadeCestas() {
        return quantidadeCestas;
    }

    public void setQuantidadeCestas(Integer quantidadeCestas) {
        this.quantidadeCestas = quantidadeCestas;
    }
}
