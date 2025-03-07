package tech4good.cruds.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuarioParaCadastrar) {
        Usuario usuarioRegistrado = repository.save(usuarioParaCadastrar);
        return ResponseEntity.status(201).body(usuarioRegistrado);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        List<Usuario> usuarios = repository.findAll();

        if (usuarios.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(usuarios);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@RequestBody Usuario novoUsuario, @PathVariable Integer id) {
        if(repository.existsById(id)) {
            novoUsuario.setId(id);
            Usuario usuarioAlterado = repository.save(novoUsuario);
            return ResponseEntity.status(200).body(usuarioAlterado);
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

