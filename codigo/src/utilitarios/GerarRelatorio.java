package utilitarios;

import classes.Aluno;
import classes.Funcionario;
import classes.Livro;
import vetorclasses.*;

import java.util.Scanner;

public class GerarRelatorio {
    public static void gerarRelatorioLivro() {

        LivroVet livroVet = CarregarCsvVetor.getLivroVet();
        String relatririoLivro = "Código;autor(es);título;editora;tipo;ano de publicação;issn  \n";
        for (int i = 0; i < livroVet.getLivroVets().size(); i++) {
            //salvar no relatorioslivros.csv
            relatririoLivro += livroVet.getLivroVets().get(i).getCodigo() + " ; " +
                    livroVet.getLivroVets().get(i).getAutores() + " ; "
                    + livroVet.getLivroVets().get(i).getTitulo() + " ; "
                    + livroVet.getLivroVets().get(i).getEditora() + " ; "
                    + livroVet.getLivroVets().get(i).getTipo() + " ; "
                    + livroVet.getLivroVets().get(i).getAnoDePublicacao() + " ; "
                    + livroVet.getLivroVets().get(i).getIssn() + "\n";

        }
        relatririoLivro += "Total Itens Cadastrados: " + livroVet.getLivroVets().size() + "\n";

        SalverCarregarCsv.salvarRelatorio(relatririoLivro, "relatorioLivros", false);
    }


    public static void gerarRelatorioEmprestimo() {

        Funcionario funcionario = null;
        Aluno aluno = null;
        Livro livro = null;
        EmprestimoVet emprestimoVet = CarregarCsvVetor.getEmprestimoVet();
        ItenEmprestimoVet itenEmprestimoVet = CarregarCsvVetor.carregarCsvItenEmprestimo();

        String relatorioEmprestimo = "Código funcionário;Nome Funcionário;Código cliente;" +
                "Nome cliente;Data do emprestiomo;Data da entraga \n";

        for (int i = 0; i < emprestimoVet.getEmprestimoVets().size(); i++) {

            //buscar fucionario que fez o empretimo
            funcionario = CarregarCsvVetor.buscarFuncionarioPorMatricula(emprestimoVet.getEmprestimoVets().
                    get(i).getMatriculaFuncionario());

            //bucas aluno que pegou livro emprestado
            aluno = CarregarCsvVetor.buscarAlunoPorMatricula(emprestimoVet.getEmprestimoVets().
                    get(i).getMatriculaCliente());




            //montando variavel relatorio com Código funcionário, Nome Funcionário, Código cliente, Nome cliente,
            // Código livro, título, Data do emprestiomo, Data da entraga:

            relatorioEmprestimo += funcionario.getMatricula() + ";" + funcionario.getNome()
                    + ";" + aluno.getMatricula() + ";" + aluno.getNome()
                    + ";" + emprestimoVet.getEmprestimoVets().get(i).getDataEmprestimo() + ";"
                    + emprestimoVet.getEmprestimoVets().get(i).getDataDevolucao() + "\n";

            for (int j = 0; j < itenEmprestimoVet.getItenDeEmprestimoVets().size(); j++) {
                if(j==0) {
                    relatorioEmprestimo += ".;.;.;:ITENS DO EMPRESTIMO:;.;. \n";
                }
                if(emprestimoVet.getEmprestimoVets().get(i).getCodigo()==
                        itenEmprestimoVet.getItenDeEmprestimoVets().get(j).getCodigoEmprestimo()){

                    livro = CarregarCsvVetor.buscarLivroPorCodigo(itenEmprestimoVet.getItenDeEmprestimoVets().get(j).getCodigoLivro());
                    if(j==0) {
                        relatorioEmprestimo += "código;título;tipo;data-devolução;.;.\n";
                    }
                    relatorioEmprestimo+= livro.getCodigo()+";"+livro.getTitulo()+";"+livro.getTipo()+";"+
                            itenEmprestimoVet.getItenDeEmprestimoVets().get(j).getDataDevolucao()+";.;.\n";
                }
            }
            relatorioEmprestimo+=".;.;.;.;.;.\n";

        }
        relatorioEmprestimo += "Total De Emprestimos:" + emprestimoVet.getEmprestimoVets().size() + "\n";

        SalverCarregarCsv.salvarRelatorio(relatorioEmprestimo, "relatorioEmprestimo", false);
    }

