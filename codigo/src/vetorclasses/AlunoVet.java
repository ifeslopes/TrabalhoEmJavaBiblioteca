package vetorclasses;

import classes.Aluno;
import utilitarios.CarregarCsvVetor;
import utilitarios.SalverCarregarCsv;
import utilitarios.estrategies.carregarvetores.CarregarAluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlunoVet {

    Scanner entrada = new Scanner(System.in);
    private List<Aluno> alunoVets = new ArrayList<>();


    public AlunoVet() {
    }

    public void novoAluno(Aluno aluno) {
        this.alunoVets.add(aluno);
    }

    public List<Aluno> getAlunoVets() {
        return alunoVets;
    }

    public void cadastra() {
        Scanner entrada = new Scanner(System.in);
        Aluno aluno = new Aluno();
        System.out.println("::N O V O - A L U N O::");
        System.out.println("Entre com matricula: ");
        aluno.setMatricula(entrada.nextInt());
        entrada.nextLine();
        System.out.println("Entre com nome: ");
        aluno.setNome(entrada.nextLine());
        System.out.println("Entre com endereço: ");
        aluno.setEndereco(entrada.nextLine());
        System.out.println("Entre com data do ingresso: ");
        aluno.setDataIngresso(entrada.nextLine());
        System.out.println("Entre com curso: ");
        aluno.setCurso(entrada.nextLine());
        aluno.setMulta(0.0);


        String alunoSalvar = aluno.getMatricula() + ";" + aluno.getNome() + ";"
                + aluno.getEndereco() + ";" + aluno.getCurso() + ";" + aluno.getDataIngresso() +";"+
                 aluno.getMulta() + "\n";

        CarregarCsvVetor.getAlunoVetrioVet().novoAluno(aluno);

        /* true= nova linha no arquivo csv e false = atualizar todo o arquivo csv*/
        boolean cadastraNovaLinha =true;

        //Veririficar se aruivo existe parar criar cabeçalho
        if(!SalverCarregarCsv.verificarExistenciaDoArquivo("alunos")) {

            String cabecalho = "matrícula;nome;endereço;curso;data-ingresso;multa  \n";
            SalverCarregarCsv.salvar(cabecalho, "alunos", cadastraNovaLinha);
        }


        SalverCarregarCsv.salvar(alunoSalvar, "alunos",cadastraNovaLinha);

    }

}
