package tech4good.tech4good_api.core.application.usecase.tipomorador;

import tech4good.tech4good_api.core.adapter.BeneficiadoGateway;
import tech4good.tech4good_api.core.adapter.EnderecoGateway;
import tech4good.tech4good_api.core.adapter.TipoMoradorGateway;
import tech4good.tech4good_api.core.application.command.tipomorador.CadastrarTipoMoradorCommand;
import tech4good.tech4good_api.core.application.exception.EntidadeNaoEncontradaException;
import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;
import tech4good.tech4good_api.core.domain.endereco.Endereco;
import tech4good.tech4good_api.core.domain.tipomorador.TipoMorador;

public class CadastrarTipoMoradorUseCase {

    private final TipoMoradorGateway gateway;
    private final EnderecoGateway enderecoGateway;
    private final BeneficiadoGateway beneficiadoGateway;

    public CadastrarTipoMoradorUseCase(TipoMoradorGateway gateway, EnderecoGateway enderecoGateway, BeneficiadoGateway beneficiadoGateway) {
        this.gateway = gateway;
        this.enderecoGateway = enderecoGateway;
        this.beneficiadoGateway = beneficiadoGateway;
    }

    public TipoMorador execute(CadastrarTipoMoradorCommand command) {
        // Buscar endereco (retorna Optional)
        Endereco endereco = enderecoGateway.findById(command.enderecoId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Endereco de id %d nao encontrado".formatted(command.enderecoId())));

        // Buscar beneficiado (retorna objeto diretamente ou null)
        Beneficiado beneficiado = beneficiadoGateway.findById(command.beneficiadoId());
        if (beneficiado == null) {
            throw new EntidadeNaoEncontradaException("Beneficiado de id %d nao encontrado".formatted(command.beneficiadoId()));
        }

        // Criar o TipoMorador diretamente com os objetos relacionados válidos
        TipoMorador tipoMorador = new TipoMorador(
                null, // id será gerado pelo banco
                command.quantidadeCrianca(),
                command.quantidadeAdolescente(),
                command.quantidadeJovem(),
                command.quantidadeIdoso(),
                command.quantidadeGestante(),
                command.quantidadeDeficiente(),
                command.quantidadeOutros(),
                beneficiado,
                endereco
        );

        return gateway.save(tipoMorador);
    }
}
