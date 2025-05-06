package tech4good.cruds.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech4good.cruds.dto.voluntario.*;
import tech4good.cruds.entity.Voluntario;
import tech4good.cruds.mapper.VoluntarioMapper;
import tech4good.cruds.service.VoluntarioService;

import java.util.List;

@Tag(name = "Controller - Voluntário", description = "Operações relacionadas aos voluntários da ASA.")
@RestController
@RequestMapping("/voluntarios")
public class VoluntarioController {

    private final VoluntarioService voluntarioService;

    public VoluntarioController(VoluntarioService voluntarioService) {
        this.voluntarioService = voluntarioService;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid VoluntarioRequestDto dto) {

        final Voluntario novoVoluntario = VoluntarioMapper.toEntity(dto);
        this.voluntarioService.cadastrarVoluntario(novoVoluntario);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/login")
    public ResponseEntity<VoluntarioTokenDto> login(@RequestBody VoluntarioLoginDto voluntarioLoginDto) {
        final Voluntario voluntario = VoluntarioMapper.toEntity(voluntarioLoginDto);
        VoluntarioTokenDto voluntarioTokenDto = this.voluntarioService.autenticar(voluntario);

        return ResponseEntity.status(200).body(voluntarioTokenDto);
    }

    @GetMapping("/{id}")
    @SecurityRequirement(name = "Bearer")
    public ResponseEntity<VoluntarioResponseDto> buscarPorId(@PathVariable Integer id) {
        Voluntario voluntario = voluntarioService.buscarVoluntarioPorId(id);
        VoluntarioResponseDto voluntarioSalvo = VoluntarioMapper.toResponseDto(voluntario);
        return ResponseEntity.ok(voluntarioSalvo);
    }

    @GetMapping
    @SecurityRequirement(name = "Bearer")
    public ResponseEntity<List<VoluntarioListarDto>> listar() {
        List<VoluntarioListarDto> voluntarios = voluntarioService.listarVoluntarios();
        return voluntarios.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(voluntarios);
    }

    @PatchMapping("/{id}")
    @SecurityRequirement(name = "Bearer")
    public ResponseEntity<VoluntarioResponseDto> atualizar(
            @PathVariable Integer id,
            @RequestBody Voluntario voluntario) {
        voluntario.setIdVoluntario(id);
        Voluntario voluntarioAtualizado = voluntarioService.atualizarVoluntario(voluntario);
        VoluntarioResponseDto voluntarioDto = VoluntarioMapper.toResponseDto(voluntarioAtualizado);
        return ResponseEntity.ok(voluntarioDto);
    }

    @DeleteMapping("/{id}")
    @SecurityRequirement(name = "Bearer")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        voluntarioService.removerVoluntarioPorId(id);
        return ResponseEntity.noContent().build();
    }
}