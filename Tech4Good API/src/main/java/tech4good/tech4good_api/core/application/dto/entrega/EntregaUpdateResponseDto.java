package tech4good.tech4good_api.core.application.dto.entrega;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;

@Schema(description = "Resposta resumida para operações de atualização de entrega")
public class EntregaUpdateResponseDto {

    @Schema(description = "Identificador único da entrega", example = "1")
    private Integer idEntrega;

    @Schema(description = "Data de retirada da doação", example = "2025-02-10")
    private LocalDate dataRetirada;

    @Schema(description = "Data que poderá fazer a próxima retirada de doação", example = "2025-02-25")
    private LocalDate proximaRetirada;

    public EntregaUpdateResponseDto() {
    }

    public EntregaUpdateResponseDto(Integer idEntrega, LocalDate dataRetirada, LocalDate proximaRetirada) {
        this.idEntrega = idEntrega;
        this.dataRetirada = dataRetirada;
        this.proximaRetirada = proximaRetirada;
    }

    // Getters e Setters
    public Integer getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(Integer idEntrega) {
        this.idEntrega = idEntrega;
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
