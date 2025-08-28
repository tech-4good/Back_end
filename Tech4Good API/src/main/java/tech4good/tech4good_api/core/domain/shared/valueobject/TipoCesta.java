package tech4good.tech4good_api.core.domain.shared.valueobject;

public enum TipoCesta {

    KIT,
    BASICA;

    public static TipoCesta fromString(String tipo) {
        if (tipo.isBlank()) {
            throw new IllegalArgumentException("Tipo de cesta não pode ser vazio.");
        }
        try {
            return TipoCesta.valueOf(tipo.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Tipo de cesta inválido: " + tipo);
        }
    }
}
