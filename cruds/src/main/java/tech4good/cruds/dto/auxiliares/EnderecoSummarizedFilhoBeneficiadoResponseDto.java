package tech4good.cruds.dto.auxiliares;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto de resposta para auxiliar entre filhos e endereços")
public class EnderecoSummarizedFilhoBeneficiadoResponseDto {

    @Schema(description = "Identificador único do endereço", example = "1")
    private Integer idEndereco;
    @Schema(description = "Rua ou Avenida", example = "Avenida Marechal Tito")
    private String logradouro;
    @Schema(description = "Número da residência", example = "234")
    private Integer numero;
    @Schema(description = "Complemento do número da residência", example = "A")
    private String complemento;
    @Schema(description = "Nome do bairro", example = "São Miguel Paulista")
    private String bairro;
    @Schema(description = "Nome da cidade", example = "São Paulo")
    private String cidade;
    @Schema(description = "Nome do estado", example = "São Paulo")
    private String estado;
    @Schema(description = "CEP da região onde se encontra a residência", example = "08356723")
    private String cep;

    public EnderecoSummarizedFilhoBeneficiadoResponseDto(Integer idEndereco, String logradouro, Integer numero, String complemento, String bairro, String cidade, String estado, String cep) {
        this.idEndereco = idEndereco;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public EnderecoSummarizedFilhoBeneficiadoResponseDto() {
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }
}
