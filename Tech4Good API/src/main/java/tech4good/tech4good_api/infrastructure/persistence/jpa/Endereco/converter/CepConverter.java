package tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import tech4good.tech4good_api.core.domain.endereco.valueobjects.Cep;

@Converter(autoApply = true)
public class CepConverter implements AttributeConverter<Cep, String> {
    @Override
    public String convertToDatabaseColumn(Cep cep) {
        return cep != null ? cep.getValue() : null;
    }
    @Override
    public Cep convertToEntityAttribute(String value) {
        return value != null ? new Cep(value) : null;
    }
}

