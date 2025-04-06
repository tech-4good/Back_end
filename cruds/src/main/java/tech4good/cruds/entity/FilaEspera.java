package tech4good.cruds.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class FilaEspera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFila;
    private LocalDate dataEntradaFila;
    private LocalDate dataSaidaFila;

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
