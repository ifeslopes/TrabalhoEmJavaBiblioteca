package menu;

import java.util.Scanner;

public class MenuPricipal {


    public static void menuPrincipal() {

        Scanner entrada = new Scanner(System.in);

        while (true) {

            System.out.println("\n:: B I B L I O T E C A ::\n");
            System.out.println("Bem-vindo(a) ao sistem. " + "Escolha a opção desejada");
            System.out.println("1 - Cadastro de Usuarios");
            System.out.println("2 - Sair");

            // lê a opção do usuário
            int opcao = Integer.parseInt(entrada.nextLine());

            switch (opcao) {
                case 1:
                    // chama o menu de gerenciamento de livros
                    MenuCadastroDeusuario.menuCadastroDeusuario();
                    break;


                case 2:
                    System.out.println("\n Sistema finalizado! \n");
                    System.exit(0);
            }
        }
    }
}