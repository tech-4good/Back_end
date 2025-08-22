package tech4good.tech4good_api.core.domain.cesta;

import tech4good.tech4good_api.core.domain.cesta.valueobject.Peso;
import tech4good.tech4good_api.core.domain.cesta.valueobject.TipoCesta;

import java.time.LocalDate;

public class Cesta {
    private Integer id;
    private TipoCesta tipo;
    private Peso peso;
    private LocalDate dataEntradaEstoque;
    private Integer quantidadeCestas;
}
