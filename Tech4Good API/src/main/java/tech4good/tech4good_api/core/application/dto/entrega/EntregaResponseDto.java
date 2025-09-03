package tech4good.tech4good_api.core.application.dto.entrega;

import io.swagger.v3.oas.annotations.media.Schema;
import tech4good.tech4good_api.core.application.dto.beneficiado.BeneficiadoResponseDto;
import tech4good.tech4good_api.core.application.dto.endereco.EnderecoResponseDto;

import java.time.LocalDate;

@Schema(description = "Objeto de resposta para entregas de kits e cestas básicas")
public class EntregaResponseDto {

    @Schema(description = "Identificador único da entrega", example = "1")
    private Integer idEntrega;

    @Schema(description = "Data de retirada da doação", example = "2025-02-10")
    private LocalDate dataRetirada;

    @Schema(description = "Data que poderá fazer a próxima retirada de doação", example = "2025-02-25")
    private LocalDate proximaRetirada;

    private EnderecoResponseDto endereco;
    private CestaResponseDto cesta;
    private VoluntarioResponseDto voluntario;
    private BeneficiadoResponseDto beneficiado;

    public EntregaResponseDto() {
    }

    public EntregaResponseDto(Integer idEntrega, LocalDate dataRetirada, LocalDate proximaRetirada,
                             EnderecoResponseDto endereco, CestaResponseDto cesta,
                             VoluntarioResponseDto voluntario, BeneficiadoResponseDto beneficiado) {
        this.idEntrega = idEntrega;
        this.dataRetirada = dataRetirada;
        this.proximaRetirada = proximaRetirada;
        this.endereco = endereco;
        this.cesta = cesta;
        this.voluntario = voluntario;
        this.beneficiado = beneficiado;
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

    public EnderecoResponseDto getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoResponseDto endereco) {
        this.endereco = endereco;
    }

    public CestaResponseDto getCesta() {
        return cesta;
    }

    public void setCesta(CestaResponseDto cesta) {
        this.cesta = cesta;
    }

    public VoluntarioResponseDto getVoluntario() {
        return voluntario;
    }

    public void setVoluntario(VoluntarioResponseDto voluntario) {
        this.voluntario = voluntario;
    }

    public BeneficiadoResponseDto getBeneficiado() {
        return beneficiado;
    }

    public void setBeneficiado(BeneficiadoResponseDto beneficiado) {
        this.beneficiado = beneficiado;
    }
}
