package tech4good.cruds.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BeneficiadoHasAuxilio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer beneficiadoHasAuxilio;

    public Integer getBeneficiadoHasAuxilio() {
        return beneficiadoHasAuxilio;
    }

    public void setBeneficiadoHasAuxilio(Integer beneficiadoHasAuxilio) {
        this.beneficiadoHasAuxilio = beneficiadoHasAuxilio;
    }
}
