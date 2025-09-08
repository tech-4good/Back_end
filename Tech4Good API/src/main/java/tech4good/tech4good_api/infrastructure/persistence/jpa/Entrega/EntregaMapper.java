package tech4good.tech4good_api.infrastructure.persistence.jpa.Entrega;

import tech4good.tech4good_api.core.application.command.entrega.*;
import tech4good.tech4good_api.core.application.dto.entrega.EntregaRequestDto;
import tech4good.tech4good_api.core.application.dto.entrega.EntregaResponseDto;
import tech4good.tech4good_api.core.application.dto.entrega.EntregaUpdateDto;
import tech4good.tech4good_api.core.application.dto.entrega.EntregaUpdateResponseDto;
import tech4good.tech4good_api.core.domain.entrega.Entrega;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Beneficiado.BeneficiadoMapper;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Cesta.CestaMapper;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco.EnderecoMapper;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Voluntario.VoluntarioMapper;

import java.time.LocalDate;

public class EntregaMapper {

    public static CadastrarEntregaCommand toCommand(EntregaRequestDto dto) {
        return new CadastrarEntregaCommand(
            dto.getDataRetirada(),
            dto.getProximaRetirada(),
            dto.getEnderecoId(),
            dto.getCestaId(),
            dto.getVoluntarioId(),
            dto.getBeneficiadoId()
        );
    }

    public static BuscarEntregaPorIdCommand toIdCommand(Integer id) {
        return new BuscarEntregaPorIdCommand(id);
    }

    public static AtualizarEntregaCommand toUpdateCommand(EntregaUpdateDto dto) {
        return new AtualizarEntregaCommand(
            dto.getDataRetirada(),
            dto.getProximaRetirada()
        );
    }

    public static RemoverEntregaPorIdCommand toRemoveCommand(Integer id) {
        return new RemoverEntregaPorIdCommand(id);
    }

    public static ListarHistoricoEntregasCommand toHistoricoCommand(Integer idBeneficiado, LocalDate dataInicio, LocalDate dataFim) {
        return new ListarHistoricoEntregasCommand(idBeneficiado, dataInicio, dataFim);
    }

    public static Entrega toDomain(EntregaEntity entity) {
        return new Entrega(
            entity.getIdEntrega(),
            entity.getDataRetirada(),
            entity.getProximaRetirada(),
            VoluntarioMapper.toDomainFromEntity(entity.getVoluntario()),
            EnderecoMapper.toDomainFromEntity(entity.getEndereco()),
            CestaMapper.toDomainFromEntity(entity.getCesta()),
            BeneficiadoMapper.toDomain(entity.getBeneficiado())
        );
    }

    public static EntregaEntity toEntity(Entrega domain) {
        return new EntregaEntity(
            domain.getId(),
            domain.getDataRetirada(),
            domain.getProximaRetirada(),
            EnderecoMapper.toEntity(domain.getEndereco()),
            CestaMapper.toEntity(domain.getCesta()),
            VoluntarioMapper.toEntity(domain.getVoluntario()),
            BeneficiadoMapper.toEntity(domain.getBeneficiado())
        );
    }

    public static EntregaResponseDto toResponseDto(Entrega domain) {
        return new EntregaResponseDto(
            domain.getId(),
            domain.getDataRetirada(),
            domain.getProximaRetirada(),
            EnderecoMapper.toSummarizedDto(domain.getEndereco()),
            CestaMapper.toResponseDto(domain.getCesta()),
            VoluntarioMapper.toResponseDto(domain.getVoluntario()),
            BeneficiadoMapper.toSummarizedDto(domain.getBeneficiado())
        );
    }

    public static EntregaUpdateResponseDto toUpdateResponseDto(Entrega domain) {
        return new EntregaUpdateResponseDto(
            domain.getId(),
            domain.getDataRetirada(),
            domain.getProximaRetirada()
        );
    }
}
