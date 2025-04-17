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
    private Boolean isEstudante;
    @Column(name = "has_creche")
    private Boolean hasCreche;
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
}
