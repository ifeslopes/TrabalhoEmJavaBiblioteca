package vetorclasses;

import classes.Emprestimo;
import classes.ItenDeEmprestimo;
import classes.Livro;
import utilitarios.BuscarClienteLivro;
import utilitarios.CarregarCsvVetor;
import utilitarios.SalverCarregarCsv;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItenEmprestimoVet {
    private final List<ItenDeEmprestimo> itenDeEmprestimoVets = new ArrayList<>();
    final int CODIGO =500;
    public ItenEmprestimoVet() {}

    public  void novoItenDeEmprestimo(ItenDeEmprestimo itenDeEmprestimo){
        this.itenDeEmprestimoVets.add(itenDeEmprestimo);
    }

    public List<ItenDeEmprestimo> getItenDeEmprestimoVets() {
        return itenDeEmprestimoVets;
    }

    public void itenDeEmprestimo(Emprestimo emprestimo) {
        Scanner entrada = new Scanner(System.in);
        boolean menuitem = true;
        String itenDeEmprestimoSalvar="";

        /* true= nova linha no arquivo csv e false = atualizar todo o arquivo csv*/
        boolean cadastraNovaLinha =true;

        System.out.println("\n\n ItenDeEmprestimo de Itens::\n ");
        ItenDeEmprestimo itenDeEmprestimo = new ItenDeEmprestimo();



        while (menuitem){
            Livro livro = BuscarClienteLivro.buscarLivro();

            if(SalverCarregarCsv.verificarExistenciaDoArquivo("itenDeEmprestimos")) {
                itenDeEmprestimo.setCodigo(CarregarCsvVetor.carregarCsvItenEmprestimo().getItenDeEmprestimoVets()
                        .get(CarregarCsvVetor.carregarCsvItenEmprestimo().getItenDeEmprestimoVets().size() - 1)
                        .getCodigo() + 1);
            }else {
                itenDeEmprestimo.setCodigo(CODIGO);
            }



        itenDeEmprestimo.setCodigoEmprestimo(emprestimo.getCodigo());
        itenDeEmprestimo.setCodigoLivro(livro.getCodigo());
        itenDeEmprestimo.setCodigoPeriodico(livro.getCodigo());


      itenDeEmprestimoSalvar = itenDeEmprestimo.getCodigo() + ";" +
                itenDeEmprestimo.getCodigoEmprestimo() + ";" + itenDeEmprestimo.getCodigoLivro() + ";"
                + itenDeEmprestimo.getCodigoLivro() + ";" + itenDeEmprestimo.getDataDevolucao() + "\n";

        novoItenDeEmprestimo(itenDeEmprestimo);
            System.out.println(" (1) Empresta novo item aperte / (0) para concluir o empestimo: ");
            if(entrada.nextInt()==0){
                menuitem=false;
            }

        //Veririficar se aruivo existe parar criar cabeçalho
        if(!SalverCarregarCsv.verificarExistenciaDoArquivo("itenDeEmprestimos")) {

            String cabecalho = "código-item;código-empréstimo;código-livro;código-periódico;data-devolução \n";
            SalverCarregarCsv.salvar(cabecalho, "itenDeEmprestimos", cadastraNovaLinha);
        }
            SalverCarregarCsv.salvar(itenDeEmprestimoSalvar, "itenDeEmprestimos",cadastraNovaLinha);
    }


            System.out.println("ItenDeEmprestimo Cadastrado Com Sucesso! ");
        }



    }

