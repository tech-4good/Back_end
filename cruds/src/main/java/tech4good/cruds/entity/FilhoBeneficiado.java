package tech4good.cruds.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "filho_beneficiado")
public class FilhoBeneficiado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_filho_beneficiado")
    private Integer idFilhoBeneficiado;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    @Column(name = "is_estudante")
    private Integer isEstudante;
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
