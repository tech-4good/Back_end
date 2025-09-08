package tech4good.tech4good_api.core.application.dto.entrega;

import io.swagger.v3.oas.annotations.media.Schema;
import tech4good.tech4good_api.core.application.dto.beneficiado.BeneficiadoSummarizedDto;
import tech4good.tech4good_api.core.application.dto.endereco.EnderecoSummarizedDto;
import tech4good.tech4good_api.core.application.dto.cesta.CestaResponseDto;
import tech4good.tech4good_api.core.application.dto.voluntario.VoluntarioResponseDto;

import java.time.LocalDate;

@Schema(description = "Objeto de resposta para entregas de kits e cestas básicas")
public class EntregaResponseDto {

    @Schema(description = "Identificador único da entrega", example = "1")
    private Integer idEntrega;

    @Schema(description = "Data de retirada da doação", example = "2025-02-10")
    private LocalDate dataRetirada;

    @Schema(description = "Data que poderá fazer a próxima retirada de doação", example = "2025-02-25")
    private LocalDate proximaRetirada;

    @Schema(description = "Informações resumidas do endereço de entrega")
    private EnderecoSummarizedDto endereco;

    @Schema(description = "Informações da cesta ou kit entregue")
    private CestaResponseDto cesta;

    @Schema(description = "Informações do voluntário responsável pela entrega")
    private VoluntarioResponseDto voluntario;

    @Schema(description = "Informações resumidas do beneficiado")
    private BeneficiadoSummarizedDto beneficiado;

    public EntregaResponseDto() {
    }

    public EntregaResponseDto(Integer idEntrega, LocalDate dataRetirada, LocalDate proximaRetirada,
                             EnderecoSummarizedDto endereco, CestaResponseDto cesta,
                             VoluntarioResponseDto voluntario, BeneficiadoSummarizedDto beneficiado) {
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

    public EnderecoSummarizedDto getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoSummarizedDto endereco) {
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

    public BeneficiadoSummarizedDto getBeneficiado() {
        return beneficiado;
    }

    public void setBeneficiado(BeneficiadoSummarizedDto beneficiado) {
        this.beneficiado = beneficiado;
    }
}
