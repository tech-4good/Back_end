package tech4good.cruds.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech4good.cruds.dto.tipomorador.TipoMoradorRequestDto;
import tech4good.cruds.dto.tipomorador.TipoMoradorResponseDto;
import tech4good.cruds.dto.tipomorador.TipoMoradorUpdateDto;
import tech4good.cruds.entity.TipoMorador;
import tech4good.cruds.mapper.TipoMoradorMapper;
import tech4good.cruds.service.TipoMoradorService;

import java.util.List;

@Tag(name = "Controller - Tipo de Morador", description = "Operações relacionadas aos tipos de moradores que residem nos endereços.")
@RestController
@RequestMapping("/tipo-moradores")
@SecurityRequirement(name = "Bearer")
public class TipoMoradorController {

    private final TipoMoradorService tipoMoradorService;

    public TipoMoradorController(TipoMoradorService tipoMoradorService) {
        this.tipoMoradorService = tipoMoradorService;
    }

    @PostMapping
    public ResponseEntity<TipoMoradorResponseDto> cadastrar(@RequestBody TipoMoradorRequestDto dto) {
        TipoMorador morador = TipoMoradorMapper.toEntity(dto);
        TipoMorador novoTipoMorador = tipoMoradorService.cadastrarTipoMorador(morador, dto.getEnderecoId(), dto.getBeneficiadoId());
        TipoMoradorResponseDto dtoSalvo = TipoMoradorMapper.toResponseDto(novoTipoMorador);
        return ResponseEntity.status(201).body(dtoSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoMoradorResponseDto> buscarPorId(@PathVariable Integer id) {
        TipoMorador tipoMorador = tipoMoradorService.buscarTipoMoradorPorId(id);
        TipoMoradorResponseDto moradorDto = TipoMoradorMapper.toResponseDto(tipoMorador);
        return ResponseEntity.ok(moradorDto);
    }

    @GetMapping
    public ResponseEntity<List<TipoMoradorResponseDto>> listar() {
        List<TipoMorador> tiposMoradores = tipoMoradorService.listarTipoMoradores();
        List<TipoMoradorResponseDto> tiposMoradoresListagem = tiposMoradores.stream().map(TipoMoradorMapper::toResponseDto).toList();
        return tiposMoradores.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(tiposMoradoresListagem);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TipoMoradorResponseDto> atualizar(
            @PathVariable Integer id,
            @RequestBody TipoMoradorUpdateDto dto) {
        TipoMorador tipoMorador = TipoMoradorMapper.toUpdate(dto, id);
        TipoMorador tipoMoradorAtualizado = tipoMoradorService.atualizarTipoMorador(tipoMorador, id);
        TipoMoradorResponseDto tipoMoradorDto = TipoMoradorMapper.toResponseDto(tipoMoradorAtualizado);
        return ResponseEntity.ok(tipoMoradorDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        tipoMoradorService.removerTipoMoradorPorId(id);
        return ResponseEntity.noContent().build();
    }
}