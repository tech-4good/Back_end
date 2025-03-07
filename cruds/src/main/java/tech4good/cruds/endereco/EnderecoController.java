package tech4good.cruds.endereco;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    private final EnderecoRepository repository;

    public EnderecoController(EnderecoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Endereco> cadastrar(@RequestBody Endereco enderecoParaCadastrar) {
        Endereco enderecoRegistrado = repository.save(enderecoParaCadastrar);
        return ResponseEntity.status(201).body(enderecoRegistrado);
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> listar() {
        List<Endereco> enderecos = repository.findAll();

        if (enderecos.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(enderecos);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Endereco> atualizar(@RequestBody Endereco enderecoNovo, @PathVariable Integer id) {
        if (repository.existsById(id)) {
            enderecoNovo.setId(id);
            Endereco enderecoAlterado = repository.save(enderecoNovo);
            return ResponseEntity.status(200).body(enderecoAlterado);
        }

        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(404).build();
    }
}
