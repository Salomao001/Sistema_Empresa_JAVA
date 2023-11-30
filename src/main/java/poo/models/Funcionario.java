package poo.models;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.List;

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

    public Funcionario(){}

    public Funcionario(String _nome, String _cargo, double _salario, Departamento _departamento, Projeto _projeto)
    {
        this.nome = _nome;
        this.cargo = _cargo;
        this.salario = _salario;
        this.departamento = _departamento;
        this.projeto = _projeto;
    }

    public int getId()
    {
        return this.id;
    }

    public String getNome()
    {
        return this.nome;
    }

    public void setNome(String _nome)
    {
        this.nome = _nome;
    }

    public String getCargo()
    {
        return this.cargo;
    }

    public void setCargo(String _cargo)
    {
        this.cargo = _cargo;
    }

    public double getSalario()
    {
        return this.salario;
    }

    public void setSalario(double _salario)
    {
        this.salario = _salario;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
}
