package tech4good.tech4good_api.infrastructure.web;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech4good.tech4good_api.core.application.command.voluntario.AtualizarVoluntarioCommand;
import tech4good.tech4good_api.core.application.command.voluntario.AutenticarVoluntarioCommand;
import tech4good.tech4good_api.core.application.command.voluntario.CadastrarVoluntarioCommand;
import tech4good.tech4good_api.core.application.command.voluntario.ListarVoluntarioPorIdCommand;
import tech4good.tech4good_api.core.application.command.voluntario.RedefinirSenhaVoluntarioCommand;
import tech4good.tech4good_api.core.application.command.voluntario.RemoverVoluntarioPorIdCommand;
import tech4good.tech4good_api.core.application.dto.voluntario.*;
import tech4good.tech4good_api.core.application.usecase.voluntario.*;
import tech4good.tech4good_api.core.domain.voluntario.Voluntario;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Voluntario.VoluntarioMapper;

import java.util.List;

@Tag(name = "Controller - Voluntário", description = "Operações relacionadas aos voluntários da ASA.")
@RestController
@RequestMapping("/voluntarios")
public class VoluntarioController {

    private final CadastrarVoluntarioUseCase cadastrarVoluntarioUseCase;
    private final AutenticarVoluntarioUseCase autenticarVoluntarioUseCase;
    private final ListarVoluntarioPorIdUseCase listarVoluntarioPorIdUseCase;
    private final ListarVoluntariosUseCase listarVoluntariosUseCase;
    private final AtualizarVoluntarioUseCase atualizarVoluntarioUseCase;
    private final RemoverVoluntarioPorIdUseCase removerVoluntarioPorIdUseCase;
    private final RedefinirSenhaVoluntarioUseCase redefinirSenhaVoluntarioUseCase;

    public VoluntarioController(
        CadastrarVoluntarioUseCase cadastrarVoluntarioUseCase,
        AutenticarVoluntarioUseCase autenticarVoluntarioUseCase,
        ListarVoluntarioPorIdUseCase listarVoluntarioPorIdUseCase,
        ListarVoluntariosUseCase listarVoluntariosUseCase,
        AtualizarVoluntarioUseCase atualizarVoluntarioUseCase,
        RemoverVoluntarioPorIdUseCase removerVoluntarioPorIdUseCase,
        RedefinirSenhaVoluntarioUseCase redefinirSenhaVoluntarioUseCase
    ) {
        this.cadastrarVoluntarioUseCase = cadastrarVoluntarioUseCase;
        this.autenticarVoluntarioUseCase = autenticarVoluntarioUseCase;
        this.listarVoluntarioPorIdUseCase = listarVoluntarioPorIdUseCase;
        this.listarVoluntariosUseCase = listarVoluntariosUseCase;
        this.atualizarVoluntarioUseCase = atualizarVoluntarioUseCase;
        this.removerVoluntarioPorIdUseCase = removerVoluntarioPorIdUseCase;
        this.redefinirSenhaVoluntarioUseCase = redefinirSenhaVoluntarioUseCase;
    }

    @Operation(summary = "Cadastrar voluntário", description = "Cria um novo voluntário no sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Voluntário criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid VoluntarioRequestDto dto) {
        CadastrarVoluntarioCommand command = VoluntarioMapper.toCommand(dto);
        cadastrarVoluntarioUseCase.execute(command);
        return ResponseEntity.status(201).build();
    }

    @Operation(summary = "Login do voluntário", description = "Autentica um voluntário e retorna token JWT")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Login realizado com sucesso"),
        @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    })
    @PostMapping("/login")
    public ResponseEntity<VoluntarioTokenDto> login(@RequestBody VoluntarioLoginDto voluntarioLoginDto) {
        AutenticarVoluntarioCommand command = VoluntarioMapper.toAutenticarCommand(voluntarioLoginDto);
        VoluntarioTokenDto voluntarioTokenDto = autenticarVoluntarioUseCase.execute(command);
        return ResponseEntity.status(200).body(voluntarioTokenDto);
    }

    @GetMapping("/{id}")
    @SecurityRequirement(name = "Bearer")
    public ResponseEntity<VoluntarioResponseDto> buscarPorId(@PathVariable Integer id) {
        ListarVoluntarioPorIdCommand command = VoluntarioMapper.toIdCommand(id);
        Voluntario voluntario = listarVoluntarioPorIdUseCase.execute(command);
        VoluntarioResponseDto voluntarioSalvo = VoluntarioMapper.toResponseDto(voluntario);
        return ResponseEntity.ok(voluntarioSalvo);
    }

    @GetMapping
    @SecurityRequirement(name = "Bearer")
    public ResponseEntity<List<VoluntarioListarDto>> listar() {
        List<VoluntarioListarDto> voluntarios = listarVoluntariosUseCase.execute();
        return voluntarios.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(voluntarios);
    }

    @PatchMapping("/{id}")
    @SecurityRequirement(name = "Bearer")
    public ResponseEntity<VoluntarioResponseDto> atualizar(
            @PathVariable Integer id,
            @RequestBody AtualizarVoluntarioRequestDto dto) {
        AtualizarVoluntarioCommand command = VoluntarioMapper.toAtualizarCommand(id, dto);
        Voluntario voluntarioAtualizado = atualizarVoluntarioUseCase.execute(command);
        VoluntarioResponseDto voluntarioDto = VoluntarioMapper.toResponseDto(voluntarioAtualizado);
        return ResponseEntity.ok(voluntarioDto);
    }

    @DeleteMapping("/{id}")
    @SecurityRequirement(name = "Bearer")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        RemoverVoluntarioPorIdCommand command = VoluntarioMapper.toRemoveCommand(id);
        removerVoluntarioPorIdUseCase.execute(command);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/redefinir-senha")
    @SecurityRequirement(name = "Bearer")
    public ResponseEntity<Void> redefinirSenha(@RequestBody @Valid VoluntarioRedefinirSenhaDto dto) {
        RedefinirSenhaVoluntarioCommand command = VoluntarioMapper.toRedefinirSenhaCommand(dto);
        redefinirSenhaVoluntarioUseCase.execute(command);
        return ResponseEntity.ok().build();
    }
}
