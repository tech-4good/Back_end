package tech4good.tech4good_api.core.application.dto.endereco;

import io.swagger.v3.oas.annotations.media.Schema;

public class AtualizarEnderecoDadosRequestDto {

    @Schema(description = "Rua ou Avenida", example = "Avenida Marechal Tito")
    private String logradouro;

    @Schema(description = "Número da residência", example = "234")
    private String numero;

    @Schema(description = "Complemento do número da residência", example = "A")
    private String complemento;

    @Schema(description = "Nome do bairro", example = "São Miguel Paulista")
    private String bairro;

    @Schema(description = "Nome da cidade", example = "São Paulo")
    private String cidade;

    @Schema(description = "Nome do estado", example = "SP")
    private String estado;

    @Schema(description = "CEP da região onde se encontra a residência", example = "01001000")
    private String cep;

    @Schema(description = "Tipo de obtenção da moradia", example = "Alugada")
    private String moradia;

    @Schema(description = "Nome do tipo da moradia", example = "Apartamento")
    private String tipoMoradia;


    public AtualizarEnderecoDadosRequestDto() {
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

    public String getMoradia() {
        return moradia;
    }

    public void setMoradia(String moradia) {
        this.moradia = moradia;
    }

    public String getTipoMoradia() {
        return tipoMoradia;
    }

    public void setTipoMoradia(String tipoMoradia) {
        this.tipoMoradia = tipoMoradia;
    }
}

