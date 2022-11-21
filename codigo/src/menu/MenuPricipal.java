package menu;

import utilitarios.Login;
import vetorclasses.EmprestimoVet;
import vetorclasses.LivroVet;

import java.util.Scanner;

public class MenuPricipal {


    public static void menuPrincipal() {

        Scanner entrada = new Scanner(System.in);

        while (true) {

            System.out.println("\n:: S I S T E M  B I B L I O T E C A ::");
            System.out.println("\n:: Voce esta logado : "+ Login.getNomeFuncionarioLogado()+" ::");
            System.out.println("Bem-vindo(a) ao sistem. " + "Escolha a opção desejada");
            System.out.println("1 - Cadastro de Usuarios");
            System.out.println("2 - Cadastro de Livros e Periodicos");
            System.out.println("3 - Emprestar Livros e Periodicos");
            System.out.println("4 - Sair");

            // lê a opção do usuário
            int opcao = Integer.parseInt(entrada.nextLine());

            switch (opcao) {
                case 1:
                    // chama o menu de cadastro de usuarios
                    MenuCadastroDeusuario.menuCadastroDeusuario();
                    break;
                case 2:
                    // chama o menu de gerenciamento de livros
                    LivroVet livroVet = new LivroVet();
                    livroVet.cadastra();
                    break;
                    case 3:
                    // chama o menu de gerenciamento de livros
                    EmprestimoVet emprestimoVet = new EmprestimoVet();
                    emprestimoVet.emprestimo();
                    break;
                case 4:
                    System.out.println("\n Sistema finalizado! \n");
                    System.exit(0);
            }
        }
    }
}