package tech4good.cruds.dto;

import java.time.LocalDate;

public class CestaResponseDto {

    private Integer idCesta;
    private String tipo;
    private Double pesoKg;
    private LocalDate dataEntradaEstoque;
    private Integer quantidadeCestas;

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
