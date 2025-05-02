package tech4good.cruds.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDate;

@Schema(description = "Objeto de entidade para fila de espera de cestas básicas")
@Entity
@Table(name = "fila_espera")
public class FilaEspera {

    @Schema(description = "Identificador único de posição na fila", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fila")
    private Integer idFila;
    @Schema(description = "Data de entrada na fila", example = "2025/02/10")
    @Column(name = "data_entrada")
    private LocalDate dataEntradaFila;
    @Schema(description = "Data de saída da fila", example = "2025/04/22")
    @Column(name = "data_saida")
    private LocalDate dataSaidaFila;
    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Integer getIdFila() {
        return idFila;
    }

    public void setIdFila(Integer idFila) {
        this.idFila = idFila;
    }

    public LocalDate getDataEntradaFila() {
        return dataEntradaFila;
    }

    public void setDataEntradaFila(LocalDate dataEntradaFila) {
        this.dataEntradaFila = dataEntradaFila;
    }

    public LocalDate getDataSaidaFila() {
        return dataSaidaFila;
    }

    public void setDataSaidaFila(LocalDate dataSaidaFila) {
        this.dataSaidaFila = dataSaidaFila;
    }
}
