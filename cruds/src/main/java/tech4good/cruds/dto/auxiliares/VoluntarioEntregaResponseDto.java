package tech4good.cruds.dto.auxiliares;

public class VoluntarioEntregaResponseDto {

    private Integer idVoluntario;
    private String nome;

    public VoluntarioEntregaResponseDto(Integer idVoluntario, String nome) {
        this.idVoluntario = idVoluntario;
        this.nome = nome;
    }

    public VoluntarioEntregaResponseDto() {
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
