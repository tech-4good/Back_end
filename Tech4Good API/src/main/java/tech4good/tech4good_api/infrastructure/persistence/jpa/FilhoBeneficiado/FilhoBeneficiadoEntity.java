package tech4good.tech4good_api.infrastructure.persistence.jpa.FilhoBeneficiado;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Beneficiado.BeneficiadoEntity;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco.EnderecoEntity;

import java.time.LocalDate;

@Schema(description = "Objeto de entidade para filhos dos beneficiados")
@Entity
@Table(name = "filho_beneficiado")
public class FilhoBeneficiadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_filho_beneficiado")
    private Integer id;

    @Schema(description = "Data de nascimento do filho", example = "2005-02-15")
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Schema(description = "O filho está estudando?", example = "true")
    @Column(name = "is_estudante")
    private Boolean isEstudante;

    @Schema(description = "O filho está em uma creche?", example = "false")
    @Column(name = "has_creche")
    private Boolean hasCreche;

    @ManyToOne
    @JoinColumn(name = "id_beneficiado")
    private BeneficiadoEntity beneficiado;

    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private EnderecoEntity endereco;

    public FilhoBeneficiadoEntity() {
    }

    public FilhoBeneficiadoEntity(Integer id, LocalDate dataNascimento, Boolean isEstudante, Boolean hasCreche, BeneficiadoEntity beneficiado, EnderecoEntity endereco) {
        this.id = id;
        this.dataNascimento = dataNascimento;
        this.isEstudante = isEstudante;
        this.hasCreche = hasCreche;
        this.beneficiado = beneficiado;
        this.endereco = endereco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Boolean getIsEstudante() {
        return isEstudante;
    }

    public void setIsEstudante(Boolean isEstudante) {
        this.isEstudante = isEstudante;
    }

    public Boolean getHasCreche() {
        return hasCreche;
    }

    public void setHasCreche(Boolean hasCreche) {
        this.hasCreche = hasCreche;
    }

    public BeneficiadoEntity getBeneficiado() {
        return beneficiado;
    }

    public void setBeneficiado(BeneficiadoEntity beneficiado) {
        this.beneficiado = beneficiado;
    }

    public EnderecoEntity getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
    }
}
