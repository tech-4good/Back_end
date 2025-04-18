package tech4good.cruds.dto.auxiliares;

public class CestaEntregaResponseDto {

    private String tipo;

    public CestaEntregaResponseDto(String tipo) {
        this.tipo = tipo;
    }
    public CestaEntregaResponseDto() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
