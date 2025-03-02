package school.sptech.crudproduto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrar(@RequestBody Produto produtoParaCadastrar) {
        Produto produtoCadastrado = repository.save(produtoParaCadastrar);

        return ResponseEntity.status(201).body(produtoCadastrado);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listar() {
        List<Produto> produtosEncontrados = repository.findAll();

        if (produtosEncontrados.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(produtosEncontrados);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@RequestBody Produto produtoNovo, @PathVariable Integer id) {
        if (repository.existsById(id)) {
            produtoNovo.setId(id);
            Produto produtoAlterado = repository.save(produtoNovo);

            return ResponseEntity.status(200).body(produtoAlterado);
        }

        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);

            return ResponseEntity.status(200).build();
        }

        return ResponseEntity.status(404).build();
    }
}
