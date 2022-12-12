package vetorclasses;

import classes.Aluno;
import classes.Emprestimo;
import utilitarios.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmprestimoVet {
    private final List<Emprestimo> emprestimoVets = new ArrayList<>();
    final int CODIGO = 40000000;

    public EmprestimoVet() {
    }

    public void novoEmprestimo(Emprestimo emprestimo) {
        this.emprestimoVets.add(emprestimo);
    }

    public List<Emprestimo> getEmprestimoVets() {
        return emprestimoVets;
    }

    public void emprestimo() {
        Scanner entrada = new Scanner(System.in);


        System.out.println("::N O V O -  E M P R E S T I M O::");
        Emprestimo emprestimo = new Emprestimo();
        if (SalverCarregarCsv.verificarExistenciaDoArquivo("emprestimos")) {
            emprestimo.setCodigo(CarregarCsvVetor.getEmprestimoVet().getEmprestimoVets().get(CarregarCsvVetor
                    .getEmprestimoVet().getEmprestimoVets().size() - 1).getCodigo() + 1);
        } else {
            emprestimo.setCodigo(CODIGO);
        }
        //buscando object fazendo cast para aluno
        Aluno aluno = BuscarClienteLivro.buscarUsuario();

        if (BuscarClienteLivro.culsuntaMulta(aluno)) {

            emprestimo.setMatriculaCliente(aluno.getMatricula());
            emprestimo.setMatriculaFuncionario(Login.getMatriculaFuncionarioLogado());



            /* metodo para funcionario cadastra a data da devolução manualmente

                do {
                    //validar:devolução deve ser maior que a data de empréstimo

                    System.out.println("Entre como data do emprestimo:\"dd/MM/yyyy\" ");
                     dataEmprestimo = entrada.nextLine();
                    System.out.println("Entre como data devolução: \"dd/MM/yyyy\" ");
                    dataDevolucao = entrada.nextLine();
                    validarData = CalculadoraDeData.calcularData(dataEmprestimo, dataDevolucao);

                    if(validarData <= 0){
                        System.out.println("\n ATENÇÂO! A data de devolução deve ser maior que a data de empréstimo ");
                    }
                }while (validarData < 0);

             */

            emprestimo.setDataEmprestimo(CalculadoraDeData.getDataHoje());


            String emprestimoSalvar = emprestimo.getCodigo() + ";" +
                    emprestimo.getMatriculaCliente() + ";" + emprestimo.getMatriculaFuncionario() + ";"
                    + emprestimo.getDataEmprestimo() + ";" + emprestimo.getDataDevolucao() + "\n";


            ItenEmprestimoVet itenEmprestimoVet = new ItenEmprestimoVet();
            itenEmprestimoVet.itenDeEmprestimo(emprestimo);

            /* true= nova linha no arquivo csv e false = atualizar todo o arquivo csv*/
            boolean cadastraNovaLinha = true;

            if (!SalverCarregarCsv.verificarExistenciaDoArquivo("emprestimos")) {
                String cabecalho = "código;matrícula-cliente;matrícula-funcionário;data-empréstimo;data-devolução\n";
                SalverCarregarCsv.salvar(cabecalho, "emprestimos", cadastraNovaLinha);
            }

            SalverCarregarCsv.salvar(emprestimoSalvar, "emprestimos", cadastraNovaLinha);
            System.out.println("Emprestimo Realizado Com Sucesso! ");
            //CarregarCsvVetor.getEmprestimoVet().novoEmprestimo(emprestimo);
        }


    }
}
