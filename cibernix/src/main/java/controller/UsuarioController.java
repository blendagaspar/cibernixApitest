package controller;

import entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/usuario")
public class UsuarioController {


    @Autowired
    private UsuarioRepository usuarioRepository;



    @GetMapping("/listar_todos_usuarios")
    public ResponseEntity<List<Usuario>> listarTodosUsuarios() {
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> listarUsuarioPorId(@PathVariable long id){
        return usuarioRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Usuario> postPostagem (@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
    }

    @PutMapping
    public ResponseEntity<Usuario> putPostagem (@RequestBody Usuario usuario){

        Optional<Usuario> postagemUpdate = usuarioRepository.findById(usuario.getId());

        if (postagemUpdate.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuario));
        }else{
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Usuário não encontrado!", null);
        }

    }

    @DeleteMapping("/{id}")
    public void apagarUsuario(@PathVariable long id) {

        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isPresent()) {
            usuarioRepository.findById(id);
        }else{
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Usuário não encontrado!",null);
        }
    }


}
