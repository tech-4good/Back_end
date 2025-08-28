package tech4good.tech4good_api.core.domain.shared.valueobject;

import java.util.regex.Pattern;

public class Cpf {

    private static final Pattern CPF_REGEX =
            Pattern.compile("^\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2}$");

    private final String value;

    private Cpf(String value) {
        this.value = value;
    }

    public static Cpf valueOf(String cpf) {
        if (cpf.isBlank()) {
            throw new IllegalArgumentException("CPF não pode ser vazio.");
        }

        if (!CPF_REGEX.matcher(cpf).matches()) {
            throw new IllegalArgumentException("CPF inválido: " + cpf);
        }

        // UMA FORMATAÇÃO SIMPLES TIRANDO TRAÇO E PONTO
        String formatado = cpf.replaceAll("[^0-9]", "");

        return new Cpf(formatado);
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cpf)) return false;
        Cpf cpf = (Cpf) o;
        return Objects.equals(value, cpf.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }*/

    @Override
    public String toString() {
        // RETORNA FORMATADO
        return value.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }
}
