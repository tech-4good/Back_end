package tech4good.tech4good_api.core.application.dto.beneficiado;

import io.swagger.v3.oas.annotations.media.Schema;
import tech4good.tech4good_api.core.domain.beneficiado.valueobject.EstadoCivil;
import tech4good.tech4good_api.core.domain.beneficiado.valueobject.Religiao;
import tech4good.tech4good_api.core.domain.beneficiado.valueobject.Renda;
import tech4good.tech4good_api.core.domain.shared.valueobject.Telefone;

@Schema(description = "DTO para atualização de dados do beneficiado")
public class BeneficiadoAtualizarRequestDto {

    @Schema(description = "Naturalidade do beneficiado", example = "Brasileira")
    private String naturalidade;

    @Schema(description = "Telefone para contato com DDD", example = "(11)98765-4321")
    private Telefone telefone;

    @Schema(description = "Estado civil do beneficiado", example = "CASADO")
    private EstadoCivil estadoCivil;

    @Schema(description = "Nível de escolaridade do beneficiado", example = "Ensino médio completo")
    private String escolaridade;

    @Schema(description = "Profissão do beneficiado", example = "Auxiliar de limpeza")
    private String profissao;

    @Schema(description = "Renda mensal do beneficiado em reais", example = "1320.00")
    private Renda rendaMensal;

    @Schema(description = "Nome da empresa onde trabalha", example = "Limpeza Total Ltda")
    private String empresa;

    @Schema(description = "Cargo que ocupa na empresa", example = "Auxiliar de serviços gerais")
    private String cargo;

    @Schema(description = "Religião do beneficiado", example = "Católica")
    private Religiao religiao;

    @Schema(description = "Quantidade de dependentes", example = "2")
    private Integer quantidadeDependentes;

    @Schema(description = "ID do endereço onde reside", example = "1")
    private Integer enderecoId;

    @Schema(description = "ID da foto do beneficiado", example = "1")
    private Integer fotoId;

    public BeneficiadoAtualizarRequestDto(String naturalidade, Telefone telefone, EstadoCivil estadoCivil, String escolaridade, String profissao, Renda rendaMensal, String empresa, String cargo, Religiao religiao, Integer quantidadeDependentes, Integer enderecoId, Integer fotoId) {
        this.naturalidade = naturalidade;
        this.telefone = telefone;
        this.estadoCivil = estadoCivil;
        this.escolaridade = escolaridade;
        this.profissao = profissao;
        this.rendaMensal = rendaMensal;
        this.empresa = empresa;
        this.cargo = cargo;
        this.religiao = religiao;
        this.quantidadeDependentes = quantidadeDependentes;
        this.enderecoId = enderecoId;
        this.fotoId = fotoId;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public String getProfissao() {
        return profissao;
    }

    public Renda getRendaMensal() {
        return rendaMensal;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public Religiao getReligiao() {
        return religiao;
    }

    public Integer getEnderecoId() {
        return enderecoId;
    }

    public Integer quantidadeDependentes() {
        return quantidadeDependentes;
    }

    public Integer getFotoId() {
        return fotoId;
    }
}
