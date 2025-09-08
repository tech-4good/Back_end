package tech4good.tech4good_api.core.application.dto.tipomorador;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Schema(description = "Objeto de requisição para cadastro de tipo de morador")
public class TipoMoradorRequestDto {

    @Schema(description = "Quantidade de crianças (0-12 anos) na residência", example = "2")
    @PositiveOrZero(message = "Quantidade de crianças deve ser zero ou positiva")
    private Integer quantidadeCrianca;

    @Schema(description = "Quantidade de adolescentes (13-17 anos) na residência", example = "1")
    @PositiveOrZero(message = "Quantidade de adolescentes deve ser zero ou positiva")
    private Integer quantidadeAdolescente;

    @Schema(description = "Quantidade de jovens (18-29 anos) na residência", example = "0")
    @PositiveOrZero(message = "Quantidade de jovens deve ser zero ou positiva")
    private Integer quantidadeJovem;

    @Schema(description = "Quantidade de idosos (60+ anos) na residência", example = "1")
    @PositiveOrZero(message = "Quantidade de idosos deve ser zero ou positiva")
    private Integer quantidadeIdoso;

    @Schema(description = "Quantidade de gestantes na residência", example = "2")
    @PositiveOrZero(message = "Quantidade de gestantes deve ser zero ou positiva")
    private Integer quantidadeGestante;

    @Schema(description = "Quantidade de pessoas com deficiência na residência", example = "1")
    @PositiveOrZero(message = "Quantidade de deficientes deve ser zero ou positiva")
    private Integer quantidadeDeficiente;

    @Schema(description = "Quantidade de pessoas em outras categorias", example = "11")
    @PositiveOrZero(message = "Quantidade de outros deve ser zero ou positiva")
    private Integer quantidadeOutros;

    @Schema(description = "Chave estrangeira do beneficiado responsável", example = "1")
    @NotNull(message = "ID do beneficiado é obrigatório")
    private Integer beneficiadoId;

    @Schema(description = "Chave estrangeira do endereço da residência", example = "1")
    @NotNull(message = "ID do endereço é obrigatório")
    private Integer enderecoId;

    public TipoMoradorRequestDto() {}

    public TipoMoradorRequestDto(Integer quantidadeCrianca, Integer quantidadeAdolescente, Integer quantidadeJovem, Integer quantidadeIdoso, Integer quantidadeGestante, Integer quantidadeDeficiente, Integer quantidadeOutros, Integer beneficiadoId, Integer enderecoId) {
        this.quantidadeCrianca = quantidadeCrianca;
        this.quantidadeAdolescente = quantidadeAdolescente;
        this.quantidadeJovem = quantidadeJovem;
        this.quantidadeIdoso = quantidadeIdoso;
        this.quantidadeGestante = quantidadeGestante;
        this.quantidadeDeficiente = quantidadeDeficiente;
        this.quantidadeOutros = quantidadeOutros;
        this.beneficiadoId = beneficiadoId;
        this.enderecoId = enderecoId;
    }

    public Integer getQuantidadeCrianca() {
        return quantidadeCrianca;
    }

    public void setQuantidadeCrianca(Integer quantidadeCrianca) {
        this.quantidadeCrianca = quantidadeCrianca;
    }

    public Integer getQuantidadeAdolescente() {
        return quantidadeAdolescente;
    }

    public void setQuantidadeAdolescente(Integer quantidadeAdolescente) {
        this.quantidadeAdolescente = quantidadeAdolescente;
    }

    public Integer getQuantidadeJovem() {
        return quantidadeJovem;
    }

    public void setQuantidadeJovem(Integer quantidadeJovem) {
        this.quantidadeJovem = quantidadeJovem;
    }

    public Integer getQuantidadeIdoso() {
        return quantidadeIdoso;
    }

    public void setQuantidadeIdoso(Integer quantidadeIdoso) {
        this.quantidadeIdoso = quantidadeIdoso;
    }

    public Integer getQuantidadeGestante() {
        return quantidadeGestante;
    }

    public void setQuantidadeGestante(Integer quantidadeGestante) {
        this.quantidadeGestante = quantidadeGestante;
    }

    public Integer getQuantidadeDeficiente() {
        return quantidadeDeficiente;
    }

    public void setQuantidadeDeficiente(Integer quantidadeDeficiente) {
        this.quantidadeDeficiente = quantidadeDeficiente;
    }

    public Integer getQuantidadeOutros() {
        return quantidadeOutros;
    }

    public void setQuantidadeOutros(Integer quantidadeOutros) {
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
