package com.teste.cibernix.repository;


import com.teste.cibernix.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

     public Optional<Usuario> findByNome(String nome);

     public List<Usuario> findAll();


}
