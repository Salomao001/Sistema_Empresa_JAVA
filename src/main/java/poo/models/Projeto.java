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
        return nome;
    }

    public void setNome(String _nome) {
        this.nome = _nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String _descricao) {
        this.descricao = _descricao;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}
