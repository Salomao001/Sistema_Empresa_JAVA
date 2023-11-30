package poo;

import org.junit.jupiter.api.Test;

import poo.models.Departamento;
import poo.models.Empresa;
import static org.junit.jupiter.api.Assertions.*;

public class EmpresaTest {

    @Test
    public void testGetAndSetNome() {
        Empresa empresa = new Empresa();
        empresa.setNome("TestNome");
        assertEquals("TestNome", empresa.getNome());
    }

    @Test
    public void testConstructor() {
        Empresa empresa = new Empresa("TestNome");

        assertEquals("TestNome", empresa.getNome());
    }

    @Test
    // cria uma empresa, cria um departamento busca a lista de departamentos
    // vinculado a empresa (inicialmente deve ser tamanho 0 mas esta retornando
    // null) e adicionamos o departamento à empresa
    // Verifica se a lista de departamentos da empresa possui o departamento
    // adicionado (deveria retornar true)
    public void testGetDepartamentos() {
        Empresa empresa = new Empresa();
        Departamento departamento = new Departamento();
        empresa.getDepartamentos().add(departamento);

        assertTrue(empresa.getDepartamentos().contains(departamento));
    }

    @Test
    public void testGetId() {
        Empresa empresa = new Empresa();

        assertEquals(0, empresa.getId());
    }

}
