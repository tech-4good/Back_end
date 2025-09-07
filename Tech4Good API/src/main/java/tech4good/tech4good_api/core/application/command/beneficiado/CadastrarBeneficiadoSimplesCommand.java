package tech4good.tech4good_api.core.application.command.beneficiado;

import java.time.LocalDate;

public record CadastrarBeneficiadoSimplesCommand(
        String cpf,
        String nome,
        LocalDate dataNascimento,
        Integer enderecoId
) {}
