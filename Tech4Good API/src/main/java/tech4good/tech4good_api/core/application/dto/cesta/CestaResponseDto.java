package tech4good.tech4good_api.core.application.dto.cesta;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(description = "Objeto de resposta para cestas básicas e kits")
public class CestaResponseDto {

    @Schema(description = "Identificador único da cesta", example = "1")
    private Integer idCesta;

    @Schema(description = "Tipo da cesta", example = "Kit")
    private String tipo;

    @Schema(description = "Peso da cesta em kilogramas", example = "3.5")
    private Double pesoKg;

    @Schema(description = "Data em que a cesta entrou no estoque da ASA", example = "2025-01-20")
    private LocalDate dataEntradaEstoque;

    @Schema(description = "Quantidade de cestas no estoque", example = "37")
    private Integer quantidadeCestas;

    public CestaResponseDto() {}

    public CestaResponseDto(Integer idCesta, String tipo, Double pesoKg, LocalDate dataEntradaEstoque, Integer quantidadeCestas) {
        this.idCesta = idCesta;
        this.tipo = tipo;
        this.pesoKg = pesoKg;
        this.dataEntradaEstoque = dataEntradaEstoque;
        this.quantidadeCestas = quantidadeCestas;
    }

    public Integer getIdCesta() {
        return idCesta;
    }

    public void setIdCesta(Integer idCesta) {
        this.idCesta = idCesta;
    }

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
