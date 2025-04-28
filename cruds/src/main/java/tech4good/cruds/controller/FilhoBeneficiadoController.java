package tech4good.cruds.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech4good.cruds.entity.FilhoBeneficiado;
import tech4good.cruds.service.FilhoBeneficiadoService;

import java.util.List;

@RestController
@RequestMapping("/filhos-beneficiados")
public class FilhoBeneficiadoController {

    private final FilhoBeneficiadoService filhoBeneficiadoService;

    public FilhoBeneficiadoController(FilhoBeneficiadoService filhoBeneficiadoService) {
        this.filhoBeneficiadoService = filhoBeneficiadoService;
    }

    @PostMapping
    public ResponseEntity<FilhoBeneficiado> cadastrar(
            @RequestBody FilhoBeneficiado filhoBeneficiado) {
        FilhoBeneficiado novoFilho = filhoBeneficiadoService.cadastrarFilhoBeneficiado(filhoBeneficiado);
        return ResponseEntity.status(201).body(novoFilho);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilhoBeneficiado> buscarPorId(@PathVariable Integer id) {
        FilhoBeneficiado filho = filhoBeneficiadoService.buscarFilhoBeneficiadoPorId(id);
        return ResponseEntity.ok(filho);
    }

    @GetMapping
    public ResponseEntity<List<FilhoBeneficiado>> listar() {
        List<FilhoBeneficiado> filhos = filhoBeneficiadoService.listarFilhosBeneficiados();
        return filhos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(filhos);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<FilhoBeneficiado> atualizar(
            @PathVariable Integer id,
            @RequestBody FilhoBeneficiado filhoBeneficiado) {
        filhoBeneficiado.setIdFilhoBeneficiado(id);
        FilhoBeneficiado filhoAtualizado = filhoBeneficiadoService.atualizarFilhoBeneficiado(filhoBeneficiado);
        return ResponseEntity.ok(filhoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        filhoBeneficiadoService.removerFilhoBeneficiadoPorId(id);
        return ResponseEntity.noContent().build();
    }
}