package tech4good.cruds.mapper;

import tech4good.cruds.dto.auxiliares.CestaEntregaResponseDto;
import tech4good.cruds.dto.auxiliares.EnderecoBeneficiadoResponseDto;
import tech4good.cruds.dto.auxiliares.VoluntarioEntregaResponseDto;
import tech4good.cruds.dto.entrega.EntregaRequestDto;
import tech4good.cruds.dto.entrega.EntregaResponseDto;
import tech4good.cruds.entity.Entrega;

public class EntregaMapper {

    public static Entrega toEntity(EntregaRequestDto requestDto){
        if (requestDto == null){
            return null;
        }

        Entrega entrega = new Entrega();
        entrega.setDataRetirada(requestDto.getDataRetirada());
        entrega.setProximaRetirada(requestDto.getProximaRetirada());
        return entrega;
    }

    public static EntregaResponseDto toResponseDto(Entrega entrega){
        if (entrega == null){
            return null;
        }

        EnderecoBeneficiadoResponseDto enderecoBeneficiadoResponseDto = entrega.getEndereco() != null
                ? new EnderecoBeneficiadoResponseDto(
                entrega.getEndereco().getLogradouro(),
                entrega.getEndereco().getNumero(),
                entrega.getEndereco().getComplemento(),
                entrega.getEndereco().getBairro(),
                entrega.getEndereco().getCidade(),
                entrega.getEndereco().getEstado(),
                entrega.getEndereco().getCep(),
                entrega.getEndereco().getTipoCesta(),
                entrega.getEndereco().getDataEntrada(),
                entrega.getEndereco().getDataSaida(),
                entrega.getEndereco().getMoradia(),
                entrega.getEndereco().getTipoMoradia(),
                entrega.getEndereco().getStatus()
        ): null;

        CestaEntregaResponseDto cestaEntregaResponseDto = entrega.getCesta() != null
                ? new CestaEntregaResponseDto(
                        entrega.getCesta().getTipo()
        ): null;

        VoluntarioEntregaResponseDto voluntarioEntregaResponseDto = entrega.getVoluntario() != null
                ? new VoluntarioEntregaResponseDto(
                        entrega.getVoluntario().getIdVoluntario(),
                        entrega.getVoluntario().getNome()
        ): null;

        EntregaResponseDto responseDto = new EntregaResponseDto(
                entrega.getIdEntrega(),
                entrega.getDataRetirada(),
                entrega.getProximaRetirada(),
                enderecoBeneficiadoResponseDto,
                cestaEntregaResponseDto,
                voluntarioEntregaResponseDto
        );
        return responseDto;
    }
}
