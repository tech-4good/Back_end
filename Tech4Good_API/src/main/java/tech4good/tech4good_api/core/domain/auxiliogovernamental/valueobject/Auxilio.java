package tech4good.tech4good_api.core.domain.auxiliogovernamental.valueobject;

public class Auxilio {

    private final String value;

    public Auxilio(String value) {
        this.value = value;
    }

    public static Auxilio valueOf(String auxilio) {
        if (auxilio == null || auxilio.isBlank()) {
            throw new IllegalArgumentException("Auxílio não pode ser nulo ou vazio.");
        }
        return new Auxilio(auxilio.trim());
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
