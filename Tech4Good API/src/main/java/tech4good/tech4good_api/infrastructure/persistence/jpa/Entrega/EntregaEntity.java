package tech4good.tech4good_api.infrastructure.persistence.jpa.Entrega;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Beneficiado.BeneficiadoEntity;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Cesta.CestaEntity;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco.EnderecoEntity;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Voluntario.VoluntarioEntity;

import java.time.LocalDate;

@Schema(description = "Entidade JPA para entregas de kits e cestas básicas")
@Entity
@Table(name = "entrega")
public class EntregaEntity {

    @Schema(description = "Identificador único da entrega", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrega")
    private Integer idEntrega;

    @Schema(description = "Data de retirada da doação", example = "2025-02-10")
    @Column(name = "data_retirada")
    private LocalDate dataRetirada;

    @Schema(description = "Data que poderá fazer a próxima retirada de doação", example = "2025-02-25")
    @Column(name = "proxima_retirada")
    private LocalDate proximaRetirada;

    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private EnderecoEntity endereco;

    @ManyToOne
    @JoinColumn(name = "id_cesta")
    private CestaEntity cesta;

    @ManyToOne
    @JoinColumn(name = "id_voluntario")
    private VoluntarioEntity voluntario;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "id_beneficiado", referencedColumnName = "id_beneficiado"),
            @JoinColumn(name = "cpf", referencedColumnName = "cpf")
    })
    private BeneficiadoEntity beneficiado;

    public EntregaEntity() {
    }

    public EntregaEntity(Integer idEntrega, LocalDate dataRetirada, LocalDate proximaRetirada,
                        EnderecoEntity endereco, CestaEntity cesta,
                        VoluntarioEntity voluntario, BeneficiadoEntity beneficiado) {
        this.idEntrega = idEntrega;
        this.dataRetirada = dataRetirada;
        this.proximaRetirada = proximaRetirada;
        this.endereco = endereco;
        this.cesta = cesta;
        this.voluntario = voluntario;
        this.beneficiado = beneficiado;
    }

    // Getters e Setters
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

    public EnderecoEntity getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
    }

    public CestaEntity getCesta() {
        return cesta;
    }

    public void setCesta(CestaEntity cesta) {
        this.cesta = cesta;
    }

    public VoluntarioEntity getVoluntario() {
        return voluntario;
    }

    public void setVoluntario(VoluntarioEntity voluntario) {
        this.voluntario = voluntario;
    }

    public BeneficiadoEntity getBeneficiado() {
        return beneficiado;
    }

    public void setBeneficiado(BeneficiadoEntity beneficiado) {
        this.beneficiado = beneficiado;
    }
}
