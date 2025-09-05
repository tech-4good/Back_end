package tech4good.tech4good_api.infrastructure.persistence.jpa.Beneficiado;

import tech4good.tech4good_api.core.application.command.beneficiado.AtualizarBeneficiadoCommand;
import tech4good.tech4good_api.core.application.command.beneficiado.CadastrarBeneficiadoCommand;
import tech4good.tech4good_api.core.application.command.beneficiado.CadastrarBeneficiadoSimplesCommand;
import tech4good.tech4good_api.core.application.dto.beneficiado.BeneficiadoAtualizarRequestDto;
import tech4good.tech4good_api.core.application.dto.beneficiado.BeneficiadoRequestDto;
import tech4good.tech4good_api.core.application.dto.beneficiado.BeneficiadoResponseDto;
import tech4good.tech4good_api.core.application.dto.beneficiado.BeneficiadoSimplesRequestDto;
import tech4good.tech4good_api.core.application.dto.auxiliares.BeneficiadoSummarizedResponseDto;
import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;
import tech4good.tech4good_api.core.domain.beneficiado.valueobject.Religiao;
import tech4good.tech4good_api.core.domain.beneficiado.valueobject.Renda;
import tech4good.tech4good_api.core.domain.beneficiado.valueobject.Rg;
import tech4good.tech4good_api.core.domain.shared.valueobject.Cpf;
import tech4good.tech4good_api.core.domain.shared.valueobject.Telefone;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco.EnderecoMapper;
import tech4good.tech4good_api.infrastructure.persistence.jpa.File.FileMapper;

public class BeneficiadoMapper {
    public static CadastrarBeneficiadoCommand toCommand(BeneficiadoRequestDto dto) {
        return new CadastrarBeneficiadoCommand(
                dto.getCpf(),
                dto.getNome(),
                dto.getRg(),
                dto.getDataNascimento(),
                dto.getNaturalidade(),
                dto.getTelefone(),
                dto.getEstadoCivil(),
                dto.getEscolaridade(),
                dto.getProfissao(),
                dto.getRendaMensal(),
                dto.getEmpresa(),
                dto.getCargo(),
                dto.getReligiao(),
                dto.getEndereco(),
                dto.getQuantidadeDependentes()
        );
    }

    public static Beneficiado toDomain(CadastrarBeneficiadoCommand command) {
        return new Beneficiado(
                null,
                command.cpf(),
                command.nome(),
                command.rg(),
                command.dataNascimento(),
                command.naturalidade(),
                command.telefone(),
                command.estadoCivil(),
                command.escolaridade(),
                command.profissao(),
                command.rendaMensal(),
                command.empresa(),
                command.cargo(),
                command.religiao(),
                command.endereco(),
                command.quantidadeDependentes(),
                null
        );
    }

    public static BeneficiadoEntity toEntity(Beneficiado beneficiado) {
        BeneficiadoEntity entity = new BeneficiadoEntity();
        entity.setId(beneficiado.getId());
        entity.setCpf(beneficiado.getCpf() != null ? beneficiado.getCpf().toString() : null);
        entity.setNome(beneficiado.getNome());
        entity.setRg(beneficiado.getRg() != null ? beneficiado.getRg().toString() : null);
        entity.setDataNascimento(beneficiado.getDataNascimento());
        entity.setNaturalidade(beneficiado.getNaturalidade());
        entity.setTelefone(beneficiado.getTelefone() != null ? beneficiado.getTelefone().toString() : null);
        entity.setEstadoCivil(beneficiado.getEstadoCivil());
        entity.setEscolaridade(beneficiado.getEscolaridade());
        entity.setProfissao(beneficiado.getProfissao());
        entity.setRendaMensal(beneficiado.getRendaMensal() != null ? beneficiado.getRendaMensal().getValue() : null);
        entity.setEmpresa(beneficiado.getEmpresa());
        entity.setCargo(beneficiado.getCargo());
        entity.setReligiao(beneficiado.getReligiao() != null ? beneficiado.getReligiao().toString() : null);
        // Converte o objeto de domínio Endereco para EnderecoEntity
        entity.setEndereco(beneficiado.getEndereco() != null ?
            EnderecoMapper.toEntity(beneficiado.getEndereco()) : null);
        entity.setQuantidadeDependentes(beneficiado.getQuantidadeDependentes());
        // Converte o objeto de domínio File para FileEntity
        entity.setFotoBeneficiado(beneficiado.getFotoBeneficiado() != null ?
            FileMapper.toEntity(beneficiado.getFotoBeneficiado()) : null);
        return entity;
    }

