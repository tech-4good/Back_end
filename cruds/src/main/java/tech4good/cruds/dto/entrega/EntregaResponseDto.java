package tech4good.cruds.dto.entrega;

import io.swagger.v3.oas.annotations.media.Schema;
import tech4good.cruds.dto.auxiliares.CestaEntregaResponseDto;
import tech4good.cruds.dto.auxiliares.EnderecoBeneficiadoResponseDto;
import tech4good.cruds.dto.auxiliares.VoluntarioEntregaResponseDto;

import java.time.LocalDate;

@Schema(description = "Objeto de resposta para entregas de kits e cestas básicas")
public class EntregaResponseDto {

    @Schema(description = "Identificador único da entrega", example = "1")
    private Integer idEntrega;
    @Schema(description = "Data de retirada da doação", example = "2025/02/10")
    private LocalDate dataRetirada;
    @Schema(description = "Data que poderá fazer a próxima retirada de doação", example = "2025/02/25")
    private LocalDate proximaRetirada;
    private EnderecoBeneficiadoResponseDto endereco;
    private CestaEntregaResponseDto cesta;
    private VoluntarioEntregaResponseDto voluntario;

    public EntregaResponseDto(Integer idEntrega, LocalDate dataRetirada, LocalDate proximaRetirada, EnderecoBeneficiadoResponseDto endereco, CestaEntregaResponseDto cesta, VoluntarioEntregaResponseDto voluntario) {
        this.idEntrega = idEntrega;
        this.dataRetirada = dataRetirada;
        this.proximaRetirada = proximaRetirada;
        this.endereco = endereco;
        this.cesta = cesta;
        this.voluntario = voluntario;
    }

    public EntregaResponseDto() {
    }

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

    public EnderecoBeneficiadoResponseDto getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoBeneficiadoResponseDto endereco) {
        this.endereco = endereco;
    }

    public CestaEntregaResponseDto getCesta() {
        return cesta;
    }

    public void setCesta(CestaEntregaResponseDto cesta) {
        this.cesta = cesta;
    }

    public VoluntarioEntregaResponseDto getVoluntario() {
        return voluntario;
    }

    public void setVoluntario(VoluntarioEntregaResponseDto voluntario) {
        this.voluntario = voluntario;
    }
}
