package tech4good.cruds.mapper;

import tech4good.cruds.dto.cesta.CestaRequestDto;
import tech4good.cruds.dto.cesta.CestaResponseDto;
import tech4good.cruds.dto.cesta.CestaUpdateDto;
import tech4good.cruds.entity.Cesta;

public class CestaMapper {
    public static Cesta toEntity(CestaRequestDto requestDto) {
        if (requestDto == null){
            return null;
        }

        Cesta cesta = new Cesta();
        cesta.setTipo(requestDto.getTipo());
        cesta.setPesoKg(requestDto.getPesoKg());
        cesta.setDataEntradaEstoque(requestDto.getDataEntradaEstoque());
        cesta.setQuantidadeCestas(requestDto.getQuantidadeCestas());

        return cesta;
    }

    public static CestaResponseDto toResponseDto(Cesta cesta) {
        if (cesta == null){
            return null;
        }

        CestaResponseDto responseDto = new CestaResponseDto(
                cesta.getIdCesta(),
                cesta.getTipo(),
                cesta.getDataEntradaEstoque(),
                cesta.getQuantidadeCestas()
        );
        return responseDto;
    }

    public static Cesta toUpdate(CestaUpdateDto dto, Integer idCesta){
        if (dto == null){
            return null;
        }

        Cesta cesta = new Cesta();
        cesta.setIdCesta(idCesta);
        cesta.setQuantidadeCestas(dto.getQuantidadeCestas());
        return cesta;
    }
}
