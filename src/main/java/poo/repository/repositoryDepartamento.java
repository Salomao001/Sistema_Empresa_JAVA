package poo.repository;

import org.hibernate.Hibernate;
import poo.App;
import poo.DAO.DepartamentoDAO;
import poo.DAO.EmpresaDAO;
import poo.menu.MenuDepartamento;
import poo.models.Departamento;
import poo.models.Empresa;
import poo.models.Funcionario;
import poo.models.Projeto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class repositoryDepartamento {
    private static Scanner scanner = new Scanner(System.in);

    public static void get()
    {
        DepartamentoDAO context = new DepartamentoDAO();
        App.clearConsole();

        List<Departamento> departamentos = context.getAll();

        System.out.println("Departamentos");
        System.out.println("--------------------------------------------------------------------------");
        for (Departamento departamento : departamentos) {
            System.out.println("ID: " + departamento.getId());
            System.out.println("Nome: " + departamento.getNome());

            if (!departamento.getFuncionarios().isEmpty()) {
                System.out.println("Funcionarios");
                for (Funcionario funcionario : departamento.getFuncionarios()) {
                    System.out.println("  - Funcionario: " + funcionario.getNome());
                }
            }
            if (!departamento.getProjetos().isEmpty())
                {
                    System.out.println("Projetos");
                    for (Projeto projeto : departamento.getProjetos())
                    {
                        System.out.println("  - Projeto: " + projeto.getNome());
                    }
                }
            System.out.println("-----------------------------------------");
        }
        scanner.nextLine();
        MenuDepartamento.exibirMenuDepartamento();
    }

    public static void setDepartamento() throws InterruptedException {
        DepartamentoDAO context = new DepartamentoDAO();
        EmpresaDAO _context = new EmpresaDAO();
        App.clearConsole();
        List<Integer> empresas = new ArrayList<>();

        for (Empresa item : _context.getAll()) {
            empresas.add(item.getId());
        }

        try{
            System.out.println("Nome do departamento: ");
            String nome = scanner.next();
            System.out.println("ID da empresa responsavel");
            int id = scanner.nextInt();

            if (!empresas.contains(id))
            {
                System.out.println("ID inválido");
                Thread.sleep(2000);
                MenuDepartamento.exibirMenuDepartamento();
            }

            Empresa empresa = context.getEmpresa(id);

            Departamento departamento = new Departamento(nome, empresa);
            context.salvarDepartamento(departamento);

            System.out.println("Departamento cadastrado");
            Thread.sleep(2000);
            MenuDepartamento.exibirMenuDepartamento();

        } catch (Exception e)
        {
            scanner.nextLine();
            System.out.println("Erro na operação");
            Thread.sleep(2000);
            MenuDepartamento.exibirMenuDepartamento();
        }
    }

    public static void update() throws InterruptedException {
        DepartamentoDAO context = new DepartamentoDAO();
        App.clearConsole();

        try
        {
            System.out.println("ID do departamento a ser alterado");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Novo nome do departamento: ");
            String nome = scanner.next();

            Departamento departamento = context.getDepartamentoById(id);
            departamento.setNome(nome);
            context.atualizarDepartamento(departamento);

            System.out.println("Departamento atualizado com sucesso!");
            Thread.sleep(2000);
            MenuDepartamento.exibirMenuDepartamento();
        } catch (Exception e)
        {
            scanner.nextLine();
            System.out.println("Não foi possivel realizar a operação");
            Thread.sleep(2000);
            MenuDepartamento.exibirMenuDepartamento();
        }
    }

    public static void Delete() throws InterruptedException {
        DepartamentoDAO context = new DepartamentoDAO();
        App.clearConsole();
        try {
            System.out.println("ID do departamento a ser excluido: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Departamento departamento = context.getDepartamentoById(id);
            context.deletarDepartamento(departamento);

            System.out.println("Departamento removido com sucesso!");
            Thread.sleep(2000);
            MenuDepartamento.exibirMenuDepartamento();
        }
        catch (Exception e)
        {
            System.out.println("Não foi possivel realizar a operação");
            Thread.sleep(2000);
            MenuDepartamento.exibirMenuDepartamento();
        }
    }
}
