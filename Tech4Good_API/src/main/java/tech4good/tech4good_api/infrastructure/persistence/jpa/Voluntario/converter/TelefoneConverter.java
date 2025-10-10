package tech4good.tech4good_api.infrastructure.persistence.jpa.Voluntario.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import tech4good.tech4good_api.core.domain.shared.valueobject.Telefone;

@Converter(autoApply = true)
public class TelefoneConverter implements AttributeConverter<Telefone, String> {
    @Override
    public String convertToDatabaseColumn(Telefone telefone) {
        return telefone != null ? telefone.getValue() : null;
    }

    @Override
    public Telefone convertToEntityAttribute(String value) {
        return value != null ? new Telefone(value) : null;
    }
}
