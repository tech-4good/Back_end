package tech4good.cruds.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech4good.cruds.entity.Beneficiado;
import tech4good.cruds.service.BeneficiadoService;

import java.util.List;

@RestController
@RequestMapping("/beneficiados")
public class BeneficiadoController {

    private final BeneficiadoService beneficiadoService;

    public BeneficiadoController(BeneficiadoService beneficiadoService) {
        this.beneficiadoService = beneficiadoService;
    }

    @PostMapping
    public ResponseEntity<Beneficiado> cadastrar(
            @RequestBody Beneficiado beneficiadoParaCadastrar
    ) {
        Beneficiado beneficiadoRegistrado = beneficiadoService.cadastrarBeneficiado(beneficiadoParaCadastrar);
        return ResponseEntity.status(201).body(beneficiadoRegistrado);
    }

    @GetMapping
    public ResponseEntity<List<Beneficiado>> listar() {
        List<Beneficiado> beneficiados = beneficiadoService.listarBeneficiados();
        if (beneficiados.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(beneficiados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Beneficiado> buscarPorId(@PathVariable Integer id) {
        Beneficiado beneficiadoEncontrado = beneficiadoService.buscarBeneficiadoPorId(id);
        return ResponseEntity.status(200).body(beneficiadoEncontrado);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Beneficiado> buscarPorCpf(@PathVariable String cpf) {
        Beneficiado beneficiadoEncontrado = beneficiadoService.buscarBeneficiadoPorCpf(cpf);
        return ResponseEntity.status(200).body(beneficiadoEncontrado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Beneficiado> atualizar(@RequestBody Beneficiado beneficiadoNovo, @PathVariable Integer id) {
        beneficiadoNovo.getId().setIdBeneficiado(id);
        Beneficiado beneficiadoAlterado = beneficiadoService.atualizarBeneficiado(beneficiadoNovo);
        return ResponseEntity.status(200).body(beneficiadoAlterado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        beneficiadoService.removerBeneficiadoPorId(id);
        return ResponseEntity.status(204).build();
    }
}
