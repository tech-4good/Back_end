package tech4good.tech4good_api.core.domain.endereco.valueobjects;

public enum Estado {

    AC("Acre"),
    AL("Alagoas"),
    AP("Amapá"),
    AM("Amazonas"),
    BA("Bahia"),
    CE("Ceará"),
    DF("Distrito Federal"),
    ES("Espírito Santo"),
    GO("Goiás"),
    MA("Maranhão"),
    MT("Mato Grosso"),
    MS("Mato Grosso do Sul"),
    MG("Minas Gerais"),
    PA("Pará"),
    PB("Paraíba"),
    PR("Paraná"),
    PE("Pernambuco"),
    PI("Piauí"),
    RJ("Rio de Janeiro"),
    RN("Rio Grande do Norte"),
    RS("Rio Grande do Sul"),
    RO("Rondônia"),
    RR("Roraima"),
    SC("Santa Catarina"),
    SP("São Paulo"),
    SE("Sergipe"),
    TO("Tocantins");

    private final String nome;

    Estado(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return name() + " - " + nome;
    }

    public static Estado fromSigla(String sigla) {
        if (sigla.isBlank()) {
            throw new IllegalArgumentException("Sigla do estado não pode ser vazia.");
        }
        try {
            return Estado.valueOf(sigla.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Sigla de estado inválida: " + sigla);
        }
    }
}
