package tech4good.tech4good_api.core.application.dto.filaespera;

import jakarta.validation.constraints.PastOrPresent;
import java.time.LocalDate;

public class FilaEsperaUpdateDto {
    @PastOrPresent
    private LocalDate dataSaidaFila;

    public FilaEsperaUpdateDto() {}

    public FilaEsperaUpdateDto(LocalDate dataSaidaFila) {
        this.dataSaidaFila = dataSaidaFila;
    }

    public LocalDate getDataSaidaFila() {
        return dataSaidaFila;
    }

    public void setDataSaidaFila(LocalDate dataSaidaFila) {
        this.dataSaidaFila = dataSaidaFila;
    }
}
