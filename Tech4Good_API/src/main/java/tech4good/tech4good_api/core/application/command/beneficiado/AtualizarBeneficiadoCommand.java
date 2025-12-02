package tech4good.tech4good_api.core.application.command.beneficiado;

public record AtualizarBeneficiadoCommand(
        String naturalidade,
        String telefone,
        String estadoCivil,
        String escolaridade,
        String profissao,
        Double rendaMensal,
        String empresa,
        String cargo,
        String religiao,
        Integer quantidadeDependentes,
        Integer enderecoId,
        Integer fotoId
) {}
