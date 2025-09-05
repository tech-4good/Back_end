package tech4good.tech4good_api.infrastructure.persistence.jpa.FilhoBeneficiado;

import tech4good.tech4good_api.core.application.command.filhobeneficiado.AtualizarFilhoBeneficiadoCommand;
import tech4good.tech4good_api.core.application.command.filhobeneficiado.CriarFilhoBeneficiadoCommand;
import tech4good.tech4good_api.core.application.dto.filhobeneficiado.FilhoBeneficiadoAtualizarRequestDto;
import tech4good.tech4good_api.core.application.dto.filhobeneficiado.FilhoBeneficiadoRequestDto;
import tech4good.tech4good_api.core.application.dto.filhobeneficiado.FilhoBeneficiadoResponseDto;
import tech4good.tech4good_api.core.domain.filhobeneficiado.FilhoBeneficiado;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Beneficiado.BeneficiadoEntity;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Beneficiado.BeneficiadoMapper;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco.EnderecoEntity;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco.EnderecoMapper;

public class FilhoBeneficiadoMapper {

    public static CriarFilhoBeneficiadoCommand toCommand(FilhoBeneficiadoRequestDto dto) {
        return new CriarFilhoBeneficiadoCommand(
                dto.getDataNascimento(),
                dto.getIsEstudante(),
                dto.getHasCreche(),
                dto.getBeneficiadoId(),
                dto.getEnderecoId()
        );
    }

    public static AtualizarFilhoBeneficiadoCommand toCommand(FilhoBeneficiadoAtualizarRequestDto dto, Integer id) {
        return new AtualizarFilhoBeneficiadoCommand(
                id,
                dto.getIsEstudante(),
                dto.getHasCreche()
        );
    }

    public static FilhoBeneficiado toDomain(FilhoBeneficiadoEntity entity) {
        return new FilhoBeneficiado(
                entity.getId(),
                entity.getDataNascimento(),
                entity.getIsEstudante(),
                entity.getHasCreche(),
                BeneficiadoMapper.toDomain(entity.getBeneficiado()),
                EnderecoMapper.toDomainFromEntity(entity.getEndereco())
        );
    }

    public static FilhoBeneficiadoEntity toEntity(FilhoBeneficiado domain, BeneficiadoEntity beneficiado, EnderecoEntity endereco) {
        return new FilhoBeneficiadoEntity(
                domain.getId(),
                domain.getDataNascimento(),
                domain.getEstudante(),
                domain.getHasCreche(),
                beneficiado,
                endereco
        );
    }

    public static FilhoBeneficiadoResponseDto toResponseDto(FilhoBeneficiado domain) {
        return new FilhoBeneficiadoResponseDto(
                domain.getId(),
                domain.getDataNascimento(),
                domain.getEstudante(),
                domain.getHasCreche(),
                EnderecoMapper.toSummarizedResponseDto(domain.getEndereco()),
                BeneficiadoMapper.toSummarizedResponseDto(domain.getBeneficiado())
        );
    }
}
