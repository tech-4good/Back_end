package tech4good.tech4good_api.core.application.dto.tipomorador;

import io.swagger.v3.oas.annotations.media.Schema;
import tech4good.tech4good_api.core.application.dto.auxiliares.BeneficiadoSummarizedResponseDto;
import tech4good.tech4good_api.core.application.dto.auxiliares.EnderecoSummarizedFilhoBeneficiadoResponseDto;

@Schema(description = "Objeto de resposta para cadastro de tipo morador")
public class TipoMoradorResponseDto {

    @Schema(description = "Identificador único do tipo do morador", example = "1")
    private Integer idTipoMorador;
    @Schema(description = "Quantidade de Crianças", example = "0")
    private Integer quantidadeCrianca;
    @Schema(description = "Quantidade de Adolescentes", example = "1")
    private Integer quantidadeAdolescente;
    @Schema(description = "Quantidade de Jovens", example = "4")
    private Integer quantidadeJovem;
    @Schema(description = "Quantidade de Idosos", example = "0")
    private Integer quantidadeIdoso;
    @Schema(description = "Quantidade de Gestantes", example = "0")
    private Integer quantidadeGestante;
    @Schema(description = "Quantidade de Deficientes", example = "1")
    private Integer quantidadeDeficiente;
    @Schema(description = "Quantidade de Outros", example = "2")
    private Integer quantidadeOutros;
    private EnderecoSummarizedFilhoBeneficiadoResponseDto endereco;
    private BeneficiadoSummarizedResponseDto beneficiado;

    public TipoMoradorResponseDto(Integer idTipoMorador, Integer quantidadeCrianca, Integer quantidadeAdolescente, Integer quantidadeJovem, Integer quantidadeIdoso, Integer quantidadeGestante, Integer quantidadeDeficiente, Integer quantidadeOutros, EnderecoSummarizedFilhoBeneficiadoResponseDto endereco, BeneficiadoSummarizedResponseDto beneficiado) {
        this.idTipoMorador = idTipoMorador;
        this.quantidadeCrianca = quantidadeCrianca;
        this.quantidadeAdolescente = quantidadeAdolescente;
        this.quantidadeJovem = quantidadeJovem;
        this.quantidadeIdoso = quantidadeIdoso;
        this.quantidadeGestante = quantidadeGestante;
        this.quantidadeDeficiente = quantidadeDeficiente;
        this.quantidadeOutros = quantidadeOutros;
        this.endereco = endereco;
        this.beneficiado = beneficiado;
    }

    public TipoMoradorResponseDto() {
    }

    public Integer getIdTipoMorador() {
        return idTipoMorador;
    }

    public void setIdTipoMorador(Integer idTipoMorador) {
        this.idTipoMorador = idTipoMorador;
    }

    public Integer getQuantidadeCrianca() {
        return quantidadeCrianca;
    }

    public void setQuantidadeCrianca(Integer quantidadeCrianca) {
        this.quantidadeCrianca = quantidadeCrianca;
    }

    public Integer getQuantidadeAdolescente() {
        return quantidadeAdolescente;
    }

    public void setQuantidadeAdolescente(Integer quantidadeAdolescente) {
        this.quantidadeAdolescente = quantidadeAdolescente;
    }

    public Integer getQuantidadeJovem() {
        return quantidadeJovem;
    }

    public void setQuantidadeJovem(Integer quantidadeJovem) {
        this.quantidadeJovem = quantidadeJovem;
    }

    public Integer getQuantidadeIdoso() {
        return quantidadeIdoso;
    }

    public void setQuantidadeIdoso(Integer quantidadeIdoso) {
        this.quantidadeIdoso = quantidadeIdoso;
    }

    public Integer getQuantidadeGestante() {
        return quantidadeGestante;
    }

    public void setQuantidadeGestante(Integer quantidadeGestante) {
        this.quantidadeGestante = quantidadeGestante;
    }

    public Integer getQuantidadeDeficiente() {
        return quantidadeDeficiente;
    }

    public void setQuantidadeDeficiente(Integer quantidadeDeficiente) {
        this.quantidadeDeficiente = quantidadeDeficiente;
    }

    public Integer getQuantidadeOutros() {
        return quantidadeOutros;
    }

    public void setQuantidadeOutros(Integer quantidadeOutros) {
        this.quantidadeOutros = quantidadeOutros;
    }

    public EnderecoSummarizedFilhoBeneficiadoResponseDto getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoSummarizedFilhoBeneficiadoResponseDto endereco) {
        this.endereco = endereco;
    }

    public BeneficiadoSummarizedResponseDto getBeneficiado() {
        return beneficiado;
    }

    public void setBeneficiado(BeneficiadoSummarizedResponseDto beneficiado) {
        this.beneficiado = beneficiado;
    }
}
