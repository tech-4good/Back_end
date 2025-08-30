package tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import tech4good.tech4good_api.core.domain.endereco.valueobjects.Cidade;

@Converter(autoApply = true)
public class CidadeConverter implements AttributeConverter<Cidade, String> {
    @Override
    public String convertToDatabaseColumn(Cidade cidade) {
        return cidade != null ? cidade.getValue() : null;
    }
    @Override
    public Cidade convertToEntityAttribute(String value) {
        return value != null ? new Cidade(value) : null;
    }
}

