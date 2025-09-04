package tech4good.tech4good_api.infrastructure.persistence.jpa.Voluntario;

import tech4good.tech4good_api.core.application.command.voluntario.AtualizarVoluntarioCommand;
import tech4good.tech4good_api.core.application.command.voluntario.AutenticarVoluntarioCommand;
import tech4good.tech4good_api.core.application.command.voluntario.CadastrarVoluntarioCommand;
import tech4good.tech4good_api.core.application.command.voluntario.ListarVoluntarioPorIdCommand;
import tech4good.tech4good_api.core.application.command.voluntario.RedefinirSenhaVoluntarioCommand;
import tech4good.tech4good_api.core.application.command.voluntario.RemoverVoluntarioPorIdCommand;
import tech4good.tech4good_api.core.application.dto.voluntario.AtualizarVoluntarioRequestDto;
import tech4good.tech4good_api.core.application.dto.voluntario.VoluntarioListarDto;
import tech4good.tech4good_api.core.application.dto.voluntario.VoluntarioLoginDto;
import tech4good.tech4good_api.core.application.dto.voluntario.VoluntarioRedefinirSenhaDto;
import tech4good.tech4good_api.core.application.dto.voluntario.VoluntarioRequestDto;
import tech4good.tech4good_api.core.application.dto.voluntario.VoluntarioResponseDto;
import tech4good.tech4good_api.core.application.dto.voluntario.VoluntarioTokenDto;
import tech4good.tech4good_api.core.domain.voluntario.Voluntario;
import tech4good.tech4good_api.core.domain.shared.valueobject.Cpf;
import tech4good.tech4good_api.core.domain.shared.valueobject.Telefone;
import tech4good.tech4good_api.core.domain.voluntario.valueobject.Email;

public class VoluntarioMapper {

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

    // DTO → Command (para autenticação)
    public static AutenticarVoluntarioCommand toAutenticarCommand(VoluntarioLoginDto dto) {
        if (dto == null) {
            return null;
        }
        return new AutenticarVoluntarioCommand(
            dto.getEmail(),
            dto.getSenha()
        );
    }

    // ID → Command (para buscar por ID)
    public static ListarVoluntarioPorIdCommand toIdCommand(Integer id) {
        return new ListarVoluntarioPorIdCommand(id);
    }

    // ID → Command (para remover)
    public static RemoverVoluntarioPorIdCommand toRemoveCommand(Integer id) {
        return new RemoverVoluntarioPorIdCommand(id);
    }

    // DTO → Command (para redefinir senha)
    public static RedefinirSenhaVoluntarioCommand toRedefinirSenhaCommand(VoluntarioRedefinirSenhaDto dto) {
        if (dto == null) {
            return null;
        }
        return new RedefinirSenhaVoluntarioCommand(
            dto.getEmail(),
            dto.getSenhaAtual(),
            dto.getNovaSenha()
        );
    }

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
}
