package tech4good.cruds.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech4good.cruds.entity.Entrega;
import tech4good.cruds.service.EntregaService;

import java.util.List;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private final EntregaService entregaService;

    public EntregaController(EntregaService entregaService) {
        this.entregaService = entregaService;
    }

    @PostMapping
    public ResponseEntity<Entrega> cadastrar(@RequestBody Entrega entrega) {
        Entrega novaEntrega = entregaService.cadastrarEntrega(entrega);
        return ResponseEntity.status(201).body(novaEntrega);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrega> buscarPorId(@PathVariable Integer id) {
        Entrega entrega = entregaService.buscarEntregaPorId(id);
        return ResponseEntity.ok(entrega);
    }

    @GetMapping
    public ResponseEntity<List<Entrega>> listar() {
        List<Entrega> entregas = entregaService.listarEntregas();
        return entregas.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(entregas);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Entrega> atualizar(
            @PathVariable Integer id,
            @RequestBody Entrega entrega) {
        entrega.setIdEntrega(id);
        Entrega entregaAtualizada = entregaService.atualizarEntrega(entrega);
        return ResponseEntity.ok(entregaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        entregaService.removerEntregaPorId(id);
        return ResponseEntity.noContent().build();
    }
}