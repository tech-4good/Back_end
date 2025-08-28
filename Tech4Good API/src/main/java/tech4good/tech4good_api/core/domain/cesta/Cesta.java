package tech4good.tech4good_api.core.domain.cesta;

import tech4good.tech4good_api.core.domain.cesta.valueobject.Peso;
import tech4good.tech4good_api.core.domain.shared.valueobject.TipoCesta;

import java.time.LocalDate;

public class Cesta {
    private Integer id;
    private TipoCesta tipo;
    private Peso peso;
    private LocalDate dataEntradaEstoque;
    private Integer quantidadeCestas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoCesta getTipo() {
        return tipo;
    }

    public void setTipo(TipoCesta tipo) {
        this.tipo = tipo;
    }

    public Peso getPeso() {
        return peso;
    }

    public void setPeso(Peso peso) {
        this.peso = peso;
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
