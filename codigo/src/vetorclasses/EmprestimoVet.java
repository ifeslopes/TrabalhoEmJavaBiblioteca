package vetorclasses;

import classes.Aluno;
import classes.Emprestimo;
import utilitarios.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmprestimoVet {
    private List<Emprestimo> emprestimoVets = new ArrayList<>();

    public EmprestimoVet() {}

    public  void novoEmprestimo(Emprestimo emprestimo){
        this.emprestimoVets.add(emprestimo);
    }

    public List<Emprestimo> getEmprestimoVets() {
        return emprestimoVets;
    }

    public void emprestimo() {
        Scanner entrada =new Scanner(System.in);


        System.out.println("::N O V O -  E M P R E S T I M O::");
        Emprestimo emprestimo =new Emprestimo();

        //buscando object fazendo cast para aluno
        Aluno aluno =  BuscarClienteLivro.buscarUsuario();

        if(BuscarClienteLivro.culsuntaMulta(aluno)) {
            System.out.println("Entre com codigo do emprestiomo: ");
            emprestimo.setCodigo(entrada.nextInt());

            emprestimo.setMatriculaCliente(aluno.getMatricula());
            emprestimo.setMatriculaFuncionario(Login.getMatriculaFuncionarioLogado());
            String dataEmprestimo;

            //String dataDevolucao;
            //Integer validarData=0;

            entrada.nextLine();
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
            System.out.println("Entre como data do emprestimo:\"dd/MM/yyyy\" ");
            dataEmprestimo = entrada.nextLine();
                emprestimo.setDataEmprestimo(dataEmprestimo);



            String emprestimoSalvar = emprestimo.getCodigo() + ";" +
                    emprestimo.getMatriculaCliente() + ";" + emprestimo.getMatriculaFuncionario() + ";"
                    + emprestimo.getDataEmprestimo() + ";" + emprestimo.getDataDevolucao() + "\n";

            CarregarCsvVetor.getEmprestimoVet().novoEmprestimo(emprestimo);


            ItenEmprestimoVet itenEmprestimoVet =new ItenEmprestimoVet();
            itenEmprestimoVet.itenDeEmprestimo(emprestimo);

            /* true= nova linha no arquivo csv e false = atualizar todo o arquivo csv*/
            boolean cadastraNovaLinha =true;

            if(!SalverCarregarCsv.verificarExistenciaDoArquivo("emprestimos")) {
                String cabecalho = "código;matrícula-cliente;matrícula-funcionário;data-empréstimo;data-devolução\n";
                SalverCarregarCsv.salvar(cabecalho, "emprestimos",cadastraNovaLinha);
            }

            SalverCarregarCsv.salvar(emprestimoSalvar, "emprestimos",cadastraNovaLinha);
            System.out.println("Emprestimo Realizado Com Sucesso! ");
        }



    }
}
