package tech4good.cruds.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech4good.cruds.dto.voluntario.VoluntarioRequestDto;
import tech4good.cruds.dto.voluntario.VoluntarioResponseDto;
import tech4good.cruds.entity.Voluntario;
import tech4good.cruds.mapper.VoluntarioMapper;
import tech4good.cruds.service.VoluntarioService;

import java.util.List;

@RestController
@RequestMapping("/voluntarios")
public class VoluntarioController {

    private final VoluntarioService voluntarioService;

    public VoluntarioController(VoluntarioService voluntarioService) {
        this.voluntarioService = voluntarioService;
    }

    @PostMapping
    public ResponseEntity<VoluntarioResponseDto> cadastrar(@RequestBody VoluntarioRequestDto dto) {
        Voluntario voluntario = VoluntarioMapper.toEntity(dto);
        Voluntario novoVoluntario = voluntarioService.cadastrarVoluntario(voluntario);
        VoluntarioResponseDto dtoSalvo = VoluntarioMapper.toResponseDto(novoVoluntario);
        return ResponseEntity.status(201).body(dtoSalvo);

    }

    @GetMapping("/{id}")
    public ResponseEntity<VoluntarioResponseDto> buscarPorId(@PathVariable Integer id) {
        Voluntario voluntario = voluntarioService.buscarVoluntarioPorId(id);
        VoluntarioResponseDto voluntarioSalvo = VoluntarioMapper.toResponseDto(voluntario);
        return ResponseEntity.ok(voluntarioSalvo);
    }

    @GetMapping
    public ResponseEntity<List<VoluntarioResponseDto>> listar() {
        List<Voluntario> voluntarios = voluntarioService.listarVoluntarios();
        List<VoluntarioResponseDto> voluntarioListagem = voluntarios.stream().map(VoluntarioMapper::toResponseDto).toList();
        return voluntarios.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(voluntarioListagem);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<VoluntarioResponseDto> atualizar(
            @PathVariable Integer id,
            @RequestBody Voluntario voluntario) {
        voluntario.setIdVoluntario(id);
        Voluntario voluntarioAtualizado = voluntarioService.atualizarVoluntario(voluntario);
        VoluntarioResponseDto voluntarioDto = VoluntarioMapper.toResponseDto(voluntarioAtualizado);
        return ResponseEntity.ok(voluntarioDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        voluntarioService.removerVoluntarioPorId(id);
        return ResponseEntity.noContent().build();
    }
}