package poo.menu;

import poo.App;

import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    public static void exibirMenu()
    {
        App.clearConsole();

        System.out.println("++++++++++Menu++++++++++");
        System.out.println("| O que deseja operar? |");
        System.out.println("| 1 - Empresa          |");
        System.out.println("| 2 - Departamento     |");
        System.out.println("| 3 - Projeto          |");
        System.out.println("| 4 - Funcionario      |");
        System.out.println("| 0 - Sair             |");
        System.out.println("++++++++++++++++++++++++");
        System.out.print("Escolha a opção: ");
        int opcao = 0;
        try {
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao)
            {

                case 1: MenuEmpresa.exibirMenuEmpresa(); break;
                case 2: MenuDepartamento.exibirMenuDepartamento(); break;
                case 3: MenuProjeto.exibirMenuProjeto(); break;
                case 4: MenuFuncionario.exibirMenuFuncionario(); break;
                case 0: System.exit(0); break;
                default: exibirMenu(); break;
            }
        }
        catch (Exception e)
        {
            scanner.nextLine();
            exibirMenu();
        }
    }
}
