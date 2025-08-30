package tech4good.tech4good_api.core.application.usecase.beneficiado;

import tech4good.tech4good_api.core.adapter.BeneficiadoGateway;
import tech4good.tech4good_api.core.adapter.EnderecoGateway;
import tech4good.tech4good_api.core.application.command.beneficiado.CadastrarBeneficiadoSimplesCommand;
import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;
import tech4good.tech4good_api.core.domain.endereco.Endereco;
import tech4good.tech4good_api.core.application.exception.EntidadeNaoEncontradaException;

import java.util.Optional;

public class CadastrarBeneficiadoSimplesUseCase {
    private final BeneficiadoGateway beneficiadoGateway;
    private final EnderecoGateway enderecoGateway;

    public CadastrarBeneficiadoSimplesUseCase(BeneficiadoGateway beneficiadoGateway, EnderecoGateway enderecoGateway) {
        this.beneficiadoGateway = beneficiadoGateway;
        this.enderecoGateway = enderecoGateway;
    }

    public Beneficiado executar(CadastrarBeneficiadoSimplesCommand command) {
        // Busca endereço por logradouro e número
        Optional<Endereco> enderecoOpt = enderecoGateway.findByLogradouroAndNumero(command.logradouro(), command.numero());
        Endereco endereco = enderecoOpt.orElseGet(() -> {
            Endereco novoEndereco = new Endereco();
            novoEndereco.setLogradouro(command.logradouro());
            novoEndereco.setNumero(command.numero());
            novoEndereco.setComplemento(command.complemento());
            novoEndereco.setBairro(command.bairro());
            novoEndereco.setCidade(command.cidade());
            novoEndereco.setEstado(command.estado());
            novoEndereco.setCep(command.cep());
            novoEndereco.setTipoCesta(command.tipoCesta());
            novoEndereco.setDataEntrada(command.dataEntrada());
            novoEndereco.setDataSaida(command.dataSaida());
            novoEndereco.setMoradia(command.moradia());
            novoEndereco.setTipoMoradia(command.tipoMoradia());
            novoEndereco.setStatus(command.status());
            return enderecoGateway.save(novoEndereco);
        });
        Beneficiado beneficiado = new Beneficiado();
        beneficiado.setNome(command.nome());
        beneficiado.setCpf(command.cpf());
        beneficiado.setDataNascimento(command.dataNascimento());
        beneficiado.setEndereco(endereco);
        return beneficiadoGateway.save(beneficiado);
    }
}

