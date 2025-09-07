package tech4good.tech4good_api.core.application.dto.endereco;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Resposta da consulta de CEP contendo apenas dados básicos de endereço")
public class CepResponseDto {

    @Schema(description = "Logradouro/Rua", example = "Praça da Sé")
    private String logradouro;

    @Schema(description = "Complemento", example = "lado ímpar")
    private String complemento;

    @Schema(description = "Bairro", example = "Sé")
    private String bairro;

    @Schema(description = "Cidade", example = "São Paulo")
    private String cidade;

    @Schema(description = "Estado", example = "SP - São Paulo")
    private String estado;

    @Schema(description = "CEP", example = "01001000")
    private String cep;

    public CepResponseDto() {
    }

    public CepResponseDto(String logradouro, String complemento, String bairro, String cidade, String estado, String cep) {
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
