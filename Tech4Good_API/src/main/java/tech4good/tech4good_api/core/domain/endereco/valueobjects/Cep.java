package tech4good.tech4good_api.core.domain.endereco.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.regex.Pattern;

public class Cep {

    private static final Pattern CEP_REGEX =
            Pattern.compile("^\\d{5}-?\\d{3}$");

    private final String value;

    @JsonCreator
    public Cep(String value) {
        this.value = value;
    }

    public static Cep valueOf(String cep) {
        if (cep.isBlank()) {
            throw new IllegalArgumentException("CEP não pode ser vazio.");
        }

        if (!CEP_REGEX.matcher(cep).matches()) {
            throw new IllegalArgumentException("CEP inválido: " + cep);
        }

        String formatado = cep.replaceAll("[^0-9]", "");

        return new Cep(formatado);
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
        if (!(o instanceof Cep)) return false;
        Cep cep = (Cep) o;
        return Objects.equals(value, cep.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }*/
}
