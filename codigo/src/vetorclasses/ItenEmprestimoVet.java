package vetorclasses;

import classes.Emprestimo;
import classes.ItenDeEmprestimo;
import classes.Livro;
import utilitarios.BuscarClienteLivro;
import utilitarios.SalverCarregarCsv;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItenEmprestimoVet {
    private List<ItenDeEmprestimo> itenDeEmprestimoVets = new ArrayList<>();

    public ItenEmprestimoVet() {}

    public  void novoItenDeEmprestimo(ItenDeEmprestimo itenDeEmprestimo){
        this.itenDeEmprestimoVets.add(itenDeEmprestimo);
    }

    public List<ItenDeEmprestimo> getItenDeEmprestimoVets() {
        return itenDeEmprestimoVets;
    }

    public void itenDeEmprestimo(Emprestimo emprestimo) {
        Scanner entrada =new Scanner(System.in);


        System.out.println("\n\n ItenDeEmprestimo de Itens::\n ");
        ItenDeEmprestimo itenDeEmprestimo =new ItenDeEmprestimo();


        Livro livro =  BuscarClienteLivro.buscarLivro();


            System.out.println("Entre com codigodo emprestiomo do item: ");
            itenDeEmprestimo.setCodigo(entrada.nextInt());
            itenDeEmprestimo.setCodigoEmprestimo(emprestimo.getCodigo());
            itenDeEmprestimo.setCodigoLivro(livro.getCodigo());
            itenDeEmprestimo.setCodigoPeriodico(livro.getCodigo());
            itenDeEmprestimo.setDataDevolucao(emprestimo.getDataDevolucao());



            String itenDeEmprestimoSalvar = itenDeEmprestimo.getCodigo() + ";" +
                    itenDeEmprestimo.getCodigoEmprestimo() + ";" + itenDeEmprestimo.getCodigoLivro() + ";"
                    + itenDeEmprestimo.getCodigoLivro() + ";" + itenDeEmprestimo.getDataDevolucao() + "\n";

            this.novoItenDeEmprestimo(itenDeEmprestimo);
        boolean cadastraNovaLinha =true; //para cadastra um nova linha no .csv

        //Veririficar se aruivo existe parar criar cabeçalho
        if(!SalverCarregarCsv.verificarExistenciaDoArquivo("itenDeEmprestimos")) {
            String cabecalho = "código-item;código-empréstimo;código-livro;código-" +
                    "periódico>;<data-devolução \n";
            SalverCarregarCsv.salvar(cabecalho, "itenDeEmprestimos", cadastraNovaLinha);
        }
            SalverCarregarCsv.salvar(itenDeEmprestimoSalvar, "itenDeEmprestimos",cadastraNovaLinha);
            System.out.println("ItenDeEmprestimo Cadastrado Com Sucesso! ");
        }



    }