    public static Beneficiado toDomain(BeneficiadoEntity entity) {
        return new Beneficiado(
                entity.getId(),
                entity.getCpf() != null ? new Cpf(entity.getCpf()) : null,
                entity.getNome(),
                entity.getRg() != null ? new Rg(entity.getRg()) : null,
                entity.getDataNascimento(),
                entity.getNaturalidade(),
                entity.getTelefone() != null ? new Telefone(entity.getTelefone()) : null,
                entity.getEstadoCivil(),
                entity.getEscolaridade(),
                entity.getProfissao(),
                entity.getRendaMensal() != null ? new Renda(entity.getRendaMensal()) : null,
                entity.getEmpresa(),
                entity.getCargo(),
                entity.getReligiao() != null ? Religiao.valueOf(entity.getReligiao()) : null,
                // Converte EnderecoEntity para objeto de domínio Endereco
                entity.getEndereco() != null ?
                        EnderecoMapper.toDomainFromEntity(entity.getEndereco()) : null,
                entity.getQuantidadeDependentes(),
                // Converte FileEntity para objeto de domínio File
                entity.getFotoBeneficiado() != null ?
                        FileMapper.toDomain(entity.getFotoBeneficiado()) : null
        );
    }

    public static BeneficiadoResponseDto toResponseDto(Beneficiado beneficiado) {
        return new BeneficiadoResponseDto(
                beneficiado.getId(),
                beneficiado.getCpf(),
                beneficiado.getNome(),
                beneficiado.getRg(),
                beneficiado.getDataNascimento(),
                beneficiado.getNaturalidade(),
                beneficiado.getTelefone(),
                beneficiado.getEstadoCivil(),
                beneficiado.getEscolaridade(),
                beneficiado.getProfissao(),
                beneficiado.getRendaMensal(),
                beneficiado.getEmpresa(),
                beneficiado.getCargo(),
                beneficiado.getReligiao(),
                beneficiado.getEndereco(),
                beneficiado.getQuantidadeDependentes(),
                beneficiado.getFotoBeneficiado()
        );
    }

    public static AtualizarBeneficiadoCommand toCommand(BeneficiadoAtualizarRequestDto dto) {
        return new AtualizarBeneficiadoCommand(
            dto.getNaturalidade(),
            dto.getTelefone(),
            dto.getEstadoCivil(),
            dto.getEscolaridade(),
            dto.getProfissao(),
            dto.getRendaMensal(),
            dto.getEmpresa(),
            dto.getCargo(),
            dto.getReligiao(),
            dto.quantidadeDependentes(),
            dto.getEndereco()
        );
    }

    public static CadastrarBeneficiadoSimplesCommand toCommand(BeneficiadoSimplesRequestDto dto) {
        return new CadastrarBeneficiadoSimplesCommand(
            dto.getCpf(),
            dto.getNome(),
            dto.getDataNascimento(),
            dto.getEndereco()
        );
    }

    public static BeneficiadoSummarizedResponseDto toSummarizedResponseDto(Beneficiado beneficiado) {
        if (beneficiado == null) {
            return null;
        }
        return new BeneficiadoSummarizedResponseDto(
            beneficiado.getCpf(),
            beneficiado.getNome()
        );
    }
}
