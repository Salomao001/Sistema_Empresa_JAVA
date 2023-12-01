package poo.models;

import javax.persistence.*;
import javax.persistence.Id;

@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String cargo;
    private double salario;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;

    public Funcionario() {
    }

    public Funcionario(String _nome, String _cargo, double _salario, Departamento _departamento, Projeto _projeto) {
        this.nome = _nome;
        this.cargo = _cargo;
        this.salario = _salario;
        this.departamento = _departamento;
        this.projeto = _projeto;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String _cargo) {
        this.cargo = _cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double _salario) {
        this.salario = _salario;
    }

    public void setDepartamento(Departamento _departamento) {
        this.departamento = _departamento;
    }

    public void setProjeto(Projeto _projeto) {
        this.projeto = _projeto;
    }

    public Departamento getDepartamento() {
        return this.departamento;
    }

    public Projeto getProjeto() {
        return this.projeto;
    }

}
