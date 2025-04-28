package tech4good.cruds.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech4good.cruds.entity.Endereco;
import tech4good.cruds.service.EnderecoService;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @PostMapping
    public ResponseEntity<Endereco> cadastrar(
            @RequestBody Endereco enderecoParaCadastrar
    ) {
        Endereco enderecoRegistrado = enderecoService.cadastrarEndereco(enderecoParaCadastrar);
        return ResponseEntity.status(201).body(enderecoRegistrado);
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> listar() {
        List<Endereco> enderecos = enderecoService.listarEnderecos();
        if (enderecos.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(enderecos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> buscarPorId(@PathVariable Integer id) {
        Endereco enderecoEncontrado = enderecoService.listarEnderecoPorId(id);
        return ResponseEntity.status(200).body(enderecoEncontrado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Endereco> atualizar(
            @RequestBody Endereco enderecoNovo,
            @PathVariable Integer id
    ) {
        enderecoNovo.setIdEndereco(id);
        Endereco enderecoAlterado = enderecoService.atualizarEndereco(enderecoNovo);
        return ResponseEntity.status(200).body(enderecoAlterado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        enderecoService.removerEnderecoPorId(id);
        return ResponseEntity.status(204).build();
    }
}