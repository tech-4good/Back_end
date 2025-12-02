package tech4good.tech4good_api.core.domain.shared.valueobject;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.regex.Pattern;

public class Telefone {

    private static final Pattern TELEFONE_REGEX =
            Pattern.compile("^\\(?\\d{2}\\)?\\s?(?:9\\d{4}|\\d{4})-?\\d{4}$");

    private final String value;

    @JsonCreator
    public Telefone(String value) {
        this.value = value;
    }

    public static Telefone valueOf(String telefone) {
        if (telefone.isBlank()) {
            throw new IllegalArgumentException("Telefone não pode ser vazio.");
        }

        if (!TELEFONE_REGEX.matcher(telefone).matches()) {
            throw new IllegalArgumentException("Telefone inválido: " + telefone);
        }

        // REMOÇÃO DOS ESPAÇOS
        String formatado = telefone.replaceAll("[^0-9]", "");

        return new Telefone(formatado);
    }

    public String getValue() {
        return value;
    }

    @JsonValue
    @Override
    public String toString() {
        if (value.length() == 11) {
            // DEVOLVE FORMATADO PARA NUMERO DE CELULAR
            return value.replaceFirst("(\\d{2})(\\d{5})(\\d{4})", "($1) $2-$3");
        } else {
            //DEVOLVE FORMATADO PARA NUMERO FIXO
            return value.replaceFirst("(\\d{2})(\\d{4})(\\d{4})", "($1) $2-$3");
        }
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Telefone)) return false;
        Telefone telefone = (Telefone) o;
        return Objects.equals(value, telefone.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }*/
}
