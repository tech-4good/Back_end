package tech4good.tech4good_api.core.domain.beneficiado.valueobject;

import java.util.regex.Pattern;

public class Rg {

    private static final Pattern RG_REGEX =
            Pattern.compile("^\\d{1,2}\\.?\\d{3}\\.?\\d{3}-?[0-9Xx]$");

    private final String value;

    public Rg(String value) {
        this.value = value;
    }

    public static Rg valueOf(String rg) {
        if (rg.isBlank()) {
            throw new IllegalArgumentException("RG não pode ser vazio.");
        }

        if (!RG_REGEX.matcher(rg).matches()) {
            throw new IllegalArgumentException("RG inválido: " + rg);
        }

        // FORMATA O RG TIRANDO PONTOS E TRAÇOS
        String formatado = rg.replaceAll("[^0-9Xx]", "").toUpperCase();

        return new Rg(formatado);
    }

    public String getValue() {
        return value;
    }

    // RETORNA FORMATADO
    @Override
    public String toString() {
        return value.replaceFirst("(\\d{2})(\\d{3})(\\d{3})([0-9X])", "$1.$2.$3-$4");
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rg)) return false;
        Rg rg = (Rg) o;
        return Objects.equals(value, rg.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }*/
}
