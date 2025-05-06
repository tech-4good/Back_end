package tech4good.cruds.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech4good.cruds.dto.filho.FilhoBeneficiadoRequestDto;
import tech4good.cruds.dto.filho.FilhoBeneficiadoResponseDto;
import tech4good.cruds.entity.FilhoBeneficiado;
import tech4good.cruds.mapper.FilhoBeneficiarioMapper;
import tech4good.cruds.service.FilhoBeneficiadoService;

import java.util.List;

@Tag(name = "Controller - Filho", description = "Operações relacionadas aos filhos dos beneficiados pela ASA.")
@RestController
@RequestMapping("/filhos-beneficiados")
@SecurityRequirement(name = "Bearer")
public class FilhoBeneficiadoController {

    private final FilhoBeneficiadoService filhoBeneficiadoService;

    public FilhoBeneficiadoController(FilhoBeneficiadoService filhoBeneficiadoService) {
        this.filhoBeneficiadoService = filhoBeneficiadoService;
    }

    @PostMapping
    public ResponseEntity<FilhoBeneficiadoResponseDto> cadastrar(
            @RequestBody FilhoBeneficiadoRequestDto dto) {
        FilhoBeneficiado filho = FilhoBeneficiarioMapper.toEntity(dto);
        FilhoBeneficiado novoFilho = filhoBeneficiadoService.cadastrarFilhoBeneficiado(filho);
        FilhoBeneficiadoResponseDto dtoSalvo = FilhoBeneficiarioMapper.toResponseDto(novoFilho);
        return ResponseEntity.status(201).body(dtoSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilhoBeneficiadoResponseDto> buscarPorId(@PathVariable Integer id) {
        FilhoBeneficiado filho = filhoBeneficiadoService.buscarFilhoBeneficiadoPorId(id);
        FilhoBeneficiadoResponseDto filhoDto = FilhoBeneficiarioMapper.toResponseDto(filho);
        return ResponseEntity.ok(filhoDto);
    }

    @GetMapping
    public ResponseEntity<List<FilhoBeneficiadoResponseDto>> listar() {
        List<FilhoBeneficiado> filhos = filhoBeneficiadoService.listarFilhosBeneficiados();
        List<FilhoBeneficiadoResponseDto> filhoListagem = filhos.stream().map(FilhoBeneficiarioMapper::toResponseDto).toList();
        return filhos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(filhoListagem);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<FilhoBeneficiadoResponseDto> atualizar(
            @PathVariable Integer id,
            @RequestBody FilhoBeneficiado filhoBeneficiado) {
        filhoBeneficiado.setIdFilhoBeneficiado(id);
        FilhoBeneficiado filhoAtualizado = filhoBeneficiadoService.atualizarFilhoBeneficiado(filhoBeneficiado);
        FilhoBeneficiadoResponseDto filhoDto = FilhoBeneficiarioMapper.toResponseDto(filhoAtualizado);
        return ResponseEntity.ok(filhoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        filhoBeneficiadoService.removerFilhoBeneficiadoPorId(id);
        return ResponseEntity.noContent().build();
    }
}