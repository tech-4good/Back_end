package tech4good.cruds.mapper;

import tech4good.cruds.dto.auxiliares.FilhoBeneficiadoBeneficiadoResponseDto;
import tech4good.cruds.dto.auxiliares.FilhoBeneficiadoEnderecoResponseDto;
import tech4good.cruds.dto.filho.FilhoBeneficiadoRequestDto;
import tech4good.cruds.dto.filho.FilhoBeneficiadoResponseDto;
import tech4good.cruds.entity.BeneficiadoId;
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

        FilhoBeneficiadoEnderecoResponseDto filhoBeneficiadoEnderecoResponseDto = filhoBeneficiado.getEndereco() != null
                ? new FilhoBeneficiadoEnderecoResponseDto(
                        filhoBeneficiado.getEndereco().getIdEndereco(),
                        filhoBeneficiado.getEndereco().getLogradouro(),
                        filhoBeneficiado.getEndereco().getNumero(),
                        filhoBeneficiado.getEndereco().getComplemento(),
                        filhoBeneficiado.getEndereco().getBairro(),
                        filhoBeneficiado.getEndereco().getCidade(),
                        filhoBeneficiado.getEndereco().getEstado(),
                        filhoBeneficiado.getEndereco().getCep()
        ) : null;

        BeneficiadoId id = filhoBeneficiado.getBeneficiado().getId();

        FilhoBeneficiadoBeneficiadoResponseDto filhoBeneficiadoBeneficiadoResponseDto = filhoBeneficiado.getBeneficiado() != null
                ? new FilhoBeneficiadoBeneficiadoResponseDto(
                        id.getCpf(),
                        filhoBeneficiado.getBeneficiado().getNome()
        ) : null;

        FilhoBeneficiadoResponseDto responseDto = new FilhoBeneficiadoResponseDto(
                filhoBeneficiado.getIdFilhoBeneficiado(),
                filhoBeneficiado.getDataNascimento(),
                filhoBeneficiado.getIsEstudante(),
                filhoBeneficiado.getHasCreche(),
                filhoBeneficiadoEnderecoResponseDto,
                filhoBeneficiadoBeneficiadoResponseDto);

        return responseDto;
    }
}
