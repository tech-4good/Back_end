package tech4good.cruds.mapper;

import tech4good.cruds.dto.beneficiado.BeneficiadoRequestDto;
import tech4good.cruds.dto.beneficiado.BeneficiadoResponseDto;
import tech4good.cruds.dto.auxiliares.EnderecoBeneficiadoResponseDto;
import tech4good.cruds.entity.Beneficiado;
import tech4good.cruds.entity.BeneficiadoId;

public class BeneficiadoMapper {
    public static Beneficiado toEntity(BeneficiadoRequestDto requestDto) {
        if (requestDto == null) {
            return null;
        }

        BeneficiadoId beneficiadoId = new BeneficiadoId();
        beneficiadoId.setCpf(requestDto.getCpf());

        Beneficiado entity = new Beneficiado(
                beneficiadoId,
                requestDto.getNome(),
                requestDto.getRg(),
                requestDto.getDataNascimento(),
                requestDto.getNaturalidade(),
                requestDto.getTelefone(),
                requestDto.getEstadoCivil(),
                requestDto.getEscolaridade(),
                requestDto.getProfissao(),
                requestDto.getRendaMensal(),
                requestDto.getEmpresa(),
                requestDto.getCargo(),
                requestDto.getReligiao(),
                requestDto.getEndereco(),
                requestDto.getQuantidadeDependentes(),
                requestDto.getFotoBeneficiado()
        );

        return entity;
    }

    public static BeneficiadoResponseDto toResponseDto(Beneficiado beneficiado) {
        if (beneficiado == null) {
            return null;
        }

        BeneficiadoId id = beneficiado.getId();

        EnderecoBeneficiadoResponseDto enderecoBeneficiadoResponseDto = beneficiado.getEndereco() != null
                ? new EnderecoBeneficiadoResponseDto(
                    beneficiado.getEndereco().getLogradouro(),
                    beneficiado.getEndereco().getNumero(),
                    beneficiado.getEndereco().getComplemento(),
                    beneficiado.getEndereco().getBairro(),
                    beneficiado.getEndereco().getCidade(),
                    beneficiado.getEndereco().getEstado(),
                    beneficiado.getEndereco().getCep(),
                    beneficiado.getEndereco().getTipoCesta(),
                    beneficiado.getEndereco().getDataEntrada(),
                    beneficiado.getEndereco().getDataSaida(),
                    beneficiado.getEndereco().getMoradia(),
                    beneficiado.getEndereco().getTipoMoradia(),
                    beneficiado.getEndereco().getStatus()
                ): null;


        BeneficiadoResponseDto responseDto = new BeneficiadoResponseDto(
                id.getCpf(),
                beneficiado.getNome(),
                beneficiado.getRg(),
                beneficiado.getDataNascimento(),
                beneficiado.getNaturalidade(),
                beneficiado.getTelefone(),
                beneficiado.getEstadoCivil(),
                beneficiado.getEscolaridade(),
                beneficiado.getProfissao(),
                beneficiado.getRendaMensal(),
                beneficiado.getEmpresa(),
                beneficiado.getCargo(),
                beneficiado.getReligiao(),
                enderecoBeneficiadoResponseDto,
                beneficiado.getQuantidadeDependentes(),
                beneficiado.getFotoBeneficiado()
        );

        return responseDto;
    }
}
