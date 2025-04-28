package tech4good.cruds.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech4good.cruds.entity.Voluntario;
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
    public ResponseEntity<Voluntario> cadastrar(@RequestBody Voluntario voluntario) {
        Voluntario novoVoluntario = voluntarioService.cadastrarVoluntario(voluntario);
        return ResponseEntity.status(201).body(novoVoluntario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Voluntario> buscarPorId(@PathVariable Integer id) {
        Voluntario voluntario = voluntarioService.buscarVoluntarioPorId(id);
        return ResponseEntity.ok(voluntario);
    }

    @GetMapping
    public ResponseEntity<List<Voluntario>> listar() {
        List<Voluntario> voluntarios = voluntarioService.listarVoluntarios();
        return voluntarios.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(voluntarios);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Voluntario> atualizar(
            @PathVariable Integer id,
            @RequestBody Voluntario voluntario) {
        voluntario.setIdVoluntario(id);
        Voluntario voluntarioAtualizado = voluntarioService.atualizarVoluntario(voluntario);
        return ResponseEntity.ok(voluntarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        voluntarioService.removerBeneficiadoPorId(id);
        return ResponseEntity.noContent().build();
    }
}