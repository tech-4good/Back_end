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

    public Cesta(Integer id, TipoCesta tipo, Peso peso, LocalDate dataEntradaEstoque, Integer quantidadeCestas) {
        if (tipo == null) {
            throw new IllegalArgumentException("Tipo da cesta é obrigatório.");
        }
        if (peso == null) {
            throw new IllegalArgumentException("Peso da cesta é obrigatório.");
        }
        if (dataEntradaEstoque != null && dataEntradaEstoque.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de entrada no estoque não pode ser futura.");
        }
        if (quantidadeCestas == null || quantidadeCestas <= 0) {
            throw new IllegalArgumentException("Quantidade de cestas deve ser maior que zero.");
        }

        this.id = id;
        this.tipo = tipo;
        this.peso = peso;
        this.dataEntradaEstoque = dataEntradaEstoque;
        this.quantidadeCestas = quantidadeCestas;
    }

    public Cesta() {
    }

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
