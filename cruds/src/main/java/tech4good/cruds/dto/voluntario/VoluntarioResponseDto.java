package tech4good.cruds.dto.voluntario;

public class VoluntarioResponseDto {

    private Integer idVoluntario;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;

    public VoluntarioResponseDto(Integer idVoluntario, String nome, String cpf, String telefone, String email) {
        this.idVoluntario = idVoluntario;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
    }

    public VoluntarioResponseDto() {
    }

    public Integer getIdVoluntario() {
        return idVoluntario;
    }

    public void setIdVoluntario(Integer idVoluntario) {
        this.idVoluntario = idVoluntario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
