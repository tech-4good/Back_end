package tech4good.tech4good_api.infrastructure.persistence.jpa.BeneficiadoHasAuxilio;

import tech4good.tech4good_api.core.application.command.beneficiadohasauxilio.AtualizarBeneficiadoHasAuxilioCommand;
import tech4good.tech4good_api.core.application.command.beneficiadohasauxilio.CadastrarBeneficiadoHasAuxilioCommand;
import tech4good.tech4good_api.core.application.dto.beneficiadohasauxilio.BeneficiadoHasAuxilioAtualizarRequestDto;
import tech4good.tech4good_api.core.application.dto.beneficiadohasauxilio.BeneficiadoHasAuxilioRequestDto;
import tech4good.tech4good_api.core.application.dto.beneficiadohasauxilio.BeneficiadoHasAuxilioResponseDto;
import tech4good.tech4good_api.core.domain.beneficiadohasauxilio.BeneficiadoHasAuxilio;
import tech4good.tech4good_api.infrastructure.persistence.jpa.AuxilioGovernamental.AuxilioGovernamentalMapper;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Beneficiado.BeneficiadoMapper;

public class BeneficiadoHasAuxilioMapper {

    public static CadastrarBeneficiadoHasAuxilioCommand toCommand(BeneficiadoHasAuxilioRequestDto dto) {
        return new CadastrarBeneficiadoHasAuxilioCommand(
            dto.getBeneficiadoId(),
            dto.getAuxilioGovernamentalId()
        );
    }

    public static AtualizarBeneficiadoHasAuxilioCommand toUpdateCommand(BeneficiadoHasAuxilioAtualizarRequestDto dto) {
        return new AtualizarBeneficiadoHasAuxilioCommand(
            dto.getBeneficiadoId(),
            dto.getAuxilioGovernamentalId()
        );
    }

    public static BeneficiadoHasAuxilio toDomain(BeneficiadoHasAuxilioEntity entity) {
        return new BeneficiadoHasAuxilio(
            entity.getIdBeneficiadoHasAuxilio(),
            AuxilioGovernamentalMapper.toDomain(entity.getAuxilioGovernamental()),
            BeneficiadoMapper.toDomain(entity.getBeneficiado())
        );
    }

    public static BeneficiadoHasAuxilioEntity toEntity(BeneficiadoHasAuxilio domain) {
        return new BeneficiadoHasAuxilioEntity(
            domain.getId(),
            AuxilioGovernamentalMapper.toEntity(domain.getAuxilio()),
            BeneficiadoMapper.toEntity(domain.getBeneficiado())
        );
    }

    public static BeneficiadoHasAuxilioResponseDto toResponseDto(BeneficiadoHasAuxilio domain) {
        return new BeneficiadoHasAuxilioResponseDto(
            domain.getId(),
            BeneficiadoMapper.toResponseDto(domain.getBeneficiado()),
            AuxilioGovernamentalMapper.toResponseDto(domain.getAuxilio())
        );
    }
}
