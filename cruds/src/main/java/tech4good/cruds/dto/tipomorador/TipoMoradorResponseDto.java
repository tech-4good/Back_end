package tech4good.cruds.dto.tipomorador;

import io.swagger.v3.oas.annotations.media.Schema;
import tech4good.cruds.dto.auxiliares.BeneficiadoSummarizedResponseDto;
import tech4good.cruds.dto.auxiliares.EnderecoSummarizedFilhoBeneficiadoResponseDto;

@Schema(description = "Objeto de resposta para cadastro de voluntários")
public class TipoMoradorResponseDto {

    @Schema(description = "Identificador único do tipo do morador", example = "1")
    private Integer idTipoMorador;
    @Schema(description = "Quantidade de Crianças", example = "0")
    private String quantidadeCrianca;
    @Schema(description = "Quantidade de Adolescentes", example = "1")
    private String quantidadeAdolescente;
    @Schema(description = "Quantidade de Jovens", example = "4")
    private String quantidadeJovem;
    @Schema(description = "Quantidade de Idosos", example = "0")
    private String quantidadeIdoso;
    @Schema(description = "Quantidade de Gestantes", example = "0")
    private String quantidadeGestante;
    @Schema(description = "Quantidade de Deficientes", example = "1")
    private String quantidadeDeficiente;
    @Schema(description = "Quantidade de Outros", example = "2")
    private String quantidadeOutros;
    private EnderecoSummarizedFilhoBeneficiadoResponseDto endereco;
    private BeneficiadoSummarizedResponseDto beneficiado;

    public TipoMoradorResponseDto(Integer idTipoMorador, String quantidadeCrianca, String quantidadeAdolescente, String quantidadeJovem, String quantidadeIdoso, String quantidadeGestante, String quantidadeDeficiente, String quantidadeOutros, EnderecoSummarizedFilhoBeneficiadoResponseDto endereco, BeneficiadoSummarizedResponseDto beneficiado) {
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

    public String getQuantidadeCrianca() {
        return quantidadeCrianca;
    }

    public void setQuantidadeCrianca(String quantidadeCrianca) {
        this.quantidadeCrianca = quantidadeCrianca;
    }

    public String getQuantidadeAdolescente() {
        return quantidadeAdolescente;
    }

    public void setQuantidadeAdolescente(String quantidadeAdolescente) {
        this.quantidadeAdolescente = quantidadeAdolescente;
    }

    public String getQuantidadeJovem() {
        return quantidadeJovem;
    }

    public void setQuantidadeJovem(String quantidadeJovem) {
        this.quantidadeJovem = quantidadeJovem;
    }

    public String getQuantidadeIdoso() {
        return quantidadeIdoso;
    }

    public void setQuantidadeIdoso(String quantidadeIdoso) {
        this.quantidadeIdoso = quantidadeIdoso;
    }

    public String getQuantidadeGestante() {
        return quantidadeGestante;
    }

    public void setQuantidadeGestante(String quantidadeGestante) {
        this.quantidadeGestante = quantidadeGestante;
    }

    public String getQuantidadeDeficiente() {
        return quantidadeDeficiente;
    }

    public void setQuantidadeDeficiente(String quantidadeDeficiente) {
        this.quantidadeDeficiente = quantidadeDeficiente;
    }

    public String getQuantidadeOutros() {
        return quantidadeOutros;
    }

    public void setQuantidadeOutros(String quantidadeOutros) {
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
