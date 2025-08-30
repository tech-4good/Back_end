package tech4good.tech4good_api.core.domain.tipomorador;

import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;
import tech4good.tech4good_api.core.domain.endereco.Endereco;

public class TipoMorador {
    private Integer id;
    private Integer quantidadeCrianca;
    private Integer quantidadeAdolescente;
    private Integer quantidadeJovem;
    private Integer quantidadeIdoso;
    private Integer quantidadeGestante;
    private Integer quantidadeDeficiente;
    private Integer quantidadeOutros;
    private Beneficiado beneficiado;
    private Endereco endereco;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getQuantidadeGestnte() {
        return quantidadeGestante;
    }

    public void setQuantidadeGestnte(Integer quantidadeGestnte) {
        this.quantidadeGestante = quantidadeGestnte;
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

    public Beneficiado getBeneficiado() {
        return beneficiado;
    }

    public void setBeneficiado(Beneficiado beneficiado) {
        this.beneficiado = beneficiado;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