    public static void gerarRelatorioFuncionario() {

        FuncionarioVet funcionarioVet = CarregarCsvVetor.getFuncionarioVet();
        ItenEmprestimoVet itenEmprestimoVet = CarregarCsvVetor.carregarCsvItenEmprestimo();
        String relatririoFuncionario = "matrícula;nome;endereço;data-ingresso; setor; login ;senha \n";
        for (int i = 0; i < funcionarioVet.getFuncionarioVets().size(); i++) {
            //salvar no relatorioFuncionario.csv
            relatririoFuncionario += funcionarioVet.getFuncionarioVets().get(i).getMatricula() + " ; " +
                    funcionarioVet.getFuncionarioVets().get(i).getNome() + " ; "
                    + funcionarioVet.getFuncionarioVets().get(i).getEndereco() + " ; "
                    + funcionarioVet.getFuncionarioVets().get(i).getDataIngresso() + " ; "
                    + funcionarioVet.getFuncionarioVets().get(i).getSetor() + " ; "
                    + funcionarioVet.getFuncionarioVets().get(i).getLogin() + " ; "
                    + funcionarioVet.getFuncionarioVets().get(i).getSenha()+ "\n";


        }
        relatririoFuncionario += "Total Itens Cadastrados: " + funcionarioVet.getFuncionarioVets().size() + "\n";

        SalverCarregarCsv.salvarRelatorio(relatririoFuncionario, "relatorioFuncionario", false);
    }

    public static void gerarRelatorioAluno() {

        AlunoVet alunoVet = CarregarCsvVetor.getAlunoVetrioVet();
        String relatririoAluno = "matrícula;nome;endereço;curso;data-ingresso;multa  \n";
        for (int i = 0; i < alunoVet.getAlunoVets().size(); i++) {
            //salvar no relatorioAluno.csv
            relatririoAluno += alunoVet.getAlunoVets().get(i).getMatricula() + " ; " +
                    alunoVet.getAlunoVets().get(i).getNome() + " ; "
                    + alunoVet.getAlunoVets().get(i).getEndereco() + " ; "
                    + alunoVet.getAlunoVets().get(i).getCurso() + " ; "
                    + alunoVet.getAlunoVets().get(i).getDataIngresso() + " ; "
                    + alunoVet.getAlunoVets().get(i).getMulta() + " \n ";
        }
        relatririoAluno += "Total Itens Cadastrados: " + alunoVet.getAlunoVets().size() + "\n";

        SalverCarregarCsv.salvarRelatorio(relatririoAluno, "relatorioAluno", false);
    }
    public static void imprimirMultaIndividual() {
        Scanner entrada = new Scanner(System.in);
        AlunoVet alunoVet = CarregarCsvVetor.getAlunoVetrioVet();

        Aluno aluno = null;

        while (aluno == null) {

        System.out.println("Lista de usuarios multados");

            for (int i = 0; i < alunoVet.getAlunoVets().size(); i++) {
                if(alunoVet.getAlunoVets().get(i).getMulta() > 0) {
                    System.out.println("Nome: " + alunoVet.getAlunoVets().get(i).getNome() +
                            " Matricula: " + alunoVet.getAlunoVets().get(i).getMatricula());
                }
            }

        System.out.println("Entre com a matricula do aluno para imprimi a multa: ");
        int buscar = entrada.nextInt();
        aluno = CarregarCsvVetor.buscarAlunoPorMatricula(buscar);

        }

        System.out.println(":: D A D O S  D A  I M P R E S S Ã O ::");
        System.out.println("Matricula Do Aluno: "+aluno.getMatricula());
        System.out.println("Nome Do Aluno: "+aluno.getNome());
        System.out.println("Endereço Do Aluno: "+aluno.getEndereco());
        System.out.println("Valor da multa R$:"+aluno.getMulta());


    }

}