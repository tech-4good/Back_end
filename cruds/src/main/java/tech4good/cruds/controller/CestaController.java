package tech4good.cruds.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech4good.cruds.entity.Cesta;
import tech4good.cruds.service.CestaService;

import java.util.List;

@RestController
@RequestMapping("/cestas")
public class CestaController {

    private final CestaService cestaService;

    public CestaController(CestaService cestaService) {
        this.cestaService = cestaService;
    }

    @PostMapping
    public ResponseEntity<Cesta> cadastrar(
            @RequestBody Cesta cestaParaCadastrar
    ) {
        Cesta cestaRegistrada = cestaService.cadastrarCesta(cestaParaCadastrar);
        return ResponseEntity.status(201).body(cestaRegistrada);
    }

    @GetMapping
    public ResponseEntity<List<Cesta>> listar() {
        List<Cesta> cestas = cestaService.listarCestas();
        if (cestas.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(cestas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cesta> buscarPorId(@PathVariable Integer id) {
        Cesta cestaEncontrada = cestaService.buscarCestaPorId(id);
        return ResponseEntity.status(200).body(cestaEncontrada);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Cesta> atualizar(
            @RequestBody Cesta cestaNova,
            @PathVariable Integer id
    ) {
        cestaNova.setIdCesta(id);
        Cesta cestaAlterada = cestaService.atualizarCestaPorId(cestaNova);
        return ResponseEntity.status(200).body(cestaAlterada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        cestaService.removerCesta(id);
        return ResponseEntity.status(204).build();
    }
}