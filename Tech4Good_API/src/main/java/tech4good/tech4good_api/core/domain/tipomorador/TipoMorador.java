package tech4good.tech4good_api.core.domain.tipomorador;

import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;
import tech4good.tech4good_api.core.domain.endereco.Endereco;

public class TipoMorador {
    private Integer id;
    private Integer quantidadeCrianca;
    private Integer quantidadeAdolescente;
    private Integer quantidadeJovem;
    private Integer quantidadeIdoso;
    private Integer quantidadeGestante;
    private Integer quantidadeDeficiente;
    private Integer quantidadeOutros;
    private Beneficiado beneficiado;
    private Endereco endereco;

    // Construtor completo
    public TipoMorador(Integer id, Integer quantidadeCrianca, Integer quantidadeAdolescente, Integer quantidadeJovem, Integer quantidadeIdoso, Integer quantidadeGestante, Integer quantidadeDeficiente, Integer quantidadeOutros, Beneficiado beneficiado, Endereco endereco) {
        // Validações no construtor
        if (quantidadeCrianca != null && quantidadeCrianca < 0) {
            throw new IllegalArgumentException("Quantidade de crianças não pode ser negativa");
        }
        if (quantidadeAdolescente != null && quantidadeAdolescente < 0) {
            throw new IllegalArgumentException("Quantidade de adolescentes não pode ser negativa");
        }
        if (quantidadeJovem != null && quantidadeJovem < 0) {
            throw new IllegalArgumentException("Quantidade de jovens não pode ser negativa");
        }
        if (quantidadeIdoso != null && quantidadeIdoso < 0) {
            throw new IllegalArgumentException("Quantidade de idosos não pode ser negativa");
        }
        if (quantidadeGestante != null && quantidadeGestante < 0) {
            throw new IllegalArgumentException("Quantidade de gestantes não pode ser negativa");
        }
        if (quantidadeDeficiente != null && quantidadeDeficiente < 0) {
            throw new IllegalArgumentException("Quantidade de deficientes não pode ser negativa");
        }
        if (quantidadeOutros != null && quantidadeOutros < 0) {
            throw new IllegalArgumentException("Quantidade de outros não pode ser negativa");
        }
        if (beneficiado == null) {
            throw new IllegalArgumentException("Beneficiado é obrigatório");
        }
        if (endereco == null) {
            throw new IllegalArgumentException("Endereco é obrigatório");
        }

        this.id = id;
        this.quantidadeCrianca = quantidadeCrianca;
        this.quantidadeAdolescente = quantidadeAdolescente;
        this.quantidadeJovem = quantidadeJovem;
        this.quantidadeIdoso = quantidadeIdoso;
        this.quantidadeGestante = quantidadeGestante;
        this.quantidadeDeficiente = quantidadeDeficiente;
        this.quantidadeOutros = quantidadeOutros;
        this.beneficiado = beneficiado;
        this.endereco = endereco;
    }

    // Construtor sem ID (para criação)
    public TipoMorador(Integer quantidadeCrianca, Integer quantidadeAdolescente, Integer quantidadeJovem, Integer quantidadeIdoso, Integer quantidadeGestante, Integer quantidadeDeficiente, Integer quantidadeOutros, Beneficiado beneficiado, Endereco endereco) {
        this(null, quantidadeCrianca, quantidadeAdolescente, quantidadeJovem, quantidadeIdoso, quantidadeGestante, quantidadeDeficiente, quantidadeOutros, beneficiado, endereco);
    }

    // Construtor vazio para frameworks
    public TipoMorador() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Beneficiado getBeneficiado() {
        return beneficiado;
    }

    public void setBeneficiado(Beneficiado beneficiado) {
        this.beneficiado = beneficiado;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
