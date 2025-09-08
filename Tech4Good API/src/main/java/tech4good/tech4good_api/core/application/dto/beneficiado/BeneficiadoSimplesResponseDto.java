package tech4good.tech4good_api.core.application.dto.beneficiado;

import io.swagger.v3.oas.annotations.media.Schema;
import tech4good.tech4good_api.core.application.dto.endereco.EnderecoSummarizedDto;
import java.time.LocalDate;

@Schema(description = "Resposta com dados simplificados do beneficiado")
public class BeneficiadoSimplesResponseDto {

    @Schema(description = "Identificador único do beneficiado", example = "1")
    private Integer id;

    @Schema(description = "CPF do beneficiado", example = "12345678901")
    private String cpf;

    @Schema(description = "Nome completo do beneficiado", example = "Maria Silva Santos")
    private String nome;

    @Schema(description = "Data de nascimento do beneficiado", example = "1985-03-15")
    private LocalDate dataNascimento;

    @Schema(description = "Informações resumidas do endereço onde reside")
    private EnderecoSummarizedDto endereco;

    @Schema(description = "ID da foto do beneficiado", example = "1")
    private Integer fotoId;

    public BeneficiadoSimplesResponseDto() {}

    public BeneficiadoSimplesResponseDto(Integer id, String cpf, String nome, LocalDate dataNascimento, EnderecoSummarizedDto endereco, Integer fotoId) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.fotoId = fotoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public EnderecoSummarizedDto getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoSummarizedDto endereco) {
        this.endereco = endereco;
    }

    public Integer getFotoId() {
        return fotoId;
    }

    public void setFotoId(Integer fotoId) {
        this.fotoId = fotoId;
    }
}
