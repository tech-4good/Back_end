package tech4good.cruds.dto.auxiliares;

public class FilhoBeneficiadoBeneficiadoResponseDto {

    private String cpf;
    private String nome;

    public FilhoBeneficiadoBeneficiadoResponseDto(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public FilhoBeneficiadoBeneficiadoResponseDto() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
