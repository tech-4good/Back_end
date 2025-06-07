package tech4good.cruds.mapper;

import tech4good.cruds.dto.auxiliares.BeneficiadoSummarizedResponseDto;
import tech4good.cruds.dto.auxiliares.EnderecoSummarizedResponseDto;
import tech4good.cruds.dto.fila.FilaEsperaRequestDto;
import tech4good.cruds.dto.fila.FilaEsperaResponseDto;
import tech4good.cruds.entity.FilaEspera;

public class FilaEsperaMapper {

    public static FilaEspera toEntity(FilaEsperaRequestDto requestDto) {
        if (requestDto == null){
            return null;
        }

        FilaEspera filaEspera = new FilaEspera();
        filaEspera.setDataEntradaFila(requestDto.getDataEntradaFila());
        return filaEspera;
    }

    public static FilaEsperaResponseDto toResponseDto(FilaEspera filaEspera) {
        if (filaEspera == null){
            return null;
        }

        BeneficiadoSummarizedResponseDto beneficiadoResponseDto = filaEspera.getBeneficiado() != null
                ? new BeneficiadoSummarizedResponseDto(
                filaEspera.getBeneficiado().getCpf(),
                filaEspera.getBeneficiado().getNome()
        ): null;

        FilaEsperaResponseDto responseDto = new FilaEsperaResponseDto(
                filaEspera.getIdFila(),
                filaEspera.getDataEntradaFila(),
                filaEspera.getDataSaidaFila(),
                beneficiadoResponseDto
        );
        return responseDto;
    }
}
