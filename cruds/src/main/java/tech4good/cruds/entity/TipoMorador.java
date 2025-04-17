package tech4good.cruds.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_morador")
public class TipoMorador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_morador")
    private Integer idTipoMorador;
    @Column(name = "quantidade_crianca")
    private String quantidadeCrianca;
    @Column(name = "quantidade_adolescente")
    private String quantidadeAdolescente;
    @Column(name = "quantidade_jovem")
    private String quantidadeJovem;
    @Column(name = "quantidade_idoso")
    private String quantidadeIdoso;
    @Column(name = "quantidade_gestante")
    private String quantidadeGestante;
    @Column(name = "quantidade_deficiente")
    private String quantidadeDeficiente;
    @Column(name = "quantidade_outros")
    private String quantidadeOutros;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "id_beneficiado", referencedColumnName = "id_beneficiado"),
            @JoinColumn(name = "cpf", referencedColumnName = "cpf")
    })
    private Beneficiado beneficiado;
    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Beneficiado getBeneficiado() {
        return beneficiado;
    }

    public void setBeneficiado(Beneficiado beneficiado) {
        this.beneficiado = beneficiado;
    }

    public Integer getIdTipoMorador() {
        return idTipoMorador;
    }

    public void setIdTipoMorador(Integer idTipoMorador) {
        this.idTipoMorador = idTipoMorador;
    }

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
}
