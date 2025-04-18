package tech4good.cruds.dto.auxiliogovernamental;

import jakarta.validation.constraints.NotBlank;

public class AuxilioGovernamentalRequestDto {

    @NotBlank
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
