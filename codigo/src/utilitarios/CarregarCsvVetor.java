package utilitarios;

import classes.Emprestimo;
import classes.Funcionario;
import classes.ItenDeEmprestimo;
import classes.Livro;
import vetorclasses.EmprestimoVet;
import vetorclasses.ItenEmprestimoVet;
import vetorclasses.LivroVet;

import java.util.List;

import static java.lang.Thread.sleep;


public class CarregarCsvVetor {

    public static LivroVet carregarCsvLivro()  {
        //metodo carregar livro

        LivroVet livroVet =new LivroVet();
        List<String> listas = SalverCarregarCsv.carregarArquivo("livros.csv");

        for (int i=1; i < listas.size();i++ ) {
            String[] liv = listas.get(i).split(";");

          Livro livro =new Livro( Integer.parseInt(liv[0]),liv[1],
                    liv[2],liv[3],liv[4].charAt(0),Integer.parseInt(liv[5]),liv[6]);

            livroVet.novoLivro(livro);
        }
        return  livroVet;

    }

    public static EmprestimoVet carregarCsvEmprestimo()  {
        //metodo carregar Emprestimo

       EmprestimoVet emprestimoVet =new EmprestimoVet();
        List<String> listas = SalverCarregarCsv.carregarArquivo("emprestimos.csv");

        for (int i=1; i < listas.size();i++ ) {
            String[] liv = listas.get(i).split(";");

          Emprestimo emprestimo =new Emprestimo( Integer.parseInt(liv[0]),Integer.parseInt(liv[1]),
                  Integer.parseInt(liv[2]),liv[3],liv[4]);

            emprestimoVet.novoEmprestimo(emprestimo);
        }
        return  emprestimoVet;
    }

    public static ItenEmprestimoVet carregarCsvItenEmprestimo()  {
        //metodo carregar ItenEmprestimo

       ItenEmprestimoVet emprestimoVet =new ItenEmprestimoVet();
        List<String> listas = SalverCarregarCsv.carregarArquivo("emprestimos.csv");

        for (int i=1; i < listas.size();i++ ) {
            String[] liv = listas.get(i).split(";");

          ItenDeEmprestimo itenDeEmprestimo =new ItenDeEmprestimo( Integer.parseInt(liv[0]),Integer.parseInt(liv[1]),
                  Integer.parseInt(liv[2]),  Integer.parseInt(liv[3]),liv[4]);

            emprestimoVet.novoItenDeEmprestimo(itenDeEmprestimo);
        }
        return  emprestimoVet;
    }


}
