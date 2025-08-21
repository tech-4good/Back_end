package tech4good.cruds.dto.endereco;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Schema(description = "Objeto de requisição para endereços")
public class EnderecoRequestDto {

    @Schema(description = "Rua ou Avenida", example = "Avenida Marechal Tito")
    @NotBlank
    private String logradouro;
    @Schema(description = "Número da residência", example = "234")
    @NotNull
    @Positive
    private Integer numero;
    @Schema(description = "Complemento do número da residência", example = "A")
    private String complemento;
    @Schema(description = "Nome do bairro", example = "São Miguel Paulista")
    @NotBlank
    private String bairro;
    @Schema(description = "Nome da cidade", example = "São Paulo")
    @NotBlank
    private String cidade;
    @Schema(description = "Nome do estado", example = "SP")
    @NotBlank
    private String estado;
    @Schema(description = "CEP da região onde se encontra a residência", example = "01001000")
    @NotBlank
    @Size(min = 8, max = 8)
    private String cep;
    @Schema(description = "Tipo de cesta que o endereço pode receber atualmente", example = "Kit")
    @NotBlank
    private String tipoCesta;
    @Schema(description = "Data de entrada no projeto ASA", example = "2025-02-10")
    @NotNull
    @PastOrPresent
    private LocalDate dataEntrada;
    @Schema(description = "Tipo de obtenção da moradia", example = "Alugada")
    private String moradia;
    @Schema(description = "Nome do tipo da moradia", example = "Apartamento")
    private String tipoMoradia;
    @Schema(description = "Controle para saber se ainda está participando da ASA", example = "Aberto")
    @NotBlank
    private String status;

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
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

    public String getTipoCesta() {
        return tipoCesta;
    }

    public void setTipoCesta(String tipoCesta) {
        this.tipoCesta = tipoCesta;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
