package tech4good.tech4good_api.core.domain.filaespera;

import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;

import java.time.LocalDate;

public class FilaEspera {
    private Integer id;
    private LocalDate dataEntradaFila;
    private LocalDate dataSaidaFila;
    private Beneficiado beneficiado;
}
