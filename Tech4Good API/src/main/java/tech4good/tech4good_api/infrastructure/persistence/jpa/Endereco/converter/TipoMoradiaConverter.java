package tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import tech4good.tech4good_api.core.domain.endereco.valueobjects.TipoMoradia;

@Converter(autoApply = true)
public class TipoMoradiaConverter implements AttributeConverter<TipoMoradia, String> {
    @Override
    public String convertToDatabaseColumn(TipoMoradia tipoMoradia) {
        return tipoMoradia != null ? tipoMoradia.getValue() : null;
    }
    @Override
    public TipoMoradia convertToEntityAttribute(String value) {
        return value != null ? new TipoMoradia(value) : null;
    }
}

