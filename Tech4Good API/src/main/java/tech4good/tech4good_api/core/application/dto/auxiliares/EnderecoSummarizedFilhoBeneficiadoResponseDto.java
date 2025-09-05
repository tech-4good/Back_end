package tech4good.tech4good_api.core.application.dto.auxiliares;

import io.swagger.v3.oas.annotations.media.Schema;
import tech4good.tech4good_api.core.domain.endereco.valueobjects.Bairro;
import tech4good.tech4good_api.core.domain.endereco.valueobjects.Cep;
import tech4good.tech4good_api.core.domain.endereco.valueobjects.Cidade;
import tech4good.tech4good_api.core.domain.endereco.valueobjects.Estado;

@Schema(description = "Objeto de resposta para auxiliar entre filhos e endereços")
public class EnderecoSummarizedFilhoBeneficiadoResponseDto {

    @Schema(description = "Identificador único do endereço", example = "1")
    private Integer idEndereco;
    @Schema(description = "Rua ou Avenida", example = "Avenida Marechal Tito")
    private String logradouro;
    @Schema(description = "Número da residência", example = "234")
    private String numero;
    @Schema(description = "Complemento do número da residência", example = "A")
    private String complemento;
    @Schema(description = "Nome do bairro", example = "São Miguel Paulista")
    private Bairro bairro;
    @Schema(description = "Nome da cidade", example = "São Paulo")
    private Cidade cidade;
    @Schema(description = "Nome do estado", example = "São Paulo")
    private Estado estado;
    @Schema(description = "CEP da região onde se encontra a residência", example = "08356723")
    private Cep cep;

    public EnderecoSummarizedFilhoBeneficiadoResponseDto(Integer idEndereco, String logradouro, String numero, String complemento, Bairro bairro, Cidade cidade, Estado estado, Cep cep) {
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

    public Cep getCep() {
        return cep;
    }

    public void setCep(Cep cep) {
        this.cep = cep;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
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
