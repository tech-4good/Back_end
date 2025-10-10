package tech4good.tech4good_api.core.domain.endereco.valueobjects;

public class Bairro {

    private final String value;

    public Bairro(String value) {
        this.value = value;
    }

    public static Bairro of(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException("Nome do bairro não pode ser vazio.");
        }
        return new Bairro(value.trim());
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bairro)) return false;
        Bairro bairro = (Bairro) o;
        return value.equalsIgnoreCase(bairro.value);
    }

    @Override
    public int hashCode() {
        return value.toLowerCase().hashCode();
    }*/
}
