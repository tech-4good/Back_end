package tech4good.cruds.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDate;

@Schema(description = "Objeto de entidade para filhos dos beneficiados")
@Entity
@Table(name = "filho_beneficiado")
public class FilhoBeneficiado {

    @Schema(description = "Identificador único do filho do beneficiado", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_filho_beneficiado")
    private Integer idFilhoBeneficiado;
    @Schema(description = "Data de nascimento do filho", example = "2005/02/15")
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    @Schema(description = "O filho está estudaando?", example = "1")
    @Column(name = "is_estudante")
    private Integer isEstudante;
    @Schema(description = "O filho está em uma creche?", example = "0")
    @Column(name = "has_creche")
    private Integer hasCreche;
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

    public Integer getIdFilhoBeneficiado() {
        return idFilhoBeneficiado;
    }

    public void setIdFilhoBeneficiado(Integer idFilhoBeneficiado) {
        this.idFilhoBeneficiado = idFilhoBeneficiado;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getIsEstudante() {
        return isEstudante;
    }

    public void setIsEstudante(Integer isEstudante) {
        this.isEstudante = isEstudante;
    }

    public Integer getHasCreche() {
        return hasCreche;
    }

    public void setHasCreche(Integer hasCreche) {
        this.hasCreche = hasCreche;
    }
}
