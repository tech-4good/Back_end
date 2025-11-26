package tech4good.tech4good_api.core.domain.beneficiado.valueobject;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public class Renda {

    private final Double value;

    @JsonCreator
    public Renda(Double value) {
        this.value = value;
    }

    public static Renda valueOf(Double renda) {
        if (renda == null) {
            throw new IllegalArgumentException("Renda não pode ser nula.");
        }
        if (renda < 0) {
            throw new IllegalArgumentException("Renda não pode ser negativa.");
        }
        // Arredonda para 2 casas decimais
        double rendaFormatada = Math.round(renda * 100.0) / 100.0;
        return new Renda(rendaFormatada);
    }

    @JsonValue
    public Double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "R$ " + String.format("%.2f", value);
    }
}
