package tech4good.tech4good_api.core.application.usecase.beneficiado;

import tech4good.tech4good_api.core.adapter.BeneficiadoGateway;
import tech4good.tech4good_api.core.adapter.EnderecoGateway;
import tech4good.tech4good_api.core.adapter.FileGateway;
import tech4good.tech4good_api.core.application.command.beneficiado.AtualizarBeneficiadoCommand;
import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;
import tech4good.tech4good_api.core.domain.beneficiado.valueobject.EstadoCivil;
import tech4good.tech4good_api.core.domain.beneficiado.valueobject.Religiao;
import tech4good.tech4good_api.core.domain.beneficiado.valueobject.Renda;
import tech4good.tech4good_api.core.domain.endereco.Endereco;
import tech4good.tech4good_api.core.domain.file.File;
import tech4good.tech4good_api.core.domain.shared.valueobject.Telefone;
import tech4good.tech4good_api.core.application.exception.EntidadeNaoEncontradaException;

import java.util.Optional;

public class AtualizarBeneficiadoUseCase {
    private final BeneficiadoGateway beneficiadoGateway;
    private final EnderecoGateway enderecoGateway;
    private final FileGateway fileGateway;

    public AtualizarBeneficiadoUseCase(BeneficiadoGateway beneficiadoGateway, EnderecoGateway enderecoGateway, FileGateway fileGateway) {
        this.beneficiadoGateway = beneficiadoGateway;
        this.enderecoGateway = enderecoGateway;
        this.fileGateway = fileGateway;
    }

    public Beneficiado executar(Integer id, AtualizarBeneficiadoCommand command) {

        if (!beneficiadoGateway.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Beneficiado não encontrado com ID: " + id);
        }

        Beneficiado beneficiadoExistente = beneficiadoGateway.findById(id);

        // Busca o endereço pelo ID se fornecido
        Endereco endereco = beneficiadoExistente.getEndereco(); // mantém o endereço atual por padrão
        if (command.enderecoId() != null) {
            Optional<Endereco> enderecoOpt = enderecoGateway.findById(command.enderecoId());
            if (enderecoOpt.isEmpty()) {
                throw new EntidadeNaoEncontradaException("Endereço não encontrado com ID: " + command.enderecoId());
            }
            endereco = enderecoOpt.get();
        }

        // Busca a foto pelo ID se fornecido
        File foto = beneficiadoExistente.getFotoBeneficiado(); // mantém a foto atual por padrão
        if (command.fotoId() != null) {
            foto = fileGateway.loadEntity(command.fotoId());
            if (foto == null) {
                throw new EntidadeNaoEncontradaException("Foto não encontrada com ID: " + command.fotoId());
            }
        }

        // Converte telefone de String para Telefone se fornecido
        Telefone telefone = beneficiadoExistente.getTelefone(); // mantém o telefone atual por padrão
        if (command.telefone() != null && !command.telefone().isBlank()) {
            telefone = new Telefone(command.telefone());
        }

        // Converte estado civil de String para EstadoCivil se fornecido
        EstadoCivil estadoCivil = beneficiadoExistente.getEstadoCivil(); // mantém o estado civil atual por padrão
        if (command.estadoCivil() != null && !command.estadoCivil().isBlank()) {
            estadoCivil = EstadoCivil.valueOf(command.estadoCivil());
        }

        // Converte renda de Double para Renda se fornecido
        Renda rendaMensal = beneficiadoExistente.getRendaMensal(); // mantém a renda mensal atual por padrão
        if (command.rendaMensal() != null) {
            rendaMensal = new Renda(command.rendaMensal());
        }

        // Converte religião de String para Religiao se fornecido
        Religiao religiao = beneficiadoExistente.getReligiao(); // mantém a religião atual por padrão
        if (command.religiao() != null && !command.religiao().isBlank()) {
            religiao = Religiao.valueOf(command.religiao());
        }

        Beneficiado beneficiadoAtualizado = new Beneficiado(
                beneficiadoExistente.getId(),
                beneficiadoExistente.getCpf(),
                beneficiadoExistente.getNome(),
                beneficiadoExistente.getRg(),
                beneficiadoExistente.getDataNascimento(),
                command.naturalidade(),
                telefone,
                estadoCivil,
                command.escolaridade(),
                command.profissao(),
                rendaMensal,
                command.empresa(),
                command.cargo(),
                religiao,
                endereco,
                command.quantidadeDependentes(),
                foto
        );

        return beneficiadoGateway.save(beneficiadoAtualizado);
    }
}