package poo.menu;

import poo.App;
import poo.repository.repositoryProjeto;

import java.util.Scanner;

public class MenuProjeto {
    private static Scanner scanner = new Scanner(System.in);

    public static void exibirMenuProjeto()
    {
        App.clearConsole();

        System.out.println("++++++Menu+de+Operações++++++");
        System.out.println("| 1 - Cadastrar projeto     |");
        System.out.println("| 2 - Listar projetos       |");
        System.out.println("| 3 - Editar projeto        |");
        System.out.println("| 4 - Remover projeto       |");
        System.out.println("| 9 - voltar                |");
        System.out.println("| 0 - Sair                  |");
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.print("Escolha a opção: ");

        try {
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao)
            {
                case 1: repositoryProjeto.setProjeto(); break;
                case 2: repositoryProjeto.get(); break;
                case 3: repositoryProjeto.update(); break;
                case 4: repositoryProjeto.Delete(); break;
                case 9: Menu.exibirMenu(); break;
                case 0: System.exit(0); break;
            }
        }
        catch (Exception e)
        {
            scanner.nextLine();
            exibirMenuProjeto();
        }
    }
}
