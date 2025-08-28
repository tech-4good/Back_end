package tech4good.tech4good_api.core.domain.entrega;

import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;
import tech4good.tech4good_api.core.domain.cesta.Cesta;
import tech4good.tech4good_api.core.domain.endereco.Endereco;
import tech4good.tech4good_api.core.voluntario.Voluntario;

import java.time.LocalDate;

public class Entrega {
    private Integer id;
    private LocalDate dataRetirada;
    private LocalDate proximaRetirada;
    private Voluntario voluntario;
    private Endereco endereco;
    private Cesta cesta;
    private Beneficiado beneficiado;
}
