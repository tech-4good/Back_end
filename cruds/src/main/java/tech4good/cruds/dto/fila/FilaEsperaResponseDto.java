package tech4good.cruds.dto.fila;

import io.swagger.v3.oas.annotations.media.Schema;
import tech4good.cruds.dto.auxiliares.BeneficiadoSummarizedResponseDto;
import tech4good.cruds.dto.auxiliares.EnderecoSummarizedResponseDto;

import java.time.LocalDate;

@Schema(description = "Objeto de resposta para fila de espera de cestas básicas")
public class FilaEsperaResponseDto {

    @Schema(description = "Identificador único de posição na fila", example = "1")
    private Integer idFila;
    @Schema(description = "Data de entrada na fila", example = "2025/02/10")
    private LocalDate dataEntradaFila;
    @Schema(description = "Data de saída da fila", example = "2025/04/22")
    private LocalDate dataSaidaFila;
    private BeneficiadoSummarizedResponseDto beneficiado;

    public FilaEsperaResponseDto(Integer idFila, LocalDate dataEntradaFila, LocalDate dataSaidaFila, BeneficiadoSummarizedResponseDto beneficiado) {
        this.idFila = idFila;
        this.dataEntradaFila = dataEntradaFila;
        this.dataSaidaFila = dataSaidaFila;
        this.beneficiado = beneficiado;
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

    public BeneficiadoSummarizedResponseDto getBeneficiado() {
        return beneficiado;
    }

    public void setBeneficiado(BeneficiadoSummarizedResponseDto beneficiado) {
        this.beneficiado = beneficiado;
    }
}
