package poo.menu;

import poo.App;
import poo.repository.repositoryDepartamento;

import java.util.Scanner;

public class MenuDepartamento {
    private static Scanner scanner = new Scanner(System.in);

    public static void exibirMenuDepartamento()
    {
        App.clearConsole();

        System.out.println("++++++Menu+de+Operações++++++");
        System.out.println("| 1 - Cadastrar departamento |");
        System.out.println("| 2 - Listar Departamentos   |");
        System.out.println("| 3 - Editar departamento    |");
        System.out.println("| 4 - Remover departamento   |");
        System.out.println("| 9 - voltar                 |");
        System.out.println("| 0 - Sair                   |");
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.print("Escolha a opção: ");

        try {
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao)
            {
                case 1: repositoryDepartamento.setDepartamento(); break;
                case 2: repositoryDepartamento.get(); break;
                case 3: repositoryDepartamento.update(); break;
                case 4: repositoryDepartamento.Delete(); break;
                case 9: Menu.exibirMenu(); break;
                case 0: System.exit(0); break;
            }
        }
        catch (Exception e)
        {
            scanner.nextLine();
            exibirMenuDepartamento();
        }
    }
}
