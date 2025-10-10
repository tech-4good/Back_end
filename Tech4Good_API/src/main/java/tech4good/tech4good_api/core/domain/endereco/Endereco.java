package tech4good.tech4good_api.core.domain.endereco;

import tech4good.tech4good_api.core.domain.shared.valueobject.TipoCesta;
import tech4good.tech4good_api.core.domain.endereco.valueobjects.*;

import java.time.LocalDate;

public class Endereco {
    private Integer id;
    private String logradouro;
    private String numero;
    private String complemento;
    private Bairro bairro;
    private Cidade cidade;
    private Estado estado;
    private Cep cep;
    private TipoCesta tipoCesta;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private String moradia;
    private TipoMoradia tipoMoradia;
    private Status status;

    public Endereco(Integer id, String logradouro, String numero, String complemento, Bairro bairro, Cidade cidade, Estado estado, Cep cep, TipoCesta tipoCesta, LocalDate dataEntrada, LocalDate dataSaida, String moradia, TipoMoradia tipoMoradia, Status status) {

        if (logradouro == null || logradouro.trim().isEmpty()) {
            throw new IllegalArgumentException("Logradouro é obrigatório.");
        }
        if (numero == null || numero.trim().isEmpty()) {
            throw new IllegalArgumentException("Número é obrigatório.");
        }
        if (dataEntrada != null && dataEntrada.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de entrada não pode ser futura.");
        }
        if (dataSaida != null && dataEntrada != null && dataSaida.isBefore(dataEntrada)) {
            throw new IllegalArgumentException("Data de saída não pode ser anterior à data de entrada.");
        }
        if (moradia == null || moradia.trim().isEmpty()) {
            throw new IllegalArgumentException("Moradia é obrigatória.");
        }

        this.id = id;
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

    public Endereco() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Cep getCep() {
        return cep;
    }

    public void setCep(Cep cep) {
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
