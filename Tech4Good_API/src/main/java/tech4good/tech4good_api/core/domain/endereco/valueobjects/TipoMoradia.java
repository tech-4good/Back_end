package tech4good.tech4good_api.core.domain.endereco.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public class TipoMoradia {
    private final String value;

    @JsonCreator
    public TipoMoradia(String value) {
        this.value = value;
    }

    public static TipoMoradia of(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException("Tipo de moradia não pode ser vazio.");
        }
        return new TipoMoradia(value.trim());
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
        if (!(o instanceof TipoMoradia)) return false;
        TipoMoradia that = (TipoMoradia) o;
        return value.equalsIgnoreCase(that.value);
    }

    @Override
    public int hashCode() {
        return value.toLowerCase().hashCode();
    }*/
}
