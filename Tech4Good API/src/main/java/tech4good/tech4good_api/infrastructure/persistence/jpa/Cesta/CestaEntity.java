package tech4good.tech4good_api.infrastructure.persistence.jpa.Cesta;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import tech4good.tech4good_api.core.domain.cesta.valueobject.Peso;
import tech4good.tech4good_api.core.domain.shared.valueobject.TipoCesta;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Cesta.converter.PesoConverter;

import java.time.LocalDate;

@Schema(description = "Objeto de entidade para cestas básicas e kits")
@Entity
@Table(name = "cesta")
public class CestaEntity {

    @Schema(description = "Identificador único da cesta", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cesta")
    private Integer idCesta;

    @Schema(description = "Tipo da cesta", example = "KIT")
    @Enumerated(EnumType.STRING)
    private TipoCesta tipo;

    @Schema(description = "Peso da cesta em kilogramas", example = "3.5")
    @Convert(converter = PesoConverter.class)
    @Column(name = "peso_kg")
    private Peso peso;

    @Schema(description = "Data em que a cesta entrou no estoque da ASA", example = "2025-01-20")
    @Column(name = "data_entrada_estoque")
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
