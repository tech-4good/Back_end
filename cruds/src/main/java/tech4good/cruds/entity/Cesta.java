package tech4good.cruds.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Cesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cesta")
    private Integer idCesta;
    private String tipo;
    @Column(name = "peso_kg")
    private Double pesoKg;
    @Column(name = "data_entrada")
    private LocalDate dataEntradaEstoque;
    @Column(name = "quantidade_cestas")
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

