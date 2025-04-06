package tech4good.cruds.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech4good.cruds.entity.Beneficiado;
import tech4good.cruds.repository.BeneficiadoRepository;
import tech4good.cruds.service.BeneficiadoService;

import java.util.List;

@RestController
@RequestMapping("/beneficiados")
public class BeneficiadoController {

    private final BeneficiadoService beneficiadoService;

    public BeneficiadoController(BeneficiadoService beneficiadoService) {
        this.beneficiadoService = beneficiadoService;
    }

    /*
    @PostMapping
    public ResponseEntity<Beneficiado> cadastrar(
            @RequestBody Beneficiado beneficiadoParaCadastrar
    ) {
        Beneficiado beneficiadoRegistrado = repository.save(beneficiadoParaCadastrar);
        return ResponseEntity.status(201).body(beneficiadoRegistrado);
    }

    @GetMapping
    public ResponseEntity<List<Beneficiado>> listar() {
        List<Beneficiado> beneficiados = repository.findAll();

        if (beneficiados.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(beneficiados);
    }

    @PatchMapping("/{cpf}")
    public ResponseEntity<Beneficiado> atualizar(
            @RequestBody Beneficiado beneficiadoNovo, @PathVariable String cpf
    ) {
        if (repository.existsById(cpf)) {
            beneficiadoNovo.setCpf(cpf);
            Beneficiado beneficiadoAlterado = repository.save(beneficiadoNovo);
            return ResponseEntity.status(200).body(beneficiadoAlterado);
        }

        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> deletar(
            @PathVariable String cpf
    ) {
        if (repository.existsById(cpf)) {
            repository.deleteById(cpf);
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(404).build();
    }
    */

}
