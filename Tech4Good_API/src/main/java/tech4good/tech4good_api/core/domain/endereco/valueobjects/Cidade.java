package tech4good.tech4good_api.core.domain.endereco.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public class Cidade {
    private final String value;

    @JsonCreator
    public Cidade(String value) {
        this.value = value;
    }

    public static Cidade of(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException("Nome da cidade não pode ser vazio.");
        }
        return new Cidade(value.trim());
    }

    public String getValue() {
        return value;
    }

    @JsonValue
    @Override
    public String toString() {
        return value;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cidade)) return false;
        Cidade cidade = (Cidade) o;
        return value.equalsIgnoreCase(cidade.value);
    }

    @Override
    public int hashCode() {
        return value.toLowerCase().hashCode();
    }*/
}
