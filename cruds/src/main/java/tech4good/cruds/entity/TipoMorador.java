package tech4good.cruds.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Schema(description = "Objeto de entidade para cadastro de tipos de moradores")
@Entity
@Table(name = "tipo_morador")
public class TipoMorador {

    @Schema(description = "Identificador único do tipo do morador", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_morador")
    private Integer idTipoMorador;
    @Schema(description = "Quantidade de Crianças", example = "0")
    @Column(name = "quantidade_crianca")
    private String quantidadeCrianca;
    @Schema(description = "Quantidade de Adolescentes", example = "1")
    @Column(name = "quantidade_adolescente")
    private String quantidadeAdolescente;
    @Schema(description = "Quantidade de Jovens", example = "4")
    @Column(name = "quantidade_jovem")
    private String quantidadeJovem;
    @Schema(description = "Quantidade de Idosos", example = "0")
    @Column(name = "quantidade_idoso")
    private String quantidadeIdoso;
    @Schema(description = "Quantidade de Gestantes", example = "0")
    @Column(name = "quantidade_gestante")
    private String quantidadeGestante;
    @Schema(description = "Quantidade de Deficientes", example = "1")
    @Column(name = "quantidade_deficiente")
    private String quantidadeDeficiente;
    @Schema(description = "Quantidade de Outros", example = "2")
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
