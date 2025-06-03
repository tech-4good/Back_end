package tech4good.cruds.dto.tipomorador;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Objeto de requisição para cadastro de tipos de moradores")
public class TipoMoradorRequestDto {

    @Schema(description = "Quantidade de Crianças", example = "0")
    private String quantidadeCrianca;
    @Schema(description = "Quantidade de Adolescentes", example = "1")
    private String quantidadeAdolescente;
    @Schema(description = "Quantidade de Jovens", example = "4")
    private String quantidadeJovem;
    @Schema(description = "Quantidade de Idosos", example = "0")
    private String quantidadeIdoso;
    @Schema(description = "Quantidade de Gestantes", example = "0")
    private String quantidadeGestante;
    @Schema(description = "Quantidade de Deficientes", example = "1")
    private String quantidadeDeficiente;
    @Schema(description = "Quantidade de Outros", example = "2")
    private String quantidadeOutros;
    @Schema(description = "Chave estrangeira do beneficiado associado", example = "1")
    @NotNull
    private Integer beneficiadoId;
    @Schema(description = "Chave estrangeira do endereço associado", example = "1")
    @NotNull
    private Integer enderecoId;

    public String getQuantidadeCrianca() {
        return quantidadeCrianca;
    }

    public void setQuantidadeCrianca(String quantidadeCrianca) {
        this.quantidadeCrianca = quantidadeCrianca;
    }

    public String getQuantidadeAdolescente() {
        return quantidadeAdolescente;
    }

    public void setQuantidadeAdolescente(String quantidadeAdolescente) {
        this.quantidadeAdolescente = quantidadeAdolescente;
    }

    public String getQuantidadeJovem() {
        return quantidadeJovem;
    }

    public void setQuantidadeJovem(String quantidadeJovem) {
        this.quantidadeJovem = quantidadeJovem;
    }

    public String getQuantidadeIdoso() {
        return quantidadeIdoso;
    }

    public void setQuantidadeIdoso(String quantidadeIdoso) {
        this.quantidadeIdoso = quantidadeIdoso;
    }

    public String getQuantidadeGestante() {
        return quantidadeGestante;
    }

    public void setQuantidadeGestante(String quantidadeGestante) {
        this.quantidadeGestante = quantidadeGestante;
    }

    public String getQuantidadeDeficiente() {
        return quantidadeDeficiente;
    }

    public void setQuantidadeDeficiente(String quantidadeDeficiente) {
        this.quantidadeDeficiente = quantidadeDeficiente;
    }

    public String getQuantidadeOutros() {
        return quantidadeOutros;
    }

    public void setQuantidadeOutros(String quantidadeOutros) {
        this.quantidadeOutros = quantidadeOutros;
    }

    public Integer getBeneficiadoId() {
        return beneficiadoId;
    }

    public void setBeneficiadoId(Integer beneficiadoId) {
        this.beneficiadoId = beneficiadoId;
    }

    public Integer getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Integer enderecoId) {
        this.enderecoId = enderecoId;
    }
}
