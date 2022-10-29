package repository;


import entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

     public Optional<Usuario> findByUsuario(String id);

     public List<Usuario> findAll();


}
