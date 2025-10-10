package tech4good.tech4good_api.core.application.dto.filaespera;

public enum TipoEventoFilaEspera {
    ENTRADA_FILA("Entrada na fila de espera"),
    SAIDA_FILA("Saída da fila de espera");

    private final String descricao;

    TipoEventoFilaEspera(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
