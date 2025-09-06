package tech4good.tech4good_api.infrastructure.persistence.jpa.FilaEspera;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "fila_espera")
public class FilaEsperaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fila")
    private Integer idFila;

    @Column(name = "data_entrada_fila")
    private LocalDate dataEntradaFila;

    @Column(name = "data_saida_fila")
    private LocalDate dataSaidaFila;

    @Column(name = "beneficiado_id")
    private Integer beneficiadoId;

    // Construtores
    public FilaEsperaEntity() {}

    public FilaEsperaEntity(Integer idFila, LocalDate dataEntradaFila, LocalDate dataSaidaFila, Integer beneficiadoId) {
        this.idFila = idFila;
        this.dataEntradaFila = dataEntradaFila;
        this.dataSaidaFila = dataSaidaFila;
        this.beneficiadoId = beneficiadoId;
    }

    // Getters e Setters
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

    public Integer getBeneficiadoId() {
        return beneficiadoId;
    }

    public void setBeneficiadoId(Integer beneficiadoId) {
        this.beneficiadoId = beneficiadoId;
    }
}
