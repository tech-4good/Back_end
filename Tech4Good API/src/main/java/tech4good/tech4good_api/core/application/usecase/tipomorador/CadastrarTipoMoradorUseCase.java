package tech4good.tech4good_api.core.application.usecase.tipomorador;

import tech4good.tech4good_api.core.adapter.BeneficiadoGateway;
import tech4good.tech4good_api.core.adapter.EnderecoGateway;
import tech4good.tech4good_api.core.adapter.TipoMoradorGateway;

public class CadastrarTipoMoradorUseCase {

    private final TipoMoradorGateway gateway;
    private final EnderecoGateway enderecoGateway;
    private final BeneficiadoGateway beneficiadoGateway;


    public CadastrarTipoMoradorUseCase(TipoMoradorGateway gateway, EnderecoGateway enderecoGateway, BeneficiadoGateway beneficiadoGateway) {
        this.gateway = gateway;
        this.enderecoGateway = enderecoGateway;
        this.beneficiadoGateway = beneficiadoGateway;
    }
}
