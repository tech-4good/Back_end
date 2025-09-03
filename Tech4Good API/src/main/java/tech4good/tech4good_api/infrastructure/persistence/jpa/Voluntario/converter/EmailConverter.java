package tech4good.tech4good_api.infrastructure.persistence.jpa.Voluntario.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import tech4good.tech4good_api.core.domain.voluntario.valueobject.Email;

@Converter(autoApply = true)
public class EmailConverter implements AttributeConverter<Email, String> {
    @Override
    public String convertToDatabaseColumn(Email email) {
        return email != null ? email.getValue() : null;
    }

    @Override
    public Email convertToEntityAttribute(String value) {
        return value != null ? new Email(value) : null;
    }
}
