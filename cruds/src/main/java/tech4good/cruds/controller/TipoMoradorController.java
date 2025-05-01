package tech4good.cruds.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech4good.cruds.dto.tipomorador.TipoMoradorRequestDto;
import tech4good.cruds.dto.tipomorador.TipoMoradorResponseDto;
import tech4good.cruds.entity.TipoMorador;
import tech4good.cruds.mapper.TipoMoradorMapper;
import tech4good.cruds.service.TipoMoradorService;

import java.util.List;

@RestController
@RequestMapping("/tipo-moradores")
public class TipoMoradorController {

    private final TipoMoradorService tipoMoradorService;

    public TipoMoradorController(TipoMoradorService tipoMoradorService) {
        this.tipoMoradorService = tipoMoradorService;
    }

    @PostMapping
    public ResponseEntity<TipoMoradorResponseDto> cadastrar(@RequestBody TipoMoradorRequestDto dto) {
        TipoMorador morador = TipoMoradorMapper.toEntity(dto);
        TipoMorador novoTipoMorador = tipoMoradorService.cadastrarTipoMorador(morador);
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
            @RequestBody TipoMorador tipoMorador) {
        tipoMorador.setIdTipoMorador(id);
        TipoMorador tipoMoradorAtualizado = tipoMoradorService.atualizarTipoMorador(tipoMorador);
        TipoMoradorResponseDto tipoMoradorDto = TipoMoradorMapper.toResponseDto(tipoMoradorAtualizado);
        return ResponseEntity.ok(tipoMoradorDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        tipoMoradorService.removerTipoMoradorPorId(id);
        return ResponseEntity.noContent().build();
    }
}