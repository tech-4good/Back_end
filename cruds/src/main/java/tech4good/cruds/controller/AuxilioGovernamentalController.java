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
        AuxilioGovernamental salvo = auxilioGovernamentalService.cadastrarAuxilioGovernamental(auxilio);
        return ResponseEntity.status(201).body(salvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuxilioGovernamental> buscarPorId(@PathVariable Integer id) {
        AuxilioGovernamental auxilio = auxilioGovernamentalService.buscarAuxilioGovernamentalPorId(id);
        return ResponseEntity.ok(auxilio);
    }

    @GetMapping
    public ResponseEntity<List<AuxilioGovernamental>> listar() {
        List<AuxilioGovernamental> lista = auxilioGovernamentalService.listarAuxilioGovernamentals();
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuxilioGovernamental> atualizar(@PathVariable Integer id,
                                                          @RequestBody AuxilioGovernamental auxilio) {
        auxilio.setIdAuxilio(id);
        AuxilioGovernamental atualizado = auxilioGovernamentalService.atualizarAuxilioGovernamental(auxilio);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        auxilioGovernamentalService.removerBeneficiadoPorId(id);
        return ResponseEntity.noContent().build();
    }
}
