package tech4good.tech4good_api.core.application.dto.tipomorador;

public class TipoMoradorUpdateDto {
    private Integer quantidadeCrianca;
    private Integer quantidadeAdolescente;
    private Integer quantidadeJovem;
    private Integer quantidadeIdoso;
    private Integer quantidadeGestante;
    private Integer quantidadeDeficiente;
    private Integer quantidadeOutros;

    public TipoMoradorUpdateDto() {}

    public TipoMoradorUpdateDto(Integer quantidadeCrianca, Integer quantidadeAdolescente, Integer quantidadeJovem, Integer quantidadeIdoso, Integer quantidadeGestante, Integer quantidadeDeficiente, Integer quantidadeOutros) {
        this.quantidadeCrianca = quantidadeCrianca;
        this.quantidadeAdolescente = quantidadeAdolescente;
        this.quantidadeJovem = quantidadeJovem;
        this.quantidadeIdoso = quantidadeIdoso;
        this.quantidadeGestante = quantidadeGestante;
        this.quantidadeDeficiente = quantidadeDeficiente;
        this.quantidadeOutros = quantidadeOutros;
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
}
