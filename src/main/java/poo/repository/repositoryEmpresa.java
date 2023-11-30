package poo.repository;

import poo.DAO.EmpresaDAO;
import poo.App;
import poo.models.Departamento;
import poo.models.Empresa;
import java.lang.Thread;
import java.util.Scanner;
import poo.menu.MenuEmpresa;
import java.util.List;
public class repositoryEmpresa {
    private static Scanner scanner = new Scanner(System.in);
    public static void get()
    {
       EmpresaDAO context = new EmpresaDAO();
       App.clearConsole();



       List<Empresa> empresas = context.getAll();

       System.out.println("Empresas");
       System.out.println("-----------------------------------------");
        for (Empresa empresa : empresas) {
            System.out.println("ID: " + empresa.getId());
            System.out.println("Nome: " + empresa.getNome());

            if (empresa.getDepartamentos() != null) {
                System.out.println("Departamentos");
                for (Departamento departamento : empresa.getDepartamentos()) {
                    System.out.println("  - Departamento: " + departamento.getNome());
                }
            }
            System.out.println("-----------------------------------------");
        }

       scanner.nextLine();
       MenuEmpresa.exibirMenuEmpresa();
    }

    public static void setEmpresa() throws InterruptedException {
        EmpresaDAO context = new EmpresaDAO();
        App.clearConsole();

        try{
            System.out.println("Nome da empresa: ");
            String nome = scanner.nextLine();


            Empresa empresa = new Empresa(nome);
            context.salvarEmpresa(empresa);

            System.out.println("Empresa cadastrada");
            Thread.sleep(2000);
            MenuEmpresa.exibirMenuEmpresa();

        } catch (Exception e)
        {
            scanner.nextLine();
            System.out.println("Erro na operação");
            Thread.sleep(2000);
            MenuEmpresa.exibirMenuEmpresa();
        }
    }

    public static void update() throws InterruptedException {
        EmpresaDAO context = new EmpresaDAO();
        App.clearConsole();

        try
        {
            System.out.println("ID da empresa a ser alterada");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Novo nome da empresa: ");
            String nome = scanner.nextLine();

            Empresa empresa = context.getEmpresaById(id);
            empresa.setNome(nome);
            context.atualizarEmpresa(empresa);

            System.out.println("Empresa atualizada com sucesso!");
            Thread.sleep(2000);
            MenuEmpresa.exibirMenuEmpresa();
        } catch (Exception e)
        {
            scanner.nextLine();
            System.out.println("Não foi possivel realizar a operação");
            Thread.sleep(2000);
            MenuEmpresa.exibirMenuEmpresa();
        }
    }

    public static void Delete() throws InterruptedException {
        EmpresaDAO context = new EmpresaDAO();
        App.clearConsole();
        try {
            System.out.println("ID da empresa a ser excluida: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Empresa empresa = context.getEmpresaById(id);
            context.deletarEmpresa(empresa);

            System.out.println("Empresa removida com sucesso!");
            Thread.sleep(2000);
            MenuEmpresa.exibirMenuEmpresa();
        }
        catch (Exception e)
        {
            System.out.println("Não foi possivel realizar a operação");
            Thread.sleep(2000);
            MenuEmpresa.exibirMenuEmpresa();
        }
    }
}
