package poo;

import org.junit.jupiter.api.Test;

import poo.models.Departamento;
import poo.models.Empresa;
import poo.models.Funcionario;
import poo.models.Projeto;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class DepartamentoTest {

    @Test
    // Cria um departamento, seta um novo nome e verifica se o nome está correto
    // usando o get
    public void testGetAndSetNome() {
        Departamento departamento = new Departamento();
        departamento.setNome("TestNome");
        assertEquals("TestNome", departamento.getNome());
    }

    @Test
    // Cria um novo departamento, cria uma lista de elementos/objetos da classe/tipo
    // Projeto, chamada projetos, cria um novo projeto, adiciona o projeto criado na
    // lista chamada projetos, vincula/seta o projeto ao departamento criado e
    // depois
    // verifica se a lista projetos eh igual a lista de projetos retornada pelo
    // departamento
    public void testGetAndSetProjetos() {
        Departamento departamento = new Departamento();
        List<Projeto> projetos = new ArrayList<>();
        Projeto projeto = new Projeto();
        projetos.add(projeto);
        departamento.setProjetos(projetos);
        assertEquals(projetos, departamento.getProjetos());
    }

    @Test
    // Cria um novo departamento, cria um projeto, cria uma lista de funcionarios
    // chamada funcionarios, cria um novo funcionario
    // Este funcionario criado eh, de acordo com o construtor do mesmo, vinculado a
    // um projeto e departamento, adiciona este novo funcionario a lista de
    // funcionarios e verifica se a lista de funcionarios criada eh igual a lista de
    // funcionarios retornada pelo departamento
    public void testGetAndSetFuncionarios() {
        Departamento departamento = new Departamento();
        Projeto projeto = new Projeto();
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        Funcionario funcionario = new Funcionario("fulano", "caixa", 1000.0, departamento, projeto);
        funcionarios.add(funcionario);
        assertEquals(funcionarios, departamento.getFuncionarios());
    }

    @Test
    public void testConstructor() {
        Empresa empresa = new Empresa();
        Departamento departamento = new Departamento("nomeDoDepartamento", empresa);

        assertEquals("nomeDoDepartamento", departamento.getNome());
        assertEquals(empresa, departamento.getEmpresa());
    }
}
