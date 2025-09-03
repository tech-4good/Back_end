package tech4good.tech4good_api.infrastructure.persistence.jpa.Voluntario.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import tech4good.tech4good_api.core.domain.shared.valueobject.Cpf;

@Converter(autoApply = true)
public class CpfConverter implements AttributeConverter<Cpf, String> {
    @Override
    public String convertToDatabaseColumn(Cpf cpf) {
        return cpf != null ? cpf.getValue() : null;
    }

    @Override
    public Cpf convertToEntityAttribute(String value) {
        return value != null ? new Cpf(value) : null;
    }
}
