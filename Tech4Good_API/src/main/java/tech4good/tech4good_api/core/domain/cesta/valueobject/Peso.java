package tech4good.tech4good_api.core.domain.cesta.valueobject;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public class Peso {

    private final Double value;

    @JsonCreator
    public Peso(Double value) {
        this.value = value;
    }

    public static Peso valueOf(Double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O peso deve ser maior que zero.");
        }
        return new Peso(valor);
    }

    public Double getValue() {
        return value;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Peso)) return false;
        Peso peso = (Peso) o;
        return Double.compare(peso.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }*/

    @JsonValue
    @Override
    public String toString() {
        return value + " kg";
    }

}
