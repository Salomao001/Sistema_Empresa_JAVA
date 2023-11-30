package poo.menu;

import poo.App;
import poo.repository.repositoryEmpresa;
import java.util.Scanner;

public class MenuEmpresa {
    private static Scanner scanner = new Scanner(System.in);
    public static void exibirMenuEmpresa()
    {
        App.clearConsole();

        System.out.println("++++++Menu+de+Operações++++++");
        System.out.println("| 1 - Cadastrar empresa      |");
        System.out.println("| 2 - Listar Empresas        |");
        System.out.println("| 3 - Editar empresa         |");
        System.out.println("| 4 - Remover empresa        |");
        System.out.println("| 9 - Voltar                 |");
        System.out.println("| 0 - Sair                   |");
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.print("Escolha a opção: ");

        try {
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao)
            {
                case 1: repositoryEmpresa.setEmpresa(); break;
                case 2: repositoryEmpresa.get(); break;
                case 3: repositoryEmpresa.update(); break;
                case 4: repositoryEmpresa.Delete(); break;
                case 9: Menu.exibirMenu(); break;
                case 0: System.exit(0);
            }
        }
        catch (Exception e)
        {
            scanner.nextLine();
            exibirMenuEmpresa();
        }
    }
}
