package tech4good.cruds.cesta;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cestas")
public class CestaController {

    private final CestaRepository repository;

    public CestaController(CestaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Cesta> cadastrar(@RequestBody Cesta cestaParaCadastrar) {
        Cesta cestaCadastrada = repository.save(cestaParaCadastrar);

        return ResponseEntity.status(201).body(cestaCadastrada);
    }

    @GetMapping
    public ResponseEntity<List<Cesta>> listar() {
        List<Cesta> cestasEncontradas = repository.findAll();

        if (cestasEncontradas.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(cestasEncontradas);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Cesta> atualizar(@RequestBody Cesta cestaNova, @PathVariable Integer id) {
        if (repository.existsById(id)) {
            cestaNova.setId(id);
            Cesta cestaAlterada = repository.save(cestaNova);

            return ResponseEntity.status(200).body(cestaAlterada);
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

