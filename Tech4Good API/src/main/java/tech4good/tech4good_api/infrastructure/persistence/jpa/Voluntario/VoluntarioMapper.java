package tech4good.tech4good_api.infrastructure.persistence.jpa.Voluntario;

import tech4good.tech4good_api.core.application.command.voluntario.AtualizarVoluntarioCommand;
import tech4good.tech4good_api.core.application.command.voluntario.CadastrarVoluntarioCommand;
import tech4good.tech4good_api.core.application.dto.voluntario.AtualizarVoluntarioRequestDto;
import tech4good.tech4good_api.core.application.dto.voluntario.VoluntarioRequestDto;
import tech4good.tech4good_api.core.application.dto.voluntario.VoluntarioResponseDto;
import tech4good.tech4good_api.core.domain.voluntario.Voluntario;
import tech4good.tech4good_api.core.domain.shared.valueobject.Cpf;
import tech4good.tech4good_api.core.domain.shared.valueobject.Telefone;
import tech4good.tech4good_api.core.domain.voluntario.valueobject.Email;

public class VoluntarioMapper {

    public static Voluntario toDomain(CadastrarVoluntarioCommand command) {
        if (command == null) {
            return null;
        }
        Voluntario voluntario = new Voluntario();
        voluntario.setNome(command.nome());
        voluntario.setCpf(command.cpf());
        voluntario.setTelefone(command.telefone());
        voluntario.setSenha(command.senha());
        voluntario.setEmail(command.email());
        voluntario.setAdministrador(command.administrador());
        return voluntario;
    }

    public static CadastrarVoluntarioCommand toCommand(VoluntarioRequestDto dto) {
        if (dto == null) {
            return null;
        }
        return new CadastrarVoluntarioCommand(
            dto.getNome(),
            new Cpf(dto.getCpf()),
            new Telefone(dto.getTelefone()),
            dto.getSenha(),
            new Email(dto.getEmail()),
            dto.getAdministrador()
        );
    }

    public static VoluntarioEntity toEntity(Voluntario voluntario) {
        if (voluntario == null) {
            return null;
        }
        VoluntarioEntity entity = new VoluntarioEntity();
        entity.setIdVoluntario(voluntario.getId());
        entity.setNome(voluntario.getNome());
        entity.setCpf(voluntario.getCpf());
        entity.setTelefone(voluntario.getTelefone());
        entity.setSenha(voluntario.getSenha());
        entity.setEmail(voluntario.getEmail());
        entity.setAdministrador(voluntario.getAdministrador());
        return entity;
    }

    public static Voluntario toDomainFromEntity(VoluntarioEntity entity) {
        if (entity == null) {
            return null;
        }
        Voluntario voluntario = new Voluntario();
        voluntario.setId(entity.getIdVoluntario());
        voluntario.setNome(entity.getNome());
        voluntario.setCpf(entity.getCpf());
        voluntario.setTelefone(entity.getTelefone());
        voluntario.setSenha(entity.getSenha());
        voluntario.setEmail(entity.getEmail());
        voluntario.setAdministrador(entity.getAdministrador());
        return voluntario;
    }

    public static VoluntarioResponseDto toResponseDto(Voluntario voluntario) {
        if (voluntario == null) {
            return null;
        }
        return new VoluntarioResponseDto(
            voluntario.getId(),
            voluntario.getNome(),
            voluntario.getCpf() != null ? voluntario.getCpf().toString() : null,
            voluntario.getTelefone() != null ? voluntario.getTelefone().toString() : null,
            voluntario.getEmail() != null ? voluntario.getEmail().toString() : null,
            voluntario.getAdministrador()
        );
    }

    public static AtualizarVoluntarioCommand toAtualizarCommand(Integer id, AtualizarVoluntarioRequestDto dto) {
        if (dto == null) {
            return null;
        }
        return new AtualizarVoluntarioCommand(
            id,
            new Telefone(dto.getTelefone()),
            new Email(dto.getEmail())
        );
    }

    public static VoluntarioListarDto toVoluntarioListarDto(Voluntario voluntario) {
        if (voluntario == null) {
            return null;
        }
        return new VoluntarioListarDto(
            voluntario.getId(),
            voluntario.getNome(),
            voluntario.getCpf() != null ? voluntario.getCpf().toString() : null,
            voluntario.getTelefone() != null ? voluntario.getTelefone().toString() : null,
            voluntario.getEmail() != null ? voluntario.getEmail().toString() : null
        );
    }

    public static VoluntarioTokenDto toVoluntarioTokenDto(Voluntario voluntario, String token) {
        if (voluntario == null) {
            return null;
        }
        return new VoluntarioTokenDto(
            voluntario.getId(),
            voluntario.getNome(),
            voluntario.getEmail() != null ? voluntario.getEmail().toString() : null,
            token
        );
    }

    public static Voluntario toEntity(VoluntarioLoginDto dto) {
        if (dto == null) {
            return null;
        }
        Voluntario voluntario = new Voluntario();
        voluntario.setEmail(new Email(dto.getEmail()));
        voluntario.setSenha(dto.getSenha());
        return voluntario;
    }

    public static Voluntario toUpdate(AtualizarVoluntarioRequestDto dto, Integer id) {
        if (dto == null) {
            return null;
        }
        Voluntario voluntario = new Voluntario();
        voluntario.setId(id);
        voluntario.setTelefone(new Telefone(dto.getTelefone()));
        voluntario.setEmail(new Email(dto.getEmail()));
        return voluntario;
    }

    public static AutenticarVoluntarioCommand toAutenticarCommand(VoluntarioLoginDto dto) {
        if (dto == null) {
            return null;
        }
        return new AutenticarVoluntarioCommand(dto.getEmail(), dto.getSenha());
    }

    public static RedefinirSenhaVoluntarioCommand toRedefinirSenhaCommand(VoluntarioRedefinirSenhaDto dto) {
        if (dto == null) {
            return null;
        }
        return new RedefinirSenhaVoluntarioCommand(dto.getEmail(), dto.getSenhaAtual(), dto.getNovaSenha());
    }
}
