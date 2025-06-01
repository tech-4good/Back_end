package tech4good.cruds.dto.endereco;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnderecoApiCepDto {

    private String logradouro;
    private String complemento;
    private String bairro;
    @JsonProperty("localidade")
    private String cidade;
    @JsonProperty("uf")
    private String estado;
    private String cep;

    public EnderecoApiCepDto() {}

    public EnderecoApiCepDto(String logradouro, String complemento, String bairro, String cidade, String estado, String cep) {
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
}
