package menu;

import utilitarios.GerarRelatorio;

import java.util.Scanner;

public class MenuRelatorio {
    public static void menuDeRelaterio() {

        Scanner entrada = new Scanner(System.in);
        int opcao=0;
        String menssagem ="Relatório gerado com sucesso!";

        while (opcao!=6) {

            System.out.println(":: B I B L I O T E C A ::\n");
            System.out.println("Menu Relatórios");
            System.out.println("1 - Livros Cadastrados");
            System.out.println("2 - Relatório Emprestimo");
            System.out.println("3 - Relatório De Funcionario");
            System.out.println("4 - Relatório De Aluno");
            System.out.println("5 - Imprimir Multa individual");
            System.out.println("6 - Voltar Menu principal");
            System.out.println("7 - Sair");

            // lê a opção do usuário
             opcao = Integer.parseInt(entrada.nextLine());

            switch (opcao) {
                case 1:
                    GerarRelatorio.gerarRelatorioLivro();
                    System.out.println(menssagem);
                    break;
                case 2:

                    GerarRelatorio.gerarRelatorioEmprestimo();
                    System.out.println(menssagem);
                    break;
                case 3:

                    GerarRelatorio.gerarRelatorioFuncionario();
                    System.out.println(menssagem);
                    break;
                case 4:
                    GerarRelatorio.gerarRelatorioAluno();
                    System.out.println(menssagem);
                    break;
                case 5:
                    GerarRelatorio.imprimirMultaIndividual();
                    System.out.println("--------------------");
                    System.out.println("Operação realizada com sucesso!\n");
                    break;



                case 7:
                    System.out.println("\n Sistema finalizado! \n");
                    System.exit(0);

            }
        }
    }

}
