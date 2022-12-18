package menu;

import estrategies.salvarPdf.SalvarEmprestimoPdf;
import estrategies.salvarPdf.SalvarFuncionarioPdf;
import utilitarios.GerarRelatorio;
import utilitarios.SalverCarregarCsv;
import estrategies.salvarPdf.SalvarLivroPdf;
import estrategies.salvarPdf.SalvarPdf;

import java.util.Scanner;

public class MenuRelatorio {
    public static void menuDeRelaterio() {

        Scanner entrada = new Scanner(System.in);
        int opcao=0;
        String menssagem ="Relatório gerado com sucesso!";
        SalvarPdf salvarPdf =new SalvarPdf();

        while (opcao!=6) {

            System.out.println(":: B I B L I O T E C A ::\n");
            System.out.println("Menu Relatórios");
            System.out.println((!SalverCarregarCsv.relatorioExiste("relatorioLivros"))?"1 - Livros Cadastrados":
                    "1 - Livros Cadastrados --> 11 p/ Gerar o PDF");
            System.out.println((!SalverCarregarCsv.relatorioExiste("relatorioEmprestimo"))?"2 - Relatório Emprestimo":
                    "2 - Relatório Emprestimo --> 12 p/ Gerar o PDF");
            System.out.println((!SalverCarregarCsv.relatorioExiste("relatorioFuncionario"))?"3 - Relatório De Funcionario":
                    "3 - Relatório De Funcionario --> 13 p/ Gerar o PDF");
            System.out.println((!SalverCarregarCsv.relatorioExiste("relatorioAlunos"))?"4 - Relatório De Aluno":
                    "4 - Relatório De Aluno --> 14 p/ Gerar o PDF");
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
                case 11:
                    salvarPdf.setSalvarPdf(new SalvarLivroPdf());
                    salvarPdf.getSalvarPdf();
                    break;
                case 12:
                    salvarPdf.setSalvarPdf(new SalvarEmprestimoPdf());
                    salvarPdf.getSalvarPdf();
                    break;
                case 13:
                    salvarPdf.setSalvarPdf(new SalvarFuncionarioPdf());
                    salvarPdf.getSalvarPdf();
                    break;



                case 7:
                    System.out.println("\n Sistema finalizado! \n");
                    System.exit(0);

            }
        }
    }

}
