package tech4good.cruds.dto.entrega;

import io.swagger.v3.oas.annotations.media.Schema;
import tech4good.cruds.dto.auxiliares.BeneficiadoSummarizedResponseDto;
import tech4good.cruds.dto.auxiliares.CestaSummarizedResponseDto;
import tech4good.cruds.dto.auxiliares.EnderecoSummarizedResponseDto;
import tech4good.cruds.dto.auxiliares.VoluntarioSummarizedResponseDto;

import java.time.LocalDate;

@Schema(description = "Objeto de resposta para entregas de kits e cestas básicas")
public class EntregaResponseDto {

    @Schema(description = "Identificador único da entrega", example = "1")
    private Integer idEntrega;
    @Schema(description = "Data de retirada da doação", example = "2025/02/10")
    private LocalDate dataRetirada;
    @Schema(description = "Data que poderá fazer a próxima retirada de doação", example = "2025/02/25")
    private LocalDate proximaRetirada;
    private EnderecoSummarizedResponseDto endereco;
    private CestaSummarizedResponseDto cesta;
    private VoluntarioSummarizedResponseDto voluntario;
    private BeneficiadoSummarizedResponseDto beneficiado;

    public EntregaResponseDto(Integer idEntrega, LocalDate dataRetirada,
                              LocalDate proximaRetirada,
                              EnderecoSummarizedResponseDto endereco,
                              CestaSummarizedResponseDto cesta,
                              VoluntarioSummarizedResponseDto voluntario,
                              BeneficiadoSummarizedResponseDto beneficiado) {
        this.idEntrega = idEntrega;
        this.dataRetirada = dataRetirada;
        this.proximaRetirada = proximaRetirada;
        this.endereco = endereco;
        this.cesta = cesta;
        this.voluntario = voluntario;
        this.beneficiado = beneficiado;
    }

    public EntregaResponseDto() {
    }

    public BeneficiadoSummarizedResponseDto getBeneficiado() {
        return beneficiado;
    }

    public void setBeneficiado(BeneficiadoSummarizedResponseDto beneficiado) {
        this.beneficiado = beneficiado;
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

    public EnderecoSummarizedResponseDto getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoSummarizedResponseDto endereco) {
        this.endereco = endereco;
    }

    public CestaSummarizedResponseDto getCesta() {
        return cesta;
    }

    public void setCesta(CestaSummarizedResponseDto cesta) {
        this.cesta = cesta;
    }

    public VoluntarioSummarizedResponseDto getVoluntario() {
        return voluntario;
    }

    public void setVoluntario(VoluntarioSummarizedResponseDto voluntario) {
        this.voluntario = voluntario;
    }
}
