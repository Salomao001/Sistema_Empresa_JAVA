package poo.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    private String descricao;

    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL)
    private List<Funcionario> funcionarios;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    public Projeto(){}

    public Projeto(String _nome, String _descricao, Departamento _departamento){
        this.nome = _nome;
        this.descricao = _descricao;
        this.departamento = _departamento;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}
