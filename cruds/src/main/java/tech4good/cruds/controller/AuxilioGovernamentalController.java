package tech4good.cruds.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech4good.cruds.entity.AuxilioGovernamental;
import tech4good.cruds.service.AuxilioGovernamentalService;

import java.util.List;

@RestController
@RequestMapping("/auxilio-governamentais")
public class AuxilioGovernamentalController {

    private final AuxilioGovernamentalService auxilioGovernamentalService;

    public AuxilioGovernamentalController(AuxilioGovernamentalService auxilioGovernamentalService) {
        this.auxilioGovernamentalService = auxilioGovernamentalService;
    }

    @PostMapping
    public ResponseEntity<AuxilioGovernamental> cadastrar(@RequestBody AuxilioGovernamental auxilio) {
        AuxilioGovernamental novoAuxilio = auxilioGovernamentalService.cadastrarAuxilioGovernamental(auxilio);
        return ResponseEntity.status(201).body(novoAuxilio);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuxilioGovernamental> buscarPorId(@PathVariable Integer id) {
        AuxilioGovernamental auxilio = auxilioGovernamentalService.buscarAuxilioGovernamentalPorId(id);
        return ResponseEntity.ok(auxilio);
    }

    @GetMapping
    public ResponseEntity<List<AuxilioGovernamental>> listar() {
        List<AuxilioGovernamental> auxilios = auxilioGovernamentalService.listarAuxilioGovernamentals();
        if (auxilios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(auxilios);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AuxilioGovernamental> atualizar(@PathVariable Integer id,
                                                          @RequestBody AuxilioGovernamental auxilio) {
        auxilio.setIdAuxilio(id);
        AuxilioGovernamental atualizado = auxilioGovernamentalService.atualizarAuxilioGovernamental(auxilio);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        auxilioGovernamentalService.removerAuxilioGovernamentalPorId(id);
        return ResponseEntity.noContent().build();
    }
}
