package tech4good.cruds.mapper;

import tech4good.cruds.dto.voluntario.*;
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

    public static Voluntario toEntity(VoluntarioLoginDto loginDto) {
        if (loginDto == null) {
            return null;
        }

        Voluntario voluntario = new Voluntario();
        voluntario.setSenha(loginDto.getSenha());
        voluntario.setEmail(loginDto.getEmail());

        return voluntario;
    }

    public static VoluntarioTokenDto toVoluntarioTokenDto(Voluntario voluntario, String token) {
        if (voluntario == null) {
            return null;
        }

        VoluntarioTokenDto voluntarioTokenDto = new VoluntarioTokenDto();
        voluntarioTokenDto.setUserId(voluntario.getIdVoluntario());
        voluntarioTokenDto.setEmail(voluntario.getEmail());
        voluntarioTokenDto.setNome(voluntario.getNome());
        voluntarioTokenDto.setToken(token);

        return voluntarioTokenDto;
    }

    public static VoluntarioListarDto toVoluntarioListarDto(Voluntario voluntario) {
        if (voluntario == null) {
            return null;
        }

        VoluntarioListarDto voluntarioListarDto = new VoluntarioListarDto();
        voluntarioListarDto.setIdVoluntario(voluntario.getIdVoluntario());
        voluntarioListarDto.setEmail(voluntario.getEmail());
        voluntarioListarDto.setNome(voluntario.getNome());

        return voluntarioListarDto;
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

    public static Voluntario toUpdate(VoluntarioUpdateDto dto, Integer idVoluntario){
        if (dto == null){
            return null;
        }

        Voluntario voluntario = new Voluntario();
        voluntario.setIdVoluntario(idVoluntario);
        voluntario.setTelefone(dto.getTelefone());
        voluntario.setEmail(dto.getEmail());
        return voluntario;
    }
}
