package tech4good.tech4good_api.core.domain.beneficiado.valueobject;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Renda {

    private final BigDecimal value;

    private Renda(BigDecimal value) {
        this.value = value;
    }

    public static Renda valueOf(BigDecimal renda) {
        if (renda == null) {
            throw new IllegalArgumentException("Renda não pode ser nula.");
        }

        if (renda.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Renda não pode ser negativa.");
        }

        // Arredonda para 2 casas decimais
        BigDecimal rendaFormatada = renda.setScale(2, RoundingMode.HALF_UP);

        return new Renda(rendaFormatada);
    }

    public static Renda valueOf(Double renda) {
        if (renda == null) {
            throw new IllegalArgumentException("Renda não pode ser nula.");
        }

        return valueOf(BigDecimal.valueOf(renda));
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "R$ " + value.toString();
    }
}
