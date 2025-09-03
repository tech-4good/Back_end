package tech4good.tech4good_api.core.application.dto.entrega;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

@Schema(description = "Objeto de requisição para entregas de kits e cestas básicas")
public class EntregaRequestDto {

    @Schema(description = "Data de retirada da doação", example = "2025-02-10")
    @NotNull
    @PastOrPresent
    private LocalDate dataRetirada;

    @Schema(description = "Data que poderá fazer a próxima retirada de doação", example = "2025-02-25")
    @NotNull
    private LocalDate proximaRetirada;

    @Schema(description = "Chave estrangeira do endereço associado", example = "1")
    @NotNull
    private Integer enderecoId;

    @Schema(description = "Chave estrangeira da cesta associado", example = "1")
    @NotNull
    private Integer cestaId;

    @Schema(description = "Chave estrangeira do voluntario associado", example = "1")
    @NotNull
    private Integer voluntarioId;

    @Schema(description = "Chave estrangeira do beneficiado associado", example = "1")
    @NotNull
    private Integer beneficiadoId;

    public EntregaRequestDto() {
    }

    public EntregaRequestDto(LocalDate dataRetirada, LocalDate proximaRetirada, Integer enderecoId, Integer cestaId, Integer voluntarioId, Integer beneficiadoId) {
        this.dataRetirada = dataRetirada;
        this.proximaRetirada = proximaRetirada;
        this.enderecoId = enderecoId;
        this.cestaId = cestaId;
        this.voluntarioId = voluntarioId;
        this.beneficiadoId = beneficiadoId;
    }

    // Getters e Setters
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

    public Integer getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Integer enderecoId) {
        this.enderecoId = enderecoId;
    }

    public Integer getCestaId() {
        return cestaId;
    }

    public void setCestaId(Integer cestaId) {
        this.cestaId = cestaId;
    }

    public Integer getVoluntarioId() {
        return voluntarioId;
    }

    public void setVoluntarioId(Integer voluntarioId) {
        this.voluntarioId = voluntarioId;
    }

    public Integer getBeneficiadoId() {
        return beneficiadoId;
    }

    public void setBeneficiadoId(Integer beneficiadoId) {
        this.beneficiadoId = beneficiadoId;
    }
}
