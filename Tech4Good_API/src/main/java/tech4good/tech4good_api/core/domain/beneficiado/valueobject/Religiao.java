package tech4good.tech4good_api.core.domain.beneficiado.valueobject;

public class Religiao {

    private final String value;

    public Religiao(String value) {
        this.value = value;
    }

    public static Religiao valueOf(String religiao) {
        if (religiao == null || religiao.isBlank()) {
            throw new IllegalArgumentException("Religião não pode ser vazia.");
        }

        String religiaoTrimmed = religiao.trim();

        if (religiaoTrimmed.length() > 50) {
            throw new IllegalArgumentException("Religião não pode ter mais de 50 caracteres.");
        }

        return new Religiao(religiaoTrimmed);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
