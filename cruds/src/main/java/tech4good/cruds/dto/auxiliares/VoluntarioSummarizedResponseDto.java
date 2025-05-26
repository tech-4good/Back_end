package tech4good.cruds.dto.auxiliares;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto de resposta para auxiliar entre entregas e voluntários")
public class VoluntarioSummarizedResponseDto {

    @Schema(description = "Identificador único do voluntário", example = "1")
    private Integer idVoluntario;
    @Schema(description = "Nome completo do voluntário", example = "Maria Clara da Silva")
    private String nome;

    public VoluntarioSummarizedResponseDto(Integer idVoluntario, String nome) {
        this.idVoluntario = idVoluntario;
        this.nome = nome;
    }

    public VoluntarioSummarizedResponseDto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdVoluntario() {
        return idVoluntario;
    }

    public void setIdVoluntario(Integer idVoluntario) {
        this.idVoluntario = idVoluntario;
    }
}
