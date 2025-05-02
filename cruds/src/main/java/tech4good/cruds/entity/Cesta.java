package tech4good.cruds.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDate;

@Schema(description = "Objeto de entidade para cestas básicas e kits")
@Entity
public class Cesta {

    @Schema(description = "Identificador único da cesta", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cesta")
    private Integer idCesta;
    @Schema(description = "Tipo da cesta", example = "Kit")
    private String tipo;
    @Schema(description = "Peso da cesta em kilogramas", example = "3,5")
    @Column(name = "peso_kg")
    private Double pesoKg;
    @Schema(description = "Data em que a cesta entrou no estoque da ASA", example = "2025/01/20")
    @Column(name = "data_entrada")
    private LocalDate dataEntradaEstoque;
    @Schema(description = "Quantidade de cestas no estoque", example = "37")
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

