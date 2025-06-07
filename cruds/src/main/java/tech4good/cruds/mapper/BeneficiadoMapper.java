package tech4good.cruds.mapper;

import tech4good.cruds.dto.beneficiado.BeneficiadoRequestDto;
import tech4good.cruds.dto.beneficiado.BeneficiadoResponseDto;
import tech4good.cruds.dto.auxiliares.EnderecoSummarizedResponseDto;
import tech4good.cruds.dto.beneficiado.BeneficiadoUpdateDto;
import tech4good.cruds.entity.Beneficiado;
import tech4good.cruds.entity.FileEntity;

public class BeneficiadoMapper {
    public static Beneficiado toEntity(BeneficiadoRequestDto requestDto) {
        if (requestDto == null) {
            return null;
        }

        Beneficiado entity = new Beneficiado();

        entity.setCpf(requestDto.getCpf());
        entity.setNome(requestDto.getNome());
        entity.setRg(requestDto.getRg());
        entity.setDataNascimento(requestDto.getDataNascimento());
        entity.setNaturalidade(requestDto.getNaturalidade());
        entity.setTelefone(requestDto.getTelefone());
        entity.setEstadoCivil(requestDto.getEstadoCivil());
        entity.setEscolaridade(requestDto.getEscolaridade());
        entity.setProfissao(requestDto.getProfissao());
        entity.setRendaMensal(requestDto.getRendaMensal());
        entity.setEmpresa(requestDto.getEmpresa());
        entity.setCargo(requestDto.getCargo());
        entity.setReligiao(requestDto.getReligiao());
        entity.setEndereco(requestDto.getEndereco());
        entity.setQuantidadeDependentes(requestDto.getQuantidadeDependentes());

        return entity;
    }

    public static BeneficiadoResponseDto toResponseDto(Beneficiado beneficiado) {
        if (beneficiado == null) {
            return null;
        }

        EnderecoSummarizedResponseDto enderecoBeneficiadoResponseDto = beneficiado.getEndereco() != null
                ? new EnderecoSummarizedResponseDto(
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

        FileEntity fotoBeneficiado = beneficiado.getFotoBeneficiado() != null
                ? new FileEntity(
                beneficiado.getFotoBeneficiado().getIdFoto(),
                beneficiado.getFotoBeneficiado().getNomeOriginal(),
                beneficiado.getFotoBeneficiado().getNomeArmazenamento(),
                beneficiado.getFotoBeneficiado().getTamanho(),
                beneficiado.getFotoBeneficiado().getFormato(),
                beneficiado.getFotoBeneficiado().getDataCriacao()
        ): null;


        BeneficiadoResponseDto responseDto = new BeneficiadoResponseDto(
                beneficiado.getId(),
                beneficiado.getCpf(),
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
                fotoBeneficiado
        );

        return responseDto;
    }

    public static Beneficiado toUpdate(BeneficiadoUpdateDto dto, Integer idBeneficiado){
        if (dto == null){
            return null;
        }

        Beneficiado beneficiado = new Beneficiado();
        beneficiado.setId(idBeneficiado);
        beneficiado.setNaturalidade(dto.getNaturalidade());
        beneficiado.setTelefone(dto.getTelefone());
        beneficiado.setEstadoCivil(dto.getEstadoCivil());
        beneficiado.setEscolaridade(dto.getEscolaridade());
        beneficiado.setProfissao(dto.getProfissao());
        beneficiado.setRendaMensal(dto.getRendaMensal());
        beneficiado.setEmpresa(dto.getEmpresa());
        beneficiado.setCargo(dto.getCargo());
        beneficiado.setEndereco(dto.getEndereco());

        return beneficiado;
    }
}
