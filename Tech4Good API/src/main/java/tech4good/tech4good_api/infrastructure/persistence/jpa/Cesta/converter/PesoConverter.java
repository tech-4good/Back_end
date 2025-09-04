package tech4good.tech4good_api.infrastructure.persistence.jpa.Cesta.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import tech4good.tech4good_api.core.domain.cesta.valueobject.Peso;

@Converter(autoApply = true)
public class PesoConverter implements AttributeConverter<Peso, Double> {

    @Override
    public Double convertToDatabaseColumn(Peso peso) {
        return peso != null ? peso.getValue() : null;
    }

    @Override
    public Peso convertToEntityAttribute(Double value) {
        return value != null ? Peso.valueOf(value) : null;
    }
}
