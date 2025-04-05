package tech4good.cruds.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech4good.cruds.repository.BeneficiarioRepository;
import tech4good.cruds.entity.Beneficiario;

import java.util.List;

@RestController
@RequestMapping("/beneficiarios")
public class BeneficiarioController {

    private final BeneficiarioRepository repository;

    public BeneficiarioController(BeneficiarioRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Beneficiario> cadastrar(@RequestBody Beneficiario beneficiarioParaCadastrar) {
        Beneficiario beneficiarioRegistrado = repository.save(beneficiarioParaCadastrar);
        return ResponseEntity.status(201).body(beneficiarioRegistrado);
    }

    @GetMapping
    public ResponseEntity<List<Beneficiario>> listar() {
        List<Beneficiario> beneficiarios = repository.findAll();

        if (beneficiarios.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(beneficiarios);
    }

    @PatchMapping("/{cpf}")
    public ResponseEntity<Beneficiario> atualizar(@RequestBody Beneficiario beneficiarioNovo, @PathVariable String cpf) {
        if (repository.existsById(cpf)) {
            beneficiarioNovo.setCpf(cpf);
            Beneficiario beneficiarioAlterado = repository.save(beneficiarioNovo);
            return ResponseEntity.status(200).body(beneficiarioAlterado);
        }

        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> deletar(@PathVariable String cpf) {
        if (repository.existsById(cpf)) {
            repository.deleteById(cpf);
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(404).build();
    }

}
