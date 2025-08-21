package tech4good.cruds.dto.fila;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

@Schema(description = "Objeto de requisição para fila de espera de cestas básicas")
public class FilaEsperaRequestDto {

    @Schema(description = "Data de entrada na fila", example = "2025-02-10")
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
