package tech4good.tech4good_api.core.application.dto.auxiliogovernamental;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto de resposta para auxílios governamentais")
public class AuxilioGovernamentalResponseDto {

    @Schema(description = "Identificador único do auxílio governamental", example = "1")
    private Integer idAuxilio;

    @Schema(description = "Nome do tipo de auxílio", example = "Bolsa Família")
    private String tipo;

    public AuxilioGovernamentalResponseDto() {
    }

    public AuxilioGovernamentalResponseDto(Integer idAuxilio, String tipo) {
        this.idAuxilio = idAuxilio;
        this.tipo = tipo;
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
