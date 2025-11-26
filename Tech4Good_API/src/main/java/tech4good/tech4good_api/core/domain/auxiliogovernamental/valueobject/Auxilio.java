package tech4good.tech4good_api.core.domain.auxiliogovernamental.valueobject;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public class Auxilio {

    private final String value;

    @JsonCreator
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

    @JsonValue
    @Override
    public String toString() {
        return value;
    }
}
