package tech4good.cruds.mapper;

import tech4good.cruds.dto.auxiliares.FilhoBeneficiadoBeneficiadoResponseDto;
import tech4good.cruds.dto.auxiliares.FilhoBeneficiadoEnderecoResponseDto;
import tech4good.cruds.dto.tipomorador.TipoMoradorRequestDto;
import tech4good.cruds.dto.tipomorador.TipoMoradorResponseDto;
import tech4good.cruds.entity.BeneficiadoId;
import tech4good.cruds.entity.TipoMorador;

public class TipoMoradorMapper {

    public static TipoMorador toEntity(TipoMoradorRequestDto requestDto){
        if(requestDto == null){
            return null;
        }

        TipoMorador tipoMorador = new TipoMorador();
        tipoMorador.setQuantidadeCrianca(requestDto.getQuantidadeCrianca());
        tipoMorador.setQuantidadeAdolescente(requestDto.getQuantidadeAdolescente());
        tipoMorador.setQuantidadeJovem(requestDto.getQuantidadeJovem());
        tipoMorador.setQuantidadeIdoso(requestDto.getQuantidadeIdoso());
        tipoMorador.setQuantidadeGestante(requestDto.getQuantidadeGestante());
        tipoMorador.setQuantidadeDeficiente(requestDto.getQuantidadeDeficiente());
        tipoMorador.setQuantidadeOutros(requestDto.getQuantidadeOutros());

        return tipoMorador;
    }

    public static TipoMoradorResponseDto toResponseDto(TipoMorador tipoMorador){
        if(tipoMorador == null){
            return null;
        }

        FilhoBeneficiadoEnderecoResponseDto filhoBeneficiadoEnderecoResponseDto = tipoMorador.getEndereco() != null
                ? new FilhoBeneficiadoEnderecoResponseDto(
                tipoMorador.getEndereco().getIdEndereco(),
                tipoMorador.getEndereco().getLogradouro(),
                tipoMorador.getEndereco().getNumero(),
                tipoMorador.getEndereco().getComplemento(),
                tipoMorador.getEndereco().getBairro(),
                tipoMorador.getEndereco().getCidade(),
                tipoMorador.getEndereco().getEstado(),
                tipoMorador.getEndereco().getCep()
        ) : null;

        BeneficiadoId id = tipoMorador.getBeneficiado().getId();

        FilhoBeneficiadoBeneficiadoResponseDto filhoBeneficiadoBeneficiadoResponseDto = tipoMorador.getBeneficiado() != null
                ? new FilhoBeneficiadoBeneficiadoResponseDto(
                id.getCpf(),
                tipoMorador.getBeneficiado().getNome()
        ) : null;

        TipoMoradorResponseDto responseDto = new TipoMoradorResponseDto(
                tipoMorador.getIdTipoMorador(),
                tipoMorador.getQuantidadeCrianca(),
                tipoMorador.getQuantidadeAdolescente(),
                tipoMorador.getQuantidadeJovem(),
                tipoMorador.getQuantidadeIdoso(),
                tipoMorador.getQuantidadeGestante(),
                tipoMorador.getQuantidadeDeficiente(),
                tipoMorador.getQuantidadeOutros(),
                filhoBeneficiadoEnderecoResponseDto,
                filhoBeneficiadoBeneficiadoResponseDto
        );
        return responseDto;
    }
}
