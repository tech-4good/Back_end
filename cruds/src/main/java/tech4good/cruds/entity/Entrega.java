package tech4good.cruds.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrega")
    private Integer idEntrega;
    @Column(name = "data_retirada")
    private LocalDate dataRetirada;
    @Column(name = "proxima_retirada")
    private LocalDate proximaRetirada;
    @ManyToOne
    @JoinColumn(name = "id_voluntario")
    private Voluntario voluntario;
    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;
    @ManyToOne
    @JoinColumn(name = "id_cesta")
    private Cesta cesta;

    public Cesta getCesta() {
        return cesta;
    }

    public void setCesta(Cesta cesta) {
        this.cesta = cesta;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Voluntario getVoluntario() {
        return voluntario;
    }

    public void setVoluntario(Voluntario voluntario) {
        this.voluntario = voluntario;
    }

    public Integer getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(Integer idEntrega) {
        this.idEntrega = idEntrega;
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
}
