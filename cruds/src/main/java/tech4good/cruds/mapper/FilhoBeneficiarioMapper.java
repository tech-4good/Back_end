package tech4good.cruds.mapper;

import tech4good.cruds.dto.auxiliares.BeneficiadoSummarizedResponseDto;
import tech4good.cruds.dto.auxiliares.EnderecoSummarizedFilhoBeneficiadoResponseDto;
import tech4good.cruds.dto.filho.FilhoBeneficiadoRequestDto;
import tech4good.cruds.dto.filho.FilhoBeneficiadoResponseDto;
import tech4good.cruds.dto.filho.FilhoBeneficiadoUpdateDto;
import tech4good.cruds.entity.FilhoBeneficiado;

public class FilhoBeneficiarioMapper {
    public static FilhoBeneficiado toEntity(FilhoBeneficiadoRequestDto responseDto){
        if(responseDto == null){
            return null;
        }

        FilhoBeneficiado filhoBeneficiado = new FilhoBeneficiado();
        filhoBeneficiado.setDataNascimento(responseDto.getDataNascimento());
        filhoBeneficiado.setIsEstudante(responseDto.getIsEstudante());
        filhoBeneficiado.setHasCreche(responseDto.getHasCreche());

        return filhoBeneficiado;
    }

    public static FilhoBeneficiadoResponseDto toResponseDto(FilhoBeneficiado filhoBeneficiado){

        if(filhoBeneficiado == null){
            return null;
        }

        EnderecoSummarizedFilhoBeneficiadoResponseDto filhoBeneficiadoEnderecoResponseDto = filhoBeneficiado.getEndereco() != null
                ? new EnderecoSummarizedFilhoBeneficiadoResponseDto(
                        filhoBeneficiado.getEndereco().getIdEndereco(),
                        filhoBeneficiado.getEndereco().getLogradouro(),
                        filhoBeneficiado.getEndereco().getNumero(),
                        filhoBeneficiado.getEndereco().getComplemento(),
                        filhoBeneficiado.getEndereco().getBairro(),
                        filhoBeneficiado.getEndereco().getCidade(),
                        filhoBeneficiado.getEndereco().getEstado(),
                        filhoBeneficiado.getEndereco().getCep()
        ) : null;


        BeneficiadoSummarizedResponseDto filhoBeneficiadoBeneficiadoResponseDto = filhoBeneficiado.getBeneficiado() != null
                ? new BeneficiadoSummarizedResponseDto(
                        filhoBeneficiado.getBeneficiado().getCpf(),
                        filhoBeneficiado.getBeneficiado().getNome()
        ) : null;

        return new FilhoBeneficiadoResponseDto(
                filhoBeneficiado.getIdFilhoBeneficiado(),
                filhoBeneficiado.getDataNascimento(),
                filhoBeneficiado.getIsEstudante(),
                filhoBeneficiado.getHasCreche(),
                filhoBeneficiadoEnderecoResponseDto,
                filhoBeneficiadoBeneficiadoResponseDto);
    }

    public static FilhoBeneficiado toUpdate(FilhoBeneficiadoUpdateDto dto, Integer idFilhoBeneficiado){
        if(dto == null){
            return null;
        }

        FilhoBeneficiado filhoBeneficiado = new FilhoBeneficiado();
        filhoBeneficiado.setIdFilhoBeneficiado(idFilhoBeneficiado);
        filhoBeneficiado.setIsEstudante(dto.getIsEstudante());
        filhoBeneficiado.setHasCreche(dto.getHasCreche());

        return filhoBeneficiado;
    }
}
