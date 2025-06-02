package tech4good.cruds.dto.entrega;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import tech4good.cruds.dto.beneficiado.BeneficiadoRequestDto;
import tech4good.cruds.dto.cesta.CestaRequestDto;
import tech4good.cruds.dto.endereco.EnderecoRequestDto;
import tech4good.cruds.dto.voluntario.VoluntarioRequestDto;

import java.time.LocalDate;

@Schema(description = "Objeto de requisição para entregas de kits e cestas básicas")
public class EntregaRequestDto {

    @Schema(description = "Data de retirada da doação", example = "2025/02/10")
    @NotNull
    @PastOrPresent
    private LocalDate dataRetirada;
    @Schema(description = "Data que poderá fazer a próxima retirada de doação", example = "2025/02/25")
    @NotNull
    private LocalDate proximaRetirada;
    @NotNull
    private Integer enderecoId;
    @NotNull
    private Integer cestaId;
    @NotNull
    private Integer voluntarioId;
    @NotNull
    private Integer beneficiadoId;

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
