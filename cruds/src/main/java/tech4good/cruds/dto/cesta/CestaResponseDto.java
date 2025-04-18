package tech4good.cruds.dto.cesta;

import java.time.LocalDate;

public class CestaResponseDto {

    private Integer idCesta;
    private String tipo;
    private LocalDate dataEntradaEstoque;
    private Integer quantidadeCestas;

    public CestaResponseDto(Integer idCesta, String tipo, LocalDate dataEntradaEstoque, Integer quantidadeCestas) {
        this.idCesta = idCesta;
        this.tipo = tipo;
        this.dataEntradaEstoque = dataEntradaEstoque;
        this.quantidadeCestas = quantidadeCestas;
    }

    public CestaResponseDto() {
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
