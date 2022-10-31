package com.teste.cibernix.entities;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name="usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String nome ;

    @NotNull
    private String idade;

    @NotNull
    private String cpf;

    @NotNull
    private String email;

    private String endereco;

    public  Usuario(
            final String nome,
            final String idade ,
            final String cpf,
            final String email,
            final String endereco ) {

       this.nome = nome;
       this.idade = idade;
       this.cpf = cpf;
       this.email = email;
       this.endereco = endereco;
    }

}
