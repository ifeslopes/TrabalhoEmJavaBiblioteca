package menu;

import vetorclasses.AlunoVet;
import vetorclasses.FuncionarioVet;
import vetorclasses.ProfessorVet;

import java.util.Scanner;

public class MenuCadastroDeusuario {
    public static void menuCadastroDeusuario() {

        Scanner entrada = new Scanner(System.in);
        int opcao=0;

        while (opcao!=4) {

            System.out.println(":: B I B L I O T E C A ::\n");
            System.out.println("Cadastro de usuarios");
            System.out.println("1 - Cadastro De Funcionario");
            System.out.println("2 - Cadastro De Professor");
            System.out.println("3 - Cadastro De Aluno");
            System.out.println("4 - Voltar Medu Principal");
            System.out.println("5 - Sair");

            // lê a opção do usuário
             opcao = Integer.parseInt(entrada.nextLine());

            switch (opcao) {
                case 1:


                   FuncionarioVet funcionarioVet= new FuncionarioVet();
                   funcionarioVet.cadastra();

                    break;
                case 2:

                    ProfessorVet professorVet = new ProfessorVet();
                    professorVet.cadastra();

                    break;
                case 3:
                    AlunoVet alunoVet= new AlunoVet();
                    alunoVet.cadastra();

                    break;


                case 5:
                    System.out.println("\n Sistema finalizado! \n");
                    System.exit(0);

            }
        }
    }

}
