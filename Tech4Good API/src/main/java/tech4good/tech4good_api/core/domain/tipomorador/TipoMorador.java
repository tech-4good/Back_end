package tech4good.tech4good_api.core.domain.tipomorador;

import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;
import tech4good.tech4good_api.core.domain.endereco.Endereco;

public class TipoMorador {
    private Integer id;
    private Integer quantidadeCrianca;
    private Integer quantidadeAdolescente;
    private Integer quantidadeJovem;
    private Integer quantidadeIdoso;
    private Integer quantidadeGestnte;
    private Integer quantidadeDeficiente;
    private Integer quantidadeOutros;
    private Beneficiado beneficiado;
    private Endereco endereco;
}
