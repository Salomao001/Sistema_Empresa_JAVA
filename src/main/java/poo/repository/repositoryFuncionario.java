package poo.repository;

import poo.App;
import poo.DAO.DepartamentoDAO;
import poo.DAO.FuncionarioDAO;
import poo.DAO.ProjetoDAO;
import poo.menu.MenuFuncionario;
import poo.models.Departamento;
import poo.models.Funcionario;
import poo.models.Funcionario;
import poo.models.Projeto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class repositoryFuncionario {
    private static Scanner scanner = new Scanner(System.in);

    public static void get()
    {
        FuncionarioDAO context = new FuncionarioDAO();
        App.clearConsole();

        List<Funcionario> funcionarios = context.getAll();

        System.out.println("Funcionarios");
        System.out.println("--------------------------------------------------------------------------");
        for (Funcionario funcionario : funcionarios) {
            System.out.println("ID: " + funcionario.getId());
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Cargo: " + funcionario.getCargo());
            System.out.println("Salario: " + funcionario.getSalario());
            System.out.println("-----------------------------------------");
        }
        scanner.nextLine();
        MenuFuncionario.exibirMenuFuncionario();
    }

    public static void setFuncionario() throws InterruptedException {
        FuncionarioDAO context = new FuncionarioDAO();
        DepartamentoDAO _context = new DepartamentoDAO();
        ProjetoDAO __context = new ProjetoDAO();
        App.clearConsole();
        List<Integer> departamentos = new ArrayList<>();
        List<Integer> projetos = new ArrayList<>();

        for (Departamento item : _context.getAll()) {
            departamentos.add(item.getId());
        }
        for (Projeto item : __context.getAll())
        {
            projetos.add(item.getId());
        }

        try{
            System.out.println("Nome do funcionario: ");
            String nome = scanner.nextLine();
            System.out.println("Cargo do funcionario: ");
            String cargo = scanner.nextLine();
            System.out.println("Salario: ");
            double salario = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("ID do departamento: ");
            int id_dep = scanner.nextInt();
            scanner.nextLine();
            System.out.println("ID do projeto: ");
            int id_pro = scanner.nextInt();

            if (!departamentos.contains(id_dep) || !projetos.contains(id_pro))
            {
                System.out.println("ID inválido");
                Thread.sleep(2000);
                MenuFuncionario.exibirMenuFuncionario();
            }

            Departamento departamento = context.getDepartamento(id_dep);
            Projeto projeto = context.getProjeto(id_pro);

            Funcionario funcionario = new Funcionario(nome, cargo, salario,departamento, projeto);
            context.salvarFuncionario(funcionario);

            System.out.println("Funcionario cadastrado");
            Thread.sleep(2000);
            MenuFuncionario.exibirMenuFuncionario();

        } catch (Exception e)
        {
            scanner.nextLine();
            System.out.println("Erro na operação");
            Thread.sleep(2000);
            MenuFuncionario.exibirMenuFuncionario();
        }
    }

    public static void update() throws InterruptedException {
        FuncionarioDAO context = new FuncionarioDAO();
        DepartamentoDAO _context = new DepartamentoDAO();
        ProjetoDAO __context = new ProjetoDAO();
        App.clearConsole();
        List<Integer> departamentos = new ArrayList<>();
        List<Integer> projetos = new ArrayList<>();

        for (Departamento item : _context.getAll()) {
            departamentos.add(item.getId());
        }
        for (Projeto item : __context.getAll())
        {
            projetos.add(item.getId());
        }
        App.clearConsole();

        try
        {
            System.out.println("ID do funcionario a ser alterado");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Alterar nome: ");
            String nome = scanner.nextLine();
            System.out.println("Novo cargo: ");
            String cargo = scanner.nextLine();
            System.out.println("Novo Salario: ");
            double salario = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("ID do novo departamento: ");
            int id_dep = scanner.nextInt();
            scanner.nextLine();
            System.out.println("ID do novo projeto: ");
            int id_pro = scanner.nextInt();
            scanner.nextLine();

            if (!departamentos.contains(id_dep) || !projetos.contains(id_pro))
            {
                System.out.println("ID inválido");
                Thread.sleep(2000);
                MenuFuncionario.exibirMenuFuncionario();
            }

            Departamento departamento = context.getDepartamento(id_dep);
            Projeto projeto = context.getProjeto(id_pro);


            Funcionario funcionario = context.getFuncionarioById(id);
            funcionario.setNome(nome);
            funcionario.setCargo(cargo);
            funcionario.setSalario(salario);
            funcionario.setDepartamento(departamento);
            funcionario.setProjeto(projeto);
            context.atualizarFuncionario(funcionario);



            System.out.println("Funcionario atualizado com sucesso!");
            Thread.sleep(2000);
            MenuFuncionario.exibirMenuFuncionario();
        } catch (Exception e)
        {
            scanner.nextLine();
            System.out.println("Não foi possivel realizar a operação");
            Thread.sleep(2000);
            MenuFuncionario.exibirMenuFuncionario();
        }
    }

    public static void Delete() throws InterruptedException {
        FuncionarioDAO context = new FuncionarioDAO();
        App.clearConsole();
        try {
            System.out.println("ID do funcionario a ser excluido: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Funcionario funcionario = context.getFuncionarioById(id);
            context.deletarFuncionario(funcionario);

            System.out.println("Funcionario removido com sucesso!");
            Thread.sleep(2000);
            MenuFuncionario.exibirMenuFuncionario();
        }
        catch (Exception e)
        {
            System.out.println("Não foi possivel realizar a operação");
            Thread.sleep(2000);
            MenuFuncionario.exibirMenuFuncionario();
        }
    }
}
