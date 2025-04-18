package tech4good.cruds.dto.fila;

import tech4good.cruds.dto.auxiliares.EnderecoBeneficiadoResponseDto;

import java.time.LocalDate;

public class FilaEsperaResponseDto {

    private Integer idFila;
    private LocalDate dataEntradaFila;
    private LocalDate dataSaidaFila;
    private EnderecoBeneficiadoResponseDto endereco;

    public FilaEsperaResponseDto(Integer idFila, LocalDate dataEntradaFila, LocalDate dataSaidaFila, EnderecoBeneficiadoResponseDto endereco) {
        this.idFila = idFila;
        this.dataEntradaFila = dataEntradaFila;
        this.dataSaidaFila = dataSaidaFila;
        this.endereco = endereco;
    }

    public FilaEsperaResponseDto() {
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

    public EnderecoBeneficiadoResponseDto getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoBeneficiadoResponseDto endereco) {
        this.endereco = endereco;
    }
}
