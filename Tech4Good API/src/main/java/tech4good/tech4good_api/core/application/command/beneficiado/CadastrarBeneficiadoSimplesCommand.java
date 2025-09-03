package tech4good.tech4good_api.core.application.command.beneficiado;

import tech4good.tech4good_api.core.domain.endereco.Endereco;
import tech4good.tech4good_api.core.domain.shared.valueobject.Cpf;

import java.time.LocalDate;

public record CadastrarBeneficiadoSimplesCommand(
        Cpf cpf,
        String nome,
        LocalDate dataNascimento,
        Endereco endereco
) {}
