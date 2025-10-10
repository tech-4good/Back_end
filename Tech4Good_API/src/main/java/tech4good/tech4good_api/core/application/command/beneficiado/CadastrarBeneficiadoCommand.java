package tech4good.tech4good_api.core.application.command.beneficiado;

import tech4good.tech4good_api.core.domain.beneficiado.valueobject.EstadoCivil;
import tech4good.tech4good_api.core.domain.beneficiado.valueobject.Religiao;
import tech4good.tech4good_api.core.domain.beneficiado.valueobject.Renda;
import tech4good.tech4good_api.core.domain.beneficiado.valueobject.Rg;
import tech4good.tech4good_api.core.domain.shared.valueobject.Cpf;
import tech4good.tech4good_api.core.domain.shared.valueobject.Telefone;

import java.time.LocalDate;

public record CadastrarBeneficiadoCommand(
    Cpf cpf,
    String nome,
    Rg rg,
    LocalDate dataNascimento,
    String naturalidade,
    Telefone telefone,
    EstadoCivil estadoCivil,
    String escolaridade,
    String profissao,
    Renda rendaMensal,
    String empresa,
    String cargo,
    Religiao religiao,
    Integer enderecoId,  // Alterado de Endereco para Integer
    Integer quantidadeDependentes,
    Integer fotoId
) {
}
