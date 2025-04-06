package tech4good.cruds.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TipoMorador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoMorador;
    private String quantidadeCrianca;
    private String quantidadeAdolescente;
    private String quantidadeJovem;
    private String quantidadeIdoso;
    private String quantidadeGestante;
    private String quantidadeDeficiente;
    private String quantidadeOutros;

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
}
