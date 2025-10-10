package tech4good.tech4good_api.infrastructure.integration.viacep;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ViaCepResponseDto {
    private String logradouro;
    private String complemento;
    private String bairro;
    @JsonProperty("localidade")
    private String cidade;
    private String uf;
    private String cep;
    private String erro;

    public ViaCepResponseDto() {}

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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }
}
