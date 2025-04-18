package tech4good.cruds.mapper;

import tech4good.cruds.dto.auxiliogovernamental.AuxilioGovernamentalRequestDto;
import tech4good.cruds.dto.auxiliogovernamental.AuxilioGovernamentalResponseDto;
import tech4good.cruds.entity.AuxilioGovernamental;

public class AuxilioGovernamentalMapper {
    public static AuxilioGovernamental toEntity(AuxilioGovernamentalRequestDto auxilioDto){
        if(auxilioDto == null){
            return null;
        }

        AuxilioGovernamental entity = new AuxilioGovernamental();
        entity.setTipo(auxilioDto.getTipo());
        return entity;
    }

    public static AuxilioGovernamentalResponseDto toResponseDto(AuxilioGovernamental auxilio){
        if(auxilio == null){
            return null;
        }

        AuxilioGovernamentalResponseDto dto = new AuxilioGovernamentalResponseDto(
                auxilio.getIdAuxilio(),
                auxilio.getTipo()
        );
        return dto;
    }
}
