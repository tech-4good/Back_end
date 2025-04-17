package tech4good.cruds.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BeneficiadoId implements Serializable {

    @Column(name = "id_beneficiado")
    private Integer idBeneficiado;
    private String cpf;

    public BeneficiadoId() {
    }

    public BeneficiadoId(Integer idBeneficiado, String cpf) {
        this.idBeneficiado = idBeneficiado;
        this.cpf = cpf;
    }

    public Integer getIdBeneficiado() {
        return idBeneficiado;
    }

    public void setIdBeneficiado(Integer idBeneficiado) {
        this.idBeneficiado = idBeneficiado;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BeneficiadoId that = (BeneficiadoId) o;
        return Objects.equals(idBeneficiado, that.idBeneficiado) && Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBeneficiado, cpf);
    }
}
