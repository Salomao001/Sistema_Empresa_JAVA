package poo;

import org.junit.jupiter.api.Test;

import poo.models.Departamento;
import poo.models.Funcionario;
import poo.models.Projeto;

import static org.junit.jupiter.api.Assertions.*;

public class FuncionarioTest {

    @Test
    public void testGetAndSetNome() {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("TestNome");
        assertEquals("TestNome", funcionario.getNome());
    }

    @Test
    public void testGetAndSetCargo() {
        Funcionario funcionario = new Funcionario();
        funcionario.setCargo("TestCargo");
        assertEquals("TestCargo", funcionario.getCargo());
    }

    @Test
    public void testGetAndSetSalario() {
        Funcionario funcionario = new Funcionario();
        funcionario.setSalario(1000.0);
        assertEquals(1000.0, funcionario.getSalario(), 0.001);
    }

    @Test
    public void testConstructor() {
        Departamento departamento = new Departamento();
        Projeto projeto = new Projeto();
        Funcionario funcionario = new Funcionario("TestNome", "TestCargo", 1000.0, departamento, projeto);

        assertEquals("TestNome", funcionario.getNome());
        assertEquals("TestCargo", funcionario.getCargo());
        assertEquals(1000.0, funcionario.getSalario(), 0.001);
        assertEquals(departamento, funcionario.getDepartamento());
        assertEquals(projeto, funcionario.getProjeto());
    }
}
