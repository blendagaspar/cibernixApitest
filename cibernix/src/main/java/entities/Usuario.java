package entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="td-usuario")
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

    @OneToMany(mappedBy = "td_usuario", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("td_usuario")
    private List<Endereço> endereço;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Endereço> getEndereço() {
        return endereço;
    }

    public void setEndereço(List<Endereço> endereço) {
        this.endereço = endereço;
    }
}
