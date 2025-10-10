package tech4good.tech4good_api.core.application.usecase.beneficiado;

import tech4good.tech4good_api.core.adapter.BeneficiadoGateway;
import tech4good.tech4good_api.core.adapter.EnderecoGateway;
import tech4good.tech4good_api.core.adapter.FileGateway;
import tech4good.tech4good_api.core.application.command.beneficiado.CadastrarBeneficiadoSimplesCommand;
import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;
import tech4good.tech4good_api.core.domain.endereco.Endereco;
import tech4good.tech4good_api.core.domain.file.File;
import tech4good.tech4good_api.core.domain.shared.valueobject.Cpf;
import tech4good.tech4good_api.core.application.exception.EntidadeNaoEncontradaException;

import java.util.Optional;

public class CadastrarBeneficiadoSimplesUseCase {
    private final BeneficiadoGateway beneficiadoGateway;
    private final EnderecoGateway enderecoGateway;
    private final FileGateway fileGateway;

    public CadastrarBeneficiadoSimplesUseCase(BeneficiadoGateway beneficiadoGateway, EnderecoGateway enderecoGateway, FileGateway fileGateway) {
        this.beneficiadoGateway = beneficiadoGateway;
        this.enderecoGateway = enderecoGateway;
        this.fileGateway = fileGateway;
    }

    public Beneficiado executar(CadastrarBeneficiadoSimplesCommand command) {
        // Busca o endereço pelo ID fornecido no command
        Optional<Endereco> enderecoOpt = enderecoGateway.findById(command.enderecoId());

        if (enderecoOpt.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Endereço não encontrado com ID: " + command.enderecoId());
        }

        Endereco endereco = enderecoOpt.get();

        // Converte String CPF para value object Cpf
        Cpf cpf = new Cpf(command.cpf());

        // Cria o beneficiado com os dados do command
        Beneficiado beneficiado = new Beneficiado();
        beneficiado.setNome(command.nome());
        beneficiado.setCpf(cpf);
        beneficiado.setDataNascimento(command.dataNascimento());
        beneficiado.setEndereco(endereco);

        // Se tiver fotoId, busca a foto e associa ao beneficiado
        if (command.fotoId() != null) {
            File foto = fileGateway.loadEntity(command.fotoId());
            if (foto == null) {
                throw new EntidadeNaoEncontradaException("Foto não encontrada com ID: " + command.fotoId());
            }
            beneficiado.setFotoBeneficiado(foto);
        }

        return beneficiadoGateway.save(beneficiado);
    }
}
