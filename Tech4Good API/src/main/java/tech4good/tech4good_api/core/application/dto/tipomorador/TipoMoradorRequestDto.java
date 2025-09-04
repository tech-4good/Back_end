package tech4good.tech4good_api.core.application.dto.tipomorador;

public class TipoMoradorRequestDto {
    private Integer quantidadeCrianca;
    private Integer quantidadeAdolescente;
    private Integer quantidadeJovem;
    private Integer quantidadeIdoso;
    private Integer quantidadeGestante;
    private Integer quantidadeDeficiente;
    private Integer quantidadeOutros;
    private Integer beneficiadoId;
    private Integer enderecoId;

    public TipoMoradorRequestDto() {}

    public TipoMoradorRequestDto(Integer quantidadeCrianca, Integer quantidadeAdolescente, Integer quantidadeJovem, Integer quantidadeIdoso, Integer quantidadeGestante, Integer quantidadeDeficiente, Integer quantidadeOutros, Integer beneficiadoId, Integer enderecoId) {
        this.quantidadeCrianca = quantidadeCrianca;
        this.quantidadeAdolescente = quantidadeAdolescente;
        this.quantidadeJovem = quantidadeJovem;
        this.quantidadeIdoso = quantidadeIdoso;
        this.quantidadeGestante = quantidadeGestante;
        this.quantidadeDeficiente = quantidadeDeficiente;
        this.quantidadeOutros = quantidadeOutros;
        this.beneficiadoId = beneficiadoId;
        this.enderecoId = enderecoId;
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

    public Integer getBeneficiadoId() {
        return beneficiadoId;
    }

    public void setBeneficiadoId(Integer beneficiadoId) {
        this.beneficiadoId = beneficiadoId;
    }

    public Integer getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Integer enderecoId) {
        this.enderecoId = enderecoId;
    }
}
