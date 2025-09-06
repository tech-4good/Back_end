package tech4good.tech4good_api.core.application.command.filaespera;

import java.time.LocalDate;
import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;

public record CadastrarFilaEsperaCommand(LocalDate dataEntradaFila, Beneficiado beneficiado) {}
