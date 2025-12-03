package tech4good.tech4good_api.core.application.usecase.endereco;

import tech4good.tech4good_api.core.adapter.EnderecoGateway;
import tech4good.tech4good_api.core.application.command.endereco.AtualizarEnderecoDadosCommand;
import tech4good.tech4good_api.core.application.exception.EntidadeNaoEncontradaException;
import tech4good.tech4good_api.core.domain.endereco.Endereco;
import tech4good.tech4good_api.core.domain.endereco.valueobjects.*;

public class AtualizarEnderecoDadosUseCase {

    private final EnderecoGateway gateway;

    public AtualizarEnderecoDadosUseCase(EnderecoGateway gateway) {
        this.gateway = gateway;
    }

    public Endereco executar(AtualizarEnderecoDadosCommand command) {
        // Buscar endereço existente
        Endereco enderecoExistente = gateway.findById(command.id())
            .orElseThrow(() -> new EntidadeNaoEncontradaException(
                "Endereço de id %d não encontrado".formatted(command.id())
            ));

        // Atualizar apenas os campos que foram enviados (não nulos)
        if (command.logradouro() != null && !command.logradouro().trim().isEmpty()) {
            enderecoExistente.setLogradouro(command.logradouro());
        }

        if (command.numero() != null && !command.numero().trim().isEmpty()) {
            enderecoExistente.setNumero(command.numero());
        }

        if (command.complemento() != null) {
            enderecoExistente.setComplemento(command.complemento());
        }

        if (command.bairro() != null && !command.bairro().trim().isEmpty()) {
            enderecoExistente.setBairro(Bairro.of(command.bairro()));
        }

        if (command.cidade() != null && !command.cidade().trim().isEmpty()) {
            enderecoExistente.setCidade(Cidade.of(command.cidade()));
        }

        if (command.estado() != null && !command.estado().trim().isEmpty()) {
            enderecoExistente.setEstado(Estado.valueOf(command.estado()));
        }

        if (command.cep() != null && !command.cep().trim().isEmpty()) {
            enderecoExistente.setCep(Cep.valueOf(command.cep()));
        }

        if (command.moradia() != null && !command.moradia().trim().isEmpty()) {
            enderecoExistente.setMoradia(command.moradia());
        }

        if (command.tipoMoradia() != null && !command.tipoMoradia().trim().isEmpty()) {
            enderecoExistente.setTipoMoradia(TipoMoradia.of(command.tipoMoradia()));
        }

        // Salvar e retornar
        return gateway.save(enderecoExistente);
    }
}

