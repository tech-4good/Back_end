package tech4good.cruds.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDate;

@Schema(description = "Objeto de entidade para entregas de kits e cestas básicas")
@Entity
public class Entrega {

    @Schema(description = "Identificador único da entrega", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrega")
    private Integer idEntrega;
    @Schema(description = "Data de retirada da doação", example = "2025/02/10")
    @Column(name = "data_retirada")
    private LocalDate dataRetirada;
    @Schema(description = "Data que poderá fazer a próxima retirada de doação", example = "2025/02/25")
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
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "id_beneficiado", referencedColumnName = "id_beneficiado"),
            @JoinColumn(name = "cpf", referencedColumnName = "cpf")
    })
    private Beneficiado beneficiado;

    public Beneficiado getBeneficiado() {
        return beneficiado;
    }

    public void setBeneficiado(Beneficiado beneficiado) {
        this.beneficiado = beneficiado;
    }

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
