package poo.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Empresa {
    public int getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private List<Departamento> departamentos;

    public Empresa(){}

    public Empresa(String _nome){
        this.nome = _nome;
    }

    public String getNome()
    {
        return this.nome;
    }

    public void setNome(String _nome)
    {
        this.nome = _nome;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }
}
