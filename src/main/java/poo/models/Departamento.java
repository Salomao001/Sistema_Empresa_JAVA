package poo.models;

import javax.persistence.*;
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

    public Departamento(String _nome, Empresa _empresa) {
        this.nome = _nome;
        this.empresa = _empresa;
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

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    public Empresa getEmpresa() {
        return this.empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
