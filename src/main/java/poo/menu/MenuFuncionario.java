package poo.menu;

import poo.App;
import poo.repository.repositoryFuncionario;

import java.util.Scanner;

public class MenuFuncionario {
    private static Scanner scanner = new Scanner(System.in);

    public static void exibirMenuFuncionario()
    {
        App.clearConsole();

        System.out.println("++++++Menu+de+Operações++++++");
        System.out.println("| 1 - Cadastrar funcionario |");
        System.out.println("| 2 - Listar funcionarios   |");
        System.out.println("| 3 - Editar funcionario    |");
        System.out.println("| 4 - Remover funcionario   |");
        System.out.println("| 9 - voltar                |");
        System.out.println("| 0 - Sair                  |");
        System.out.println("+++++++++++++++++++++++++++++");
        System.out.print("Escolha a opção: ");

        try {
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao)
            {
                case 1: repositoryFuncionario.setFuncionario(); break;
                case 2: repositoryFuncionario.get(); break;
                case 3: repositoryFuncionario.update(); break;
                case 4: repositoryFuncionario.Delete(); break;
                case 9: Menu.exibirMenu(); break;
                case 0: System.exit(0); break;
            }
        }
        catch (Exception e)
        {
            scanner.nextLine();
            exibirMenuFuncionario();
        }
    }
}
