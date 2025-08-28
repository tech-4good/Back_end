package tech4good.tech4good_api.core.domain.filaespera;

import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;

import java.time.LocalDate;

public class FilaEspera {
    private Integer id;
    private LocalDate dataEntradaFila;
    private LocalDate dataSaidaFila;
    private Beneficiado beneficiado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Beneficiado getBeneficiado() {
        return beneficiado;
    }

    public void setBeneficiado(Beneficiado beneficiado) {
        this.beneficiado = beneficiado;
    }
}
