package tech4good.tech4good_api.core.application.dto.endereco;

import com.fasterxml.jackson.annotation.JsonProperty;
import tech4good.tech4good_api.core.domain.endereco.valueobjects.Bairro;
import tech4good.tech4good_api.core.domain.endereco.valueobjects.Cep;
import tech4good.tech4good_api.core.domain.endereco.valueobjects.Cidade;
import tech4good.tech4good_api.core.domain.endereco.valueobjects.Estado;

public class EnderecoApiCepDto {

    private String logradouro;
    private String complemento;
    private Bairro bairro;
    @JsonProperty("localidade")
    private Cidade cidade;
    private Estado estado;
    private Cep cep;

    public EnderecoApiCepDto() {}

    public EnderecoApiCepDto(String logradouro, String complemento, Bairro bairro, Cidade cidade, Estado estado, Cep cep) {
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
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
}
