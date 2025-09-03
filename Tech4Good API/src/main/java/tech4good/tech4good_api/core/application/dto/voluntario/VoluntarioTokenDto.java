package tech4good.tech4good_api.core.application.dto.voluntario;

public class VoluntarioTokenDto {

    private Integer userId;
    private String nome;
    private String email;
    private String token;

    public VoluntarioTokenDto() {}

    public VoluntarioTokenDto(Integer userId, String nome, String email, String token) {
        this.userId = userId;
        this.nome = nome;
        this.email = email;
        this.token = token;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
