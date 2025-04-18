package tech4good.cruds.dto.auxiliogovernamental;

public class AuxilioGovernamentalResponseDto {

    private Integer idAuxilio;
    private String tipo;

    public AuxilioGovernamentalResponseDto(Integer idAuxilio, String tipo) {
        this.idAuxilio = idAuxilio;
        this.tipo = tipo;
    }

    public AuxilioGovernamentalResponseDto() {
    }

    public Integer getIdAuxilio() {
        return idAuxilio;
    }

    public void setIdAuxilio(Integer idAuxilio) {
        this.idAuxilio = idAuxilio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
