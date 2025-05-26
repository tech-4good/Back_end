package tech4good.cruds.mapper;

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

        EnderecoSummarizedResponseDto enderecoBeneficiadoResponseDto = filaEspera.getEndereco() != null
                ? new EnderecoSummarizedResponseDto(
                filaEspera.getEndereco().getLogradouro(),
                filaEspera.getEndereco().getNumero(),
                filaEspera.getEndereco().getComplemento(),
                filaEspera.getEndereco().getBairro(),
                filaEspera.getEndereco().getCidade(),
                filaEspera.getEndereco().getEstado(),
                filaEspera.getEndereco().getCep(),
                filaEspera.getEndereco().getTipoCesta(),
                filaEspera.getEndereco().getDataEntrada(),
                filaEspera.getEndereco().getDataSaida(),
                filaEspera.getEndereco().getMoradia(),
                filaEspera.getEndereco().getTipoMoradia(),
                filaEspera.getEndereco().getStatus()
        ): null;

        FilaEsperaResponseDto responseDto = new FilaEsperaResponseDto(
                filaEspera.getIdFila(),
                filaEspera.getDataEntradaFila(),
                filaEspera.getDataSaidaFila(),
                enderecoBeneficiadoResponseDto
        );
        return responseDto;
    }
}
