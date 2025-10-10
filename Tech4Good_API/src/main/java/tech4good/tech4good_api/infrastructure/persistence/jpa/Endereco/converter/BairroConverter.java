package tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import tech4good.tech4good_api.core.domain.endereco.valueobjects.Bairro;

@Converter(autoApply = true)
public class BairroConverter implements AttributeConverter<Bairro, String> {
    @Override
    public String convertToDatabaseColumn(Bairro bairro) {
        return bairro != null ? bairro.getValue() : null;
    }
    @Override
    public Bairro convertToEntityAttribute(String value) {
        return value != null ? Bairro.of(value) : null;
    }
}

