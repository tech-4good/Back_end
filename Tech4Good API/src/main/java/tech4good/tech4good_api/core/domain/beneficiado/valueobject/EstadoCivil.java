package tech4good.tech4good_api.core.domain.beneficiado.valueobject;

public enum EstadoCivil {
    SOLTEIRO("Solteiro(a)"),
    CASADO("Casado(a)"),
    SEPARADO("Separado(a)"),
    DIVORCIADO("Divorciado(a)"),
    VIUVO("Viúvo(a)"),
    UNIAO_ESTAVEL("União Estável");

    private final String descricao;

    EstadoCivil(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static EstadoCivil fromString(String estadoCivil) {
        if (estadoCivil == null || estadoCivil.isBlank()) {
            throw new IllegalArgumentException("Estado civil não pode ser vazio.");
        }
        try {
            return EstadoCivil.valueOf(estadoCivil.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Estado civil inválido: " + estadoCivil);
        }
    }
}
