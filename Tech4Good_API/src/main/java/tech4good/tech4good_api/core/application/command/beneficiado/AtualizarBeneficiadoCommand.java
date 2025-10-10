package tech4good.tech4good_api.core.application.command.beneficiado;

import tech4good.tech4good_api.core.domain.beneficiado.valueobject.EstadoCivil;
import tech4good.tech4good_api.core.domain.beneficiado.valueobject.Religiao;
import tech4good.tech4good_api.core.domain.beneficiado.valueobject.Renda;
import tech4good.tech4good_api.core.domain.shared.valueobject.Telefone;

public record AtualizarBeneficiadoCommand(
        String naturalidade,
        Telefone telefone,
        EstadoCivil estadoCivil,
        String escolaridade,
        String profissao,
        Renda rendaMensal,
        String empresa,
        String cargo,
        Religiao religiao,
        Integer quantidadeDependentes,
        Integer enderecoId,
        Integer fotoId
) {}
