package tech4good.tech4good_api.core.application.dto.endereco;

import tech4good.tech4good_api.core.domain.endereco.valueobjects.Status;
import tech4good.tech4good_api.core.domain.endereco.valueobjects.TipoMoradia;
import tech4good.tech4good_api.core.domain.shared.valueobject.TipoCesta;

import java.time.LocalDate;

public class EnderecoResponseDto {

    private Integer idEndereco;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private TipoCesta tipoCesta;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private String moradia;
    private TipoMoradia tipoMoradia;
    private Status status;

    public EnderecoResponseDto() {
    }

    public EnderecoResponseDto(Integer idEndereco, String logradouro, String numero, String complemento, String bairro, String cidade, String estado, String cep, TipoCesta tipoCesta, LocalDate dataEntrada, LocalDate dataSaida, String moradia, TipoMoradia tipoMoradia, Status status) {
        this.idEndereco = idEndereco;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.tipoCesta = tipoCesta;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.moradia = moradia;
        this.tipoMoradia = tipoMoradia;
        this.status = status;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public TipoCesta getTipoCesta() {
        return tipoCesta;
    }

    public void setTipoCesta(TipoCesta tipoCesta) {
        this.tipoCesta = tipoCesta;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getMoradia() {
        return moradia;
    }

    public void setMoradia(String moradia) {
        this.moradia = moradia;
    }

    public TipoMoradia getTipoMoradia() {
        return tipoMoradia;
    }

    public void setTipoMoradia(TipoMoradia tipoMoradia) {
        this.tipoMoradia = tipoMoradia;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
