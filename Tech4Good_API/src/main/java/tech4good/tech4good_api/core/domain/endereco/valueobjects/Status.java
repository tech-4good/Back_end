package tech4good.tech4good_api.core.domain.endereco.valueobjects;

public enum Status {

    ABERTO,
    FECHADO;

    public static Status fromString(String status) {
        if (status.isBlank()) {
            throw new IllegalArgumentException("Status do endereço não pode ser vazio.");
        }
        try {
            return Status.valueOf(status.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Status de endereço inválido: " + status);
        }
    }
}
