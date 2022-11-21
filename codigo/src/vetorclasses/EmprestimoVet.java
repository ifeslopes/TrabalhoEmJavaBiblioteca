package vetorclasses;

import classes.Aluno;
import classes.Emprestimo;
import utilitarios.BuscarClienteLivro;
import utilitarios.CalculadoraDeData;
import utilitarios.Login;
import utilitarios.SalverCarregarCsv;

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


        System.out.println("\n\n Emprestimo de Itens::\n ");
        Emprestimo emprestimo =new Emprestimo();

        //buscando object fazendo cast para aluno
        Aluno aluno = (Aluno) BuscarClienteLivro.buscarUsuario();

        if(BuscarClienteLivro.culsuntaMulta(aluno)) {
            System.out.println("Entre com codigodo emprestiomo: ");
            emprestimo.setCodigo(entrada.nextInt());

            emprestimo.setMatriculaCliente(aluno.getMatricula());
            emprestimo.setMatriculaFuncionario(Login.getMatriculaFuncionarioLogado());
            String dataEmprestimo;
            String dataDevolucao;
            Integer validarData=0;

            entrada.nextLine();

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
                emprestimo.setDataEmprestimo(dataEmprestimo);
                emprestimo.setDataDevolucao(dataDevolucao);


            String emprestimoSalvar = emprestimo.getCodigo() + ";" +
                    emprestimo.getMatriculaCliente() + ";" + emprestimo.getMatriculaFuncionario() + ";"
                    + emprestimo.getDataEmprestimo() + ";" + emprestimo.getDataDevolucao() + "\n";

            this.novoEmprestimo(emprestimo);

            ItenEmprestimoVet itenEmprestimoVet =new ItenEmprestimoVet();
            itenEmprestimoVet.itenDeEmprestimo(emprestimo);
            boolean cadastraNovaLinha =true; //para cadastra um nova linha no .csv

            if(this.getEmprestimoVets().size()==1) {
                String cabecalho = "código;matrícula-cliente;matrícula-funcionário;<data-" +
                        "empréstimo;data-devolução\n";
                SalverCarregarCsv.salvar(cabecalho, "emprestimos",cadastraNovaLinha);
            }

            SalverCarregarCsv.salvar(emprestimoSalvar, "emprestimos",cadastraNovaLinha);
            System.out.println("Emprestimo Realizado Com Sucesso! ");
        }



    }
}
