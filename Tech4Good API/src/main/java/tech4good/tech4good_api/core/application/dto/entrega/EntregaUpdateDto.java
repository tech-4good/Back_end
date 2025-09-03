package tech4good.tech4good_api.core.application.dto.entrega;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

@Schema(description = "Objeto de requisição de alteração para entregas de kits e cestas básicas")
public class EntregaUpdateDto {

    @Schema(description = "Data de retirada da doação", example = "2025-02-10")
    @NotNull
    @PastOrPresent
    private LocalDate dataRetirada;

    @Schema(description = "Data que poderá fazer a próxima retirada de doação", example = "2025-02-25")
    @NotNull
    private LocalDate proximaRetirada;

    public EntregaUpdateDto() {
    }

    public EntregaUpdateDto(LocalDate dataRetirada, LocalDate proximaRetirada) {
        this.dataRetirada = dataRetirada;
        this.proximaRetirada = proximaRetirada;
    }

    public LocalDate getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(LocalDate dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public LocalDate getProximaRetirada() {
        return proximaRetirada;
    }

    public void setProximaRetirada(LocalDate proximaRetirada) {
        this.proximaRetirada = proximaRetirada;
    }
}
