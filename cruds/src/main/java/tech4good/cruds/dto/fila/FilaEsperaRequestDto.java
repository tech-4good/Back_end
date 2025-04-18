package tech4good.cruds.dto.fila;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class FilaEsperaRequestDto {

    @NotNull
    @PastOrPresent
    private LocalDate dataEntradaFila;

    public LocalDate getDataEntradaFila() {
        return dataEntradaFila;
    }

    public void setDataEntradaFila(LocalDate dataEntradaFila) {
        this.dataEntradaFila = dataEntradaFila;
    }

}
