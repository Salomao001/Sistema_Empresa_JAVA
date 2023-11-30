package poo.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
    private List<Funcionario> funcionarios;

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
    private List<Projeto> projetos;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public Departamento() {
    }

    public Departamento(String _nome, Empresa _empresa){
        this.nome = _nome;
        this.empresa = _empresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String _nome) {
        this.nome = _nome;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public int getId() {
        return id;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }
    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }
}
