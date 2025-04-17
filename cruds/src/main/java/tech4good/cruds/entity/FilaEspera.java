package tech4good.cruds.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "fila_espera")
public class FilaEspera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fila")
    private Integer idFila;
    @Column(name = "data_entrada")
    private LocalDate dataEntradaFila;
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
