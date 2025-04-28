package tech4good.cruds.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech4good.cruds.entity.TipoMorador;
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
    public ResponseEntity<TipoMorador> cadastrar(@RequestBody TipoMorador tipoMorador) {
        TipoMorador novoTipoMorador = tipoMoradorService.cadastrarTipoMorador(tipoMorador);
        return ResponseEntity.status(201).body(novoTipoMorador);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoMorador> buscarPorId(@PathVariable Integer id) {
        TipoMorador tipoMorador = tipoMoradorService.buscarTipoMoradorPorId(id);
        return ResponseEntity.ok(tipoMorador);
    }

    @GetMapping
    public ResponseEntity<List<TipoMorador>> listar() {
        List<TipoMorador> tiposMoradores = tipoMoradorService.listarTipoMoradores();
        return tiposMoradores.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(tiposMoradores);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TipoMorador> atualizar(
            @PathVariable Integer id,
            @RequestBody TipoMorador tipoMorador) {
        tipoMorador.setIdTipoMorador(id);
        TipoMorador tipoMoradorAtualizado = tipoMoradorService.atualizarTipoMorador(tipoMorador);
        return ResponseEntity.ok(tipoMoradorAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        tipoMoradorService.removerTipoMoradorPorId(id);
        return ResponseEntity.noContent().build();
    }
}