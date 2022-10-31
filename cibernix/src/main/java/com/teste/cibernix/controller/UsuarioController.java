package com.teste.cibernix.controller;

import com.teste.cibernix.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.teste.cibernix.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/usuario")
public class UsuarioController {


    @Autowired
    private UsuarioRepository usuarioRepository;



    @GetMapping()
    public ResponseEntity<List<Usuario>> listarTodosUsuarios() {
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> listarUsuarioPorId(@PathVariable long id){
        return usuarioRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{nome}")
    public ResponseEntity<Usuario> listarUsuarioPorNome(@PathVariable String nome){
        return usuarioRepository.findByNome(nome).map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Usuario> criarUsuario (@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
    }

    @PutMapping("/atualizar_usuario")
    public ResponseEntity<Usuario> atualizarUsuario (@RequestBody Usuario usuario){

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
