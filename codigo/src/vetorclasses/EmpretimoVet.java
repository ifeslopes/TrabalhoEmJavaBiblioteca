package vetorclasses;

import classes.Aluno;
import classes.Livro;
import classes.Emprestimo;
import utilitarios.BuscarClienteLivro;
import utilitarios.CalculadoraDeData;
import utilitarios.Login;
import utilitarios.SalverCarregarCsv;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmpretimoVet {
    private List<Emprestimo> emprestimoVets = new ArrayList<>();

    public EmpretimoVet() {}

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
        Aluno aluno = (Aluno) BuscarClienteLivro.bucaDeUsuario();

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
            SalverCarregarCsv.salvar(emprestimoSalvar, "emprestimos");
            System.out.println("Emprestimo Realizado Com Sucesso! ");
        }



    }
}
