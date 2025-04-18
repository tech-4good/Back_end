package tech4good.cruds.mapper;

import tech4good.cruds.dto.endereco.EnderecoRequestDto;
import tech4good.cruds.dto.endereco.EnderecoResponseDto;
import tech4good.cruds.entity.Endereco;

public class EnderecoMapper {

    public static Endereco toEntity(EnderecoRequestDto requestDto){
        if(requestDto == null){
            return null;
        }

        Endereco endereco = new Endereco();
        endereco.setLogradouro(requestDto.getLogradouro());
        endereco.setNumero(requestDto.getNumero());
        endereco.setComplemento(requestDto.getComplemento());
        endereco.setBairro(requestDto.getBairro());
        endereco.setCidade(requestDto.getCidade());
        endereco.setEstado(requestDto.getEstado());
        endereco.setCep(requestDto.getCep());
        endereco.setTipoCesta(requestDto.getTipoCesta());
        endereco.setDataEntrada(requestDto.getDataEntrada());
        endereco.setMoradia(requestDto.getMoradia());
        endereco.setTipoMoradia(requestDto.getTipoMoradia());
        endereco.setStatus(requestDto.getStatus());

        return endereco;
    }

    public static EnderecoResponseDto toResponseDto(Endereco endereco){
        if(endereco == null){
            return null;
        }

        EnderecoResponseDto responseDto = new EnderecoResponseDto(
                endereco.getIdEndereco(),
                endereco.getLogradouro(),
                endereco.getNumero(),
                endereco.getComplemento(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getEstado(),
                endereco.getCep(),
                endereco.getTipoCesta(),
                endereco.getDataEntrada(),
                endereco.getDataSaida(),
                endereco.getMoradia(),
                endereco.getTipoMoradia(),
                endereco.getStatus()
        );

        return responseDto;
    }
}
