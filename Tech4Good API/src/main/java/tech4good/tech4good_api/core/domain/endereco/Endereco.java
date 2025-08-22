package tech4good.tech4good_api.core.domain.endereco;

import tech4good.tech4good_api.core.domain.cesta.valueobject.TipoCesta;
import tech4good.tech4good_api.core.domain.endereco.valueobjects.*;

import java.time.LocalDate;

public class Endereco {
    private Integer id;
    private String logradouro;
    private String numero;
    private String complemento;
    private Bairro bairro;
    private Cidade cidade;
    private Estado estado;
    private Cep cep;
    private TipoCesta tipoCesta;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private String moradia;
    private TipoMoradia tipoMoradia;
    private Status status;
}
