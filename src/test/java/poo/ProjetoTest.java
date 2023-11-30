package poo;

import org.junit.jupiter.api.Test;

import poo.models.Departamento;
import poo.models.Empresa;
import poo.models.Projeto;

import static org.junit.jupiter.api.Assertions.*;

public class ProjetoTest {

    @Test
    public void testGetAndSetNome() {
        Projeto projeto = new Projeto();
        projeto.setNome("TestNome");
        assertEquals("TestNome", projeto.getNome());
    }

    @Test
    public void testGetAndSetDescricao() {
        Projeto projeto = new Projeto();
        projeto.setDescricao("TestDescricao");
        assertEquals("TestDescricao", projeto.getDescricao());
    }

    @Test
    public void testConstructor() {
        Empresa empresa = new Empresa();
        Departamento departamento = new Departamento("teste", empresa);
        Projeto projeto = new Projeto("TestNome", "TestDescricao", departamento);

        assertEquals("TestNome", projeto.getNome());
        assertEquals("TestDescricao", projeto.getDescricao());
        assertEquals(departamento, projeto.getDepartamento());
    }
}
