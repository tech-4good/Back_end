package tech4good.tech4good_api.core.domain.entrega;

import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;
import tech4good.tech4good_api.core.domain.cesta.Cesta;
import tech4good.tech4good_api.core.domain.endereco.Endereco;
import tech4good.tech4good_api.core.domain.voluntario.Voluntario;

import java.time.LocalDate;

public class Entrega {
    private Integer id;
    private LocalDate dataRetirada;
    private LocalDate proximaRetirada;
    private Voluntario voluntario;
    private Endereco endereco;
    private Cesta cesta;
    private Beneficiado beneficiado;

    public Entrega(Integer id, LocalDate dataRetirada, LocalDate proximaRetirada, Voluntario voluntario, Endereco endereco, Cesta cesta, Beneficiado beneficiado) {
        this.id = id;
        this.dataRetirada = dataRetirada;
        this.proximaRetirada = proximaRetirada;
        this.voluntario = voluntario;
        this.endereco = endereco;
        this.cesta = cesta;
        this.beneficiado = beneficiado;
    }

    public Entrega() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(LocalDate dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public LocalDate getProximaRetirada() {
        return proximaRetirada;
    }

    public void setProximaRetirada(LocalDate proximaRetirada) {
        this.proximaRetirada = proximaRetirada;
    }

    public Voluntario getVoluntario() {
        return voluntario;
    }

    public void setVoluntario(Voluntario voluntario) {
        this.voluntario = voluntario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Cesta getCesta() {
        return cesta;
    }

    public void setCesta(Cesta cesta) {
        this.cesta = cesta;
    }

    public Beneficiado getBeneficiado() {
        return beneficiado;
    }

    public void setBeneficiado(Beneficiado beneficiado) {
        this.beneficiado = beneficiado;
    }
}
