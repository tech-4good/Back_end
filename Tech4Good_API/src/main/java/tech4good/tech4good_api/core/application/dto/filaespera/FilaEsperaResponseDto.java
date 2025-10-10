package tech4good.tech4good_api.core.application.dto.filaespera;

import java.time.LocalDate;

import tech4good.tech4good_api.core.application.dto.auxiliares.BeneficiadoSummarizedResponseDto;

public class FilaEsperaResponseDto {
    private Integer idFila;
    private LocalDate dataEntradaFila;
    private LocalDate dataSaidaFila;
    private BeneficiadoSummarizedResponseDto beneficiado;

    public FilaEsperaResponseDto(Integer idFila, LocalDate dataEntradaFila, LocalDate dataSaidaFila, BeneficiadoSummarizedResponseDto beneficiado) {
        this.idFila = idFila;
        this.dataEntradaFila = dataEntradaFila;
        this.dataSaidaFila = dataSaidaFila;
        this.beneficiado = beneficiado;
    }

    public FilaEsperaResponseDto() {}

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

    public BeneficiadoSummarizedResponseDto getBeneficiado() {
        return beneficiado;
    }

    public void setBeneficiado(BeneficiadoSummarizedResponseDto beneficiado) {
        this.beneficiado = beneficiado;
    }
}

