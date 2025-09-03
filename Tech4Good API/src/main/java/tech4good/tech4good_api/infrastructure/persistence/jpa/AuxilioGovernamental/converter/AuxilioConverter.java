package tech4good.tech4good_api.infrastructure.persistence.jpa.AuxilioGovernamental.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import tech4good.tech4good_api.core.domain.auxiliogovernamental.valueobject.Auxilio;

@Converter(autoApply = true)
public class AuxilioConverter implements AttributeConverter<Auxilio, String> {
    @Override
    public String convertToDatabaseColumn(Auxilio auxilio) {
        return auxilio != null ? auxilio.getValue() : null;
    }

    @Override
    public Auxilio convertToEntityAttribute(String value) {
        return value != null ? Auxilio.valueOf(value) : null;
    }
}
