package poo.repository;

import poo.App;
import poo.DAO.DepartamentoDAO;
import poo.DAO.ProjetoDAO;
import poo.menu.MenuProjeto;
import poo.models.Departamento;
import poo.models.Funcionario;
import poo.models.Projeto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class repositoryProjeto {
    private static Scanner scanner = new Scanner(System.in);

    public static void get()
    {
        ProjetoDAO context = new ProjetoDAO();
        App.clearConsole();

        List<Projeto> projetos = context.getAll();

        System.out.println("Projetos");
        System.out.println("--------------------------------------------------------------------------");
        for (Projeto projeto : projetos) {
            System.out.println("ID: " + projeto.getId());
            System.out.println("Nome: " + projeto.getNome());
            System.out.println("Descrição: " + projeto.getDescricao());

            if (!projeto.getFuncionarios().isEmpty()) {
                System.out.println("Responsaveis");
                for (Funcionario funcionario : projeto.getFuncionarios()) {
                    System.out.println("  - Responsavel: " + funcionario.getNome());
                }
            }
            System.out.println("-----------------------------------------");
        }
        scanner.nextLine();
        MenuProjeto.exibirMenuProjeto();
    }

    public static void setProjeto() throws InterruptedException {
        ProjetoDAO context = new ProjetoDAO();
        DepartamentoDAO _context = new DepartamentoDAO();
        App.clearConsole();
        List<Integer> departamentos = new ArrayList<>();

        for (Departamento item : _context.getAll()) {
            departamentos.add(item.getId());
        }

        try{
            System.out.println("Nome do projeto: ");
            String nome = scanner.nextLine();
            System.out.println("Descrição do projeto: ");
            String desc = scanner.nextLine();
            System.out.println("ID do departamento: ");
            int id = scanner.nextInt();

            if (!departamentos.contains(id))
            {
                System.out.println("ID inválido");
                Thread.sleep(2000);
                MenuProjeto.exibirMenuProjeto();
            }

            Departamento departamento = context.getDepartamento(id);

            Projeto projeto = new Projeto(nome, desc, departamento);
            context.salvarProjeto(projeto);

            System.out.println("Projeto cadastrado");
            Thread.sleep(2000);
            MenuProjeto.exibirMenuProjeto();

        } catch (Exception e)
        {
            scanner.nextLine();
            System.out.println("Erro na operação");
            Thread.sleep(2000);
            MenuProjeto.exibirMenuProjeto();
        }
    }

    public static void update() throws InterruptedException {
        ProjetoDAO context = new ProjetoDAO();
        App.clearConsole();

        try
        {
            System.out.println("ID do projeto a ser alterado");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Novo nome do projeto: ");
            String nome = scanner.nextLine();
            System.out.println("Nova Descrição: ");
            String desc = scanner.nextLine();

            Projeto projeto = context.getProjetoById(id);
            projeto.setNome(nome);
            projeto.setDescricao(desc);
            context.atualizarProjeto(projeto);

            System.out.println("Projeto atualizado com sucesso!");
            Thread.sleep(2000);
            MenuProjeto.exibirMenuProjeto();
        } catch (Exception e)
        {
            scanner.nextLine();
            System.out.println("Não foi possivel realizar a operação");
            Thread.sleep(2000);
            MenuProjeto.exibirMenuProjeto();
        }
    }

    public static void Delete() throws InterruptedException {
        ProjetoDAO context = new ProjetoDAO();
        App.clearConsole();
        try {
            System.out.println("ID do projeto a ser excluido: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Projeto projeto = context.getProjetoById(id);
            context.deletarProjeto(projeto);

            System.out.println("Projeto removido com sucesso!");
            Thread.sleep(2000);
            MenuProjeto.exibirMenuProjeto();
        }
        catch (Exception e)
        {
            System.out.println("Não foi possivel realizar a operação");
            Thread.sleep(2000);
            MenuProjeto.exibirMenuProjeto();
        }
    }
}
