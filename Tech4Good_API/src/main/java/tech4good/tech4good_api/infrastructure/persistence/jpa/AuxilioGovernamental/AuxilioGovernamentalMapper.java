package tech4good.tech4good_api.infrastructure.persistence.jpa.AuxilioGovernamental;

import tech4good.tech4good_api.core.application.command.auxiliogovernamental.AtualizarAuxilioGovernamentalCommand;
import tech4good.tech4good_api.core.application.command.auxiliogovernamental.CadastrarAuxilioGovernamentalCommand;
import tech4good.tech4good_api.core.application.dto.auxiliogovernamental.AuxilioGovernamentalAtualizarRequestDto;
import tech4good.tech4good_api.core.application.dto.auxiliogovernamental.AuxilioGovernamentalRequestDto;
import tech4good.tech4good_api.core.application.dto.auxiliogovernamental.AuxilioGovernamentalResponseDto;
import tech4good.tech4good_api.core.domain.auxiliogovernamental.AuxilioGovernamental;
import tech4good.tech4good_api.core.domain.auxiliogovernamental.valueobject.Auxilio;

public class AuxilioGovernamentalMapper {

    public static CadastrarAuxilioGovernamentalCommand toCommand(AuxilioGovernamentalRequestDto dto) {
        return new CadastrarAuxilioGovernamentalCommand(
            Auxilio.valueOf(dto.getTipo())
        );
    }

    public static AtualizarAuxilioGovernamentalCommand toUpdateCommand(AuxilioGovernamentalAtualizarRequestDto dto) {
        return new AtualizarAuxilioGovernamentalCommand(
            Auxilio.valueOf(dto.getTipo())
        );
    }

    public static AuxilioGovernamental toDomain(AuxilioGovernamentalEntity entity) {
        return new AuxilioGovernamental(
            entity.getIdAuxilio(),
            entity.getTipo()
        );
    }

    public static AuxilioGovernamentalEntity toEntity(AuxilioGovernamental domain) {
        return new AuxilioGovernamentalEntity(
            domain.getId(),
            domain.getTipo()
        );
    }

    public static AuxilioGovernamentalResponseDto toResponseDto(AuxilioGovernamental domain) {
        return new AuxilioGovernamentalResponseDto(
            domain.getId(),
            domain.getTipo().getValue()
        );
    }
}
