package utilitarios;

import vetorclasses.AlunoVet;
import vetorclasses.EmprestimoVet;
import vetorclasses.ItenEmprestimoVet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DevolucaoDeItens {
    public static void devolverItem(){

    Scanner entreda =new Scanner(System.in);
    String salvaEmprestimo="código;matrícula-cliente;matrícula-funcionário;data-empréstimo;data-devolução\n";
    String salvaItemEmprestimo = "código-item;código-empréstimo;código-livro;código-periódico;data-devolução \n";
        String salvaDadosDaDevolucao="";
    String salvaAluno = "";
    String dataDevolucao="";
    int codigoEprestimo=0;
    int matriculaAlunomultado=0;

    //if para não repitir o cabeçalho ou
    if(!SalverCarregarCsv.verificarExistenciaDoArquivo("dadosDaDevolucao")) {
         salvaDadosDaDevolucao = "código-cliente;código-funcionario;código-livro;data-devolução;dia-recebido \n";
    }

    EmprestimoVet emprestimo = CarregarCsvVetor.carregarCsvEmprestimo();
    ItenEmprestimoVet itenEmprestimoVet = CarregarCsvVetor.carregarCsvItenEmprestimo();




        //Removendo emprestimo  do emprestiomoVet
        while (codigoEprestimo==0) {
            System.out.println("Entre com matricula do aluno ou  entre com 0 parar listar os alunos com livro emprestado:");
           int matriculaDoAluno = entreda.nextInt();

            for (int i = 0; i < emprestimo.getEmprestimoVets().size(); i++) {

                    if (emprestimo.getEmprestimoVets().get(i).getMatriculaCliente() == matriculaDoAluno) {

                        codigoEprestimo = emprestimo.getEmprestimoVets().get(i).getCodigo();
                        dataDevolucao = emprestimo.getEmprestimoVets().get(i).getDataDevolucao();
                        matriculaAlunomultado = emprestimo.getEmprestimoVets().get(i).getMatriculaCliente();

                        salvaDadosDaDevolucao+=emprestimo.getEmprestimoVets().get(i).getMatriculaCliente()+";"+
                                emprestimo.getEmprestimoVets().get(i).getMatriculaFuncionario()+";";
                        emprestimo.getEmprestimoVets().remove(i);
                    }

            }
                //Quando não encontra o codigo do aluno mostra codigo cadastrados
                if(codigoEprestimo==0){
                    System.out.println("Matricula do aluno não encontrado!\n");
                    System.out.println("Lista de matricula de aluno com livro emprestado:");
                    for (int i = 0; i < emprestimo.getEmprestimoVets().size(); i++) {
                        System.out.println("Matricula do aluno:"+emprestimo.getEmprestimoVets().get(i).getMatriculaCliente());
                    }
            }
                // so  entra nesse if quando devolver item e pegar codigo do emprestimo
               if(codigoEprestimo!=0) {
                //Atualizando uma string com dados atualizado do emprestiomoVet
                   for (int i = 0; i < emprestimo.getEmprestimoVets().size(); i++) {
                       salvaEmprestimo += emprestimo.getEmprestimoVets().get(i).getCodigo() + ";" +
                               emprestimo.getEmprestimoVets().get(i).getMatriculaCliente() + ";" + emprestimo.getEmprestimoVets().get(i).getMatriculaFuncionario() + ";"
                               + emprestimo.getEmprestimoVets().get(i).getDataEmprestimo() + ";" + emprestimo.getEmprestimoVets().get(i).getDataDevolucao() + "\n";

                   }
               }


        }

        //Removendo item emprestimo  do itenEmprestiomoVet
        for (int i = 0; i < itenEmprestimoVet.getItenDeEmprestimoVets().size(); i++) {
            if(itenEmprestimoVet.getItenDeEmprestimoVets().get(i).getCodigoEmprestimo()==codigoEprestimo){
                salvaDadosDaDevolucao+=itenEmprestimoVet.getItenDeEmprestimoVets().get(i).getCodigoLivro()+";"
                        +itenEmprestimoVet.getItenDeEmprestimoVets().get(i).getDataDevolucao()+";";
                itenEmprestimoVet.getItenDeEmprestimoVets().remove(i);
            }
        }

        //Criando uma string com dados atualizado do itenEmprestiomoVet
        for (int i = 0; i < itenEmprestimoVet.getItenDeEmprestimoVets().size(); i++) {
            salvaItemEmprestimo += itenEmprestimoVet.getItenDeEmprestimoVets().get(i).getCodigo() + ";" +
                    itenEmprestimoVet.getItenDeEmprestimoVets().get(i).getCodigoEmprestimo() + ";" + itenEmprestimoVet.getItenDeEmprestimoVets().get(i).getCodigoLivro() + ";"
                    + itenEmprestimoVet.getItenDeEmprestimoVets().get(i).getCodigoLivro() + ";" + itenEmprestimoVet.getItenDeEmprestimoVets().get(i).getDataDevolucao() + "\n";
        }

        /* true= nova linha no arquivo csv e false = atualizar todo o aruuivo csv*/
        boolean atualizarCsv =false;
        boolean cadastraNovaLinha =true;

        //Calcular os dias de Atraso
        //pegando data no dia no formato dias/mes/anos
        String dataHoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        int diasAtraso = CalculadoraDeData.calcularData(dataDevolucao,dataHoje);
        System.out.println("Dias Atraso: "+diasAtraso);
        System.out.println("Hoje: "+dataHoje);

        salvaDadosDaDevolucao+=dataHoje+"\n";
        //se os dias de atraso for maior que zero vai ser chamado o metofo prara multa aluno
        if(diasAtraso>0){
          salvaAluno=  multarAluno(matriculaAlunomultado,diasAtraso);
            SalverCarregarCsv.salvar(salvaAluno, "alunos",atualizarCsv);

            System.out.println("A T E N Ç Ã O !");
            System.out.println("Foi detectado atraso na entrega, multa gerada R$: "+diasAtraso * 4.50);
        }

            //salvando os valores atualizado dos itenEmprestiomoVet,emprestiomoVet e DadosDaDevolucao
            SalverCarregarCsv.salvar(salvaEmprestimo, "emprestimos",atualizarCsv);
            SalverCarregarCsv.salvar(salvaItemEmprestimo, "itenDeEmprestimos",atualizarCsv);
            SalverCarregarCsv.salvar(salvaDadosDaDevolucao, "dadosDaDevolucao",cadastraNovaLinha);
        System.out.println("\n\nDevolução realizada com sucesso!");

    }





     //metodo para multa em caso de atraso na entraga
    public static String multarAluno(int matriculaAluno, int diasAtraso){

        AlunoVet alunoVet = CarregarCsvVetor.carregarCsvAluno();

        String salvaAluno = "matrícula;nome;endereço;curso;data-ingresso;multa  \n";
        final  Double VALORMULTA = diasAtraso * 4.5;

        for (int i = 0; i < alunoVet.getAlunoVets().size(); i++) {

            if (alunoVet.getAlunoVets().get(i).getMatricula()==matriculaAluno){
                alunoVet.getAlunoVets().get(i).setMulta(VALORMULTA);
            }
            //Criando uma string com dados atualizado do alunoVet
            salvaAluno += alunoVet.getAlunoVets().get(i).getMatricula() + ";" +
                    alunoVet.getAlunoVets().get(i).getNome() + ";" + alunoVet.getAlunoVets().get(i).getEndereco() + ";"
                    + alunoVet.getAlunoVets().get(i).getCurso() + ";" + alunoVet.getAlunoVets().get(i).getDataIngresso()
                    + ";"+ alunoVet.getAlunoVets().get(i).getMulta()+"\n";

        }

        return salvaAluno;

    }




}
