package tech4good.cruds.mapper;

import tech4good.cruds.dto.auxiliares.BeneficiadoSummarizedResponseDto;
import tech4good.cruds.dto.auxiliares.CestaSummarizedResponseDto;
import tech4good.cruds.dto.auxiliares.EnderecoSummarizedResponseDto;
import tech4good.cruds.dto.auxiliares.VoluntarioSummarizedResponseDto;
import tech4good.cruds.dto.entrega.EntregaRequestDto;
import tech4good.cruds.dto.entrega.EntregaResponseDto;
import tech4good.cruds.dto.entrega.EntregaUpdateDto;
import tech4good.cruds.entity.Entrega;

public class EntregaMapper {

    public static Entrega toEntity(EntregaRequestDto requestDto) {
        if (requestDto == null) {
            return null;
        }

        Entrega entrega = new Entrega();
        entrega.setDataRetirada(requestDto.getDataRetirada());
        entrega.setProximaRetirada(requestDto.getProximaRetirada());
        return entrega;
    }

    public static EntregaResponseDto toResponseDto(Entrega entrega) {
        if (entrega == null) {
            return null;
        }

        EnderecoSummarizedResponseDto enderecoBeneficiadoResponseDto = entrega.getEndereco() != null
                ? new EnderecoSummarizedResponseDto(
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
        ) : null;

        CestaSummarizedResponseDto cestaEntregaResponseDto = entrega.getCesta() != null
                ? new CestaSummarizedResponseDto(
                entrega.getCesta().getTipo()
        ) : null;

        VoluntarioSummarizedResponseDto voluntarioEntregaResponseDto = entrega.getVoluntario() != null
                ? new VoluntarioSummarizedResponseDto(
                entrega.getVoluntario().getIdVoluntario(),
                entrega.getVoluntario().getNome()
        ) : null;

        BeneficiadoSummarizedResponseDto beneficiadoSummarizedResponseDto = entrega.getBeneficiado() != null
                ? new BeneficiadoSummarizedResponseDto(
                entrega.getBeneficiado().getCpf(),
                entrega.getBeneficiado().getNome()
        ) : null;

        EntregaResponseDto responseDto = new EntregaResponseDto(
                entrega.getIdEntrega(),
                entrega.getDataRetirada(),
                entrega.getProximaRetirada(),
                enderecoBeneficiadoResponseDto,
                cestaEntregaResponseDto,
                voluntarioEntregaResponseDto,
                beneficiadoSummarizedResponseDto
        );
        return responseDto;
    }

    public static Entrega toUpdate(EntregaUpdateDto dto, Integer idEntrega) {
        if (dto == null) {
            return null;
        }

        Entrega entrega = new Entrega();
        entrega.setIdEntrega(idEntrega);
        entrega.setDataRetirada(dto.getDataRetirada());
        entrega.setProximaRetirada(dto.getProximaRetirada());

        return entrega;
    }

}