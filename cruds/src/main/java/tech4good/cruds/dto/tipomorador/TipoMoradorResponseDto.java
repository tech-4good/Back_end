package tech4good.cruds.dto.tipomorador;

import tech4good.cruds.dto.auxiliares.FilhoBeneficiadoBeneficiadoResponseDto;
import tech4good.cruds.dto.auxiliares.FilhoBeneficiadoEnderecoResponseDto;

public class TipoMoradorResponseDto {

    private Integer idTipoMorador;
    private String quantidadeCrianca;
    private String quantidadeAdolescente;
    private String quantidadeJovem;
    private String quantidadeIdoso;
    private String quantidadeGestante;
    private String quantidadeDeficiente;
    private String quantidadeOutros;
    private FilhoBeneficiadoEnderecoResponseDto endereco;
    private FilhoBeneficiadoBeneficiadoResponseDto beneficiado;

    public TipoMoradorResponseDto(Integer idTipoMorador, String quantidadeCrianca, String quantidadeAdolescente, String quantidadeJovem, String quantidadeIdoso, String quantidadeGestante, String quantidadeDeficiente, String quantidadeOutros, FilhoBeneficiadoEnderecoResponseDto endereco, FilhoBeneficiadoBeneficiadoResponseDto beneficiado) {
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

    public FilhoBeneficiadoEnderecoResponseDto getEndereco() {
        return endereco;
    }

    public void setEndereco(FilhoBeneficiadoEnderecoResponseDto endereco) {
        this.endereco = endereco;
    }

    public FilhoBeneficiadoBeneficiadoResponseDto getBeneficiado() {
        return beneficiado;
    }

    public void setBeneficiado(FilhoBeneficiadoBeneficiadoResponseDto beneficiado) {
        this.beneficiado = beneficiado;
    }
}
