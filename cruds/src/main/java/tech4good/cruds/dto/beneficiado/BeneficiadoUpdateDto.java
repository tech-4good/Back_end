package tech4good.cruds.dto.beneficiado;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import tech4good.cruds.entity.Endereco;

@Schema(description = "Objeto de atualização para beneficiado da ASA")
public class BeneficiadoUpdateDto {
    @Schema(description = "Telefone para contato com DDD", example = "Japones")
    @NotBlank
    private String naturalidade;
    @Schema(description = "Telefone para contato com DDD", example = "11912345677")
    @NotBlank
    private String telefone;
    @Schema(description = "Estado civil do beneficiado", example = "Casado")
    @NotBlank
    private String estadoCivil;
    @Schema(description = "Nível de escolaridade do beneficiado", example = "Ensino superior completo")
    @NotBlank
    private String escolaridade;
    @Schema(description = "Profissão do beneficiado", example = "Gerente de Limpeza")
    @NotBlank
    private String profissao;
    @Schema(description = "Renda mensal do beneficiado", example = "4000,0")
    @NotBlank
    private Double rendaMensal;
    @Schema(description = "Nome da empresa em que o beneficiado trabalha", example = "Unilever")
    private String empresa;
    @Schema(description = "Cargo profissional do beneficiado", example = "Gerente")
    private String cargo;
    @Schema(description = "Religião do beneficiado", example = "Adventista")
    @NotBlank
    private String religiao;
    @NotBlank
    private Endereco endereco;

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public Double getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(Double rendaMensal) {
        this.rendaMensal = rendaMensal;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getReligiao() {
        return religiao;
    }

    public void setReligiao(String religiao) {
        this.religiao = religiao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
