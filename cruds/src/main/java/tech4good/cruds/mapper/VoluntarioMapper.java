package tech4good.cruds.mapper;

import tech4good.cruds.dto.voluntario.VoluntarioRequestDto;
import tech4good.cruds.dto.voluntario.VoluntarioResponseDto;
import tech4good.cruds.entity.Voluntario;

public class VoluntarioMapper {
    public static Voluntario toEntity(VoluntarioRequestDto requestDto) {
        if (requestDto == null) {
            return null;
        }

        Voluntario voluntario = new Voluntario();
        voluntario.setNome(requestDto.getNome());
        voluntario.setCpf(requestDto.getCpf());
        voluntario.setTelefone(requestDto.getTelefone());
        voluntario.setSenha(requestDto.getSenha());
        voluntario.setEmail(requestDto.getEmail());

        return voluntario;
    }

    public static VoluntarioResponseDto toResponseDto(Voluntario voluntario) {
        if (voluntario == null) {
            return null;
        }

        VoluntarioResponseDto responseDto = new VoluntarioResponseDto(
                voluntario.getIdVoluntario(),
                voluntario.getNome(),
                voluntario.getCpf(),
                voluntario.getTelefone(),
                voluntario.getEmail()
        );

        return responseDto;
    }
}
