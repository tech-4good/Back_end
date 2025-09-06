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
        // Busca endereço por logradouro e número do endereço que vem no command
        Optional<Endereco> enderecoOpt = enderecoGateway.findByLogradouroAndNumero(
            command.endereco().getLogradouro(), 
            command.endereco().getNumero()
        );
        
        Endereco endereco = enderecoOpt.orElseGet(() -> {
            // Se não encontrar, salva o endereço completo que já vem no command
            return enderecoGateway.save(command.endereco());
        });

        // Cria o beneficiado com os dados do command
        Beneficiado beneficiado = new Beneficiado();
        beneficiado.setNome(command.nome());
        beneficiado.setCpf(command.cpf());
        beneficiado.setDataNascimento(command.dataNascimento());
        beneficiado.setEndereco(endereco);

        return beneficiadoGateway.save(beneficiado);
    }
}
