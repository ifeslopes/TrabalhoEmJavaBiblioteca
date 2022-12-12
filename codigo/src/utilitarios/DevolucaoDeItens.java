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
    String salvaAluno = "";
    String dataEmprestimo="";
    int codigoEprestimo=0;
    int matriculaAlunomultado=0;

    boolean menuitem = false;
    int matriculaDoAluno =-1;

    //Calcular os dias de Atraso
    // pegando data no dia no formato dias/mes/anos





    EmprestimoVet emprestimo = CarregarCsvVetor.getEmprestimoVet();
    ItenEmprestimoVet itenEmprestimoVet = CarregarCsvVetor.carregarCsvItenEmprestimo();


        //Buscar codigoEprestimo, matriculaAlunomultado,dataEmprestimo
        while (matriculaDoAluno!=0) {
            System.out.println("Entre com matricula do aluno ou  entre com 1 parar listar os alunos com livro emprestado 0 para sair:");
            matriculaDoAluno = entreda.nextInt();

            for (int i = 0; i < emprestimo.getEmprestimoVets().size(); i++) {

                    if (emprestimo.getEmprestimoVets().get(i).getMatriculaCliente() == matriculaDoAluno) {

                        codigoEprestimo = emprestimo.getEmprestimoVets().get(i).getCodigo();
                        dataEmprestimo = emprestimo.getEmprestimoVets().get(i).getDataEmprestimo();
                        matriculaAlunomultado = emprestimo.getEmprestimoVets().get(i).getMatriculaCliente();
                        matriculaDoAluno =0;
                        menuitem=true;

                    }

            }
                //Quando não encontra o codigo do aluno mostra codigo cadastrados
                if(codigoEprestimo==0){
                    System.out.println("Matricula do aluno não encontrado!\n");
                    System.out.println("Lista de matricula de aluno com livro emprestado:");
                    for (int i = 0; i < emprestimo.getEmprestimoVets().size(); i++) {
                        if(emprestimo.getEmprestimoVets().get(i).getDataDevolucao().equalsIgnoreCase("null")||
                                emprestimo.getEmprestimoVets().get(i).getDataDevolucao().isEmpty()
                        )
                        {
                            System.out.println("Matricula do aluno:" + emprestimo.getEmprestimoVets().get(i).getMatriculaCliente());
                        }
                    }
            }
        }

        //Buscando e adicionar data devulução Item  do itenEmprestiomoVet
        while (menuitem) {


            for (int i = 0; i < itenEmprestimoVet.getItenDeEmprestimoVets().size(); i++) {

                if(itenEmprestimoVet.getItenDeEmprestimoVets().get(i).getDataDevolucao().equalsIgnoreCase("null")&&
                itenEmprestimoVet.getItenDeEmprestimoVets().get(i).getCodigoEmprestimo()==codigoEprestimo) {
                    System.out.println("Codigo do item: " + itenEmprestimoVet.getItenDeEmprestimoVets().get(i).getCodigo());
                    System.out.println("Titulo: " + CarregarCsvVetor.buscarLivroPorCodigo(itenEmprestimoVet.getItenDeEmprestimoVets().
                            get(i).getCodigoLivro()).getTitulo());
                }
            }
            System.out.println("Entre com codigodo emprestiomo do item: ");
            int codigoItem = entreda.nextInt();

            for (int i = 0; i < itenEmprestimoVet.getItenDeEmprestimoVets().size(); i++) {

                if (itenEmprestimoVet.getItenDeEmprestimoVets().get(i).getCodigo() == codigoItem) {

                    entreda.nextLine();
                    System.out.println("Entre com Data da devulução (dia/mes/ano): ");
                    String dataDevolucao= entreda.nextLine();
                    itenEmprestimoVet.getItenDeEmprestimoVets().get(i).setDataDevolucao(dataDevolucao);

                    //calculando dirença das datas
                    int diasAtraso = CalculadoraDeData.calcularData(dataEmprestimo,dataDevolucao);
                    final  int DIAS_ALUNO_PODE_FICAR_COM_LIVRO=5;

                    System.out.println("Dias Atraso: "+(diasAtraso - DIAS_ALUNO_PODE_FICAR_COM_LIVRO));
                    System.out.println("Hoje: "+CalculadoraDeData.getDataHoje());

                    //se os dias de atraso for maior DIAS_ALUNO_PODE_FICAR_COM_LIVRO
                    // que vai ser chamado o metodo prara multa aluno

                    if(diasAtraso > DIAS_ALUNO_PODE_FICAR_COM_LIVRO){
                        salvaAluno =  multarAluno(matriculaAlunomultado,diasAtraso - DIAS_ALUNO_PODE_FICAR_COM_LIVRO);
                        SalverCarregarCsv.salvar(salvaAluno, "alunos",false);

                        System.out.println("A T E N Ç Ã O !");
                        System.out.println("Foi detectado atraso na entrega, multa gerada R$: "+
                                ( diasAtraso - DIAS_ALUNO_PODE_FICAR_COM_LIVRO ) * 4.50);
                    }

                }
            }
            System.out.println(" (1) Devolver novo item aperte / (0) para concluir a devolução: ");
            if (entreda.nextInt() == 0) {
                menuitem = false;
            }
        }

        //Criando uma string com dados atualizado do itenEmprestiomoVet
        for (int i = 0; i < itenEmprestimoVet.getItenDeEmprestimoVets().size(); i++) {

            salvaItemEmprestimo += itenEmprestimoVet.getItenDeEmprestimoVets().get(i).getCodigo() + ";" +
                    itenEmprestimoVet.getItenDeEmprestimoVets().get(i).getCodigoEmprestimo() + ";" + itenEmprestimoVet.getItenDeEmprestimoVets().get(i).getCodigoLivro() + ";"
                    + itenEmprestimoVet.getItenDeEmprestimoVets().get(i).getCodigoLivro() + ";" + itenEmprestimoVet.getItenDeEmprestimoVets().get(i).getDataDevolucao() + "\n";
        }


        //Verificar se Classe emprestimo tem vinculo com Item Imprestimo
        boolean removerEmpretrimo=true;
        for (int i = 0; i < itenEmprestimoVet.getItenDeEmprestimoVets().size(); i++) {

            if (itenEmprestimoVet.getItenDeEmprestimoVets().get(i).getDataDevolucao().equalsIgnoreCase("null") &&
                    itenEmprestimoVet.getItenDeEmprestimoVets().get(i).getCodigoEmprestimo() == codigoEprestimo) {

                removerEmpretrimo = false;
                break;
            }

        }

        //Se não encontra nem um vinculo com Item emprestimo remove
        if (removerEmpretrimo){
            for (int i = 0; i < emprestimo.getEmprestimoVets().size(); i++) {
                if(emprestimo.getEmprestimoVets().get(i).getCodigo()== codigoEprestimo){
                    emprestimo.getEmprestimoVets().get(i).setDataDevolucao(CalculadoraDeData.getDataHoje());

                }
            }
        }
        //Atualizando uma string com dados atualizado do emprestiomoVet
        for (int i = 0; i < emprestimo.getEmprestimoVets().size(); i++) {
            salvaEmprestimo += emprestimo.getEmprestimoVets().get(i).getCodigo() + ";" +
                    emprestimo.getEmprestimoVets().get(i).getMatriculaCliente() + ";" + emprestimo.getEmprestimoVets().get(i).getMatriculaFuncionario() + ";"
                    + emprestimo.getEmprestimoVets().get(i).getDataEmprestimo() + ";" + emprestimo.getEmprestimoVets().get(i).getDataDevolucao() + "\n";

        }


        /* true= nova linha no arquivo csv e false = atualizar todo o aruuivo csv*/
        boolean atualizarCsv =false;
        boolean cadastraNovaLinha =true;


            //salvando os valores atualizado dos itenEmprestiomoVet,emprestiomoVet e DadosDaDevolucao
            SalverCarregarCsv.salvar(salvaEmprestimo, "emprestimos",atualizarCsv);
            SalverCarregarCsv.salvar(salvaItemEmprestimo, "itenDeEmprestimos",atualizarCsv);
        System.out.println((codigoEprestimo!=0)?"Devolução realizada com sucesso!":"");

    }





     //metodo para multa em caso de atraso na entraga
    public static String multarAluno(int matriculaAluno, int diasAtraso){

        AlunoVet alunoVet = CarregarCsvVetor.getAlunoVetrioVet();

          String salvaAluno = "matrícula;nome;endereço;curso;data-ingresso;multa  \n";
        final  Double VALORMULTA = diasAtraso * 4.5;

        for (int i = 0; i < alunoVet.getAlunoVets().size(); i++) {

            if (alunoVet.getAlunoVets().get(i).getMatricula()==matriculaAluno){
                alunoVet.getAlunoVets().get(i).setMulta(alunoVet.getAlunoVets().get(i).getMulta()+VALORMULTA);
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
