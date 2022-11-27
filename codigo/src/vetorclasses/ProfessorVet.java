package vetorclasses;

import utilitarios.SalverCarregarCsv;
import classes.Professor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProfessorVet {

    Scanner entrada = new Scanner(System.in);
    private List<Professor> professorVets = new ArrayList<>();

    public ProfessorVet() {
    }

    public void novoProfessor(Professor professor) {
        this.professorVets.add(professor);
    }

    public List<Professor> getProfessorVets() {
        return professorVets;
    }

    public void cadastra() {
        Scanner entrada = new Scanner(System.in);
        Professor professor = new Professor();

        System.out.println("::N O V O - P R O F E S S O R::");
        System.out.println("Entre com matricula: ");
        professor.setMatricula(entrada.nextInt());
        entrada.nextLine();
        System.out.println("Entre com nome: ");
        professor.setNome(entrada.nextLine());
        System.out.println("Entre com endereço: ");
        professor.setEndereco(entrada.nextLine());
        System.out.println("Entre com data do ingresso: ");
        professor.setDataIngresso(entrada.nextLine());
        System.out.println("Entre com setor: ");
        professor.setSetor(entrada.nextLine());
        

        String professoresSalvar = professor.getMatricula() + ";" + professor.getNome() + ";"
                + professor.getEndereco() + ";" + professor.getDataIngresso() + ";" + professor.getSetor() + "\n";

        novoProfessor(professor);

        /* true= nova linha no arquivo csv e false = atualizar todo o aruuivo csv*/
        boolean cadastraNovaLinha =true;

        //Veririficar se aruivo existe parar criar cabeçalho
        if(!SalverCarregarCsv.verificarExistenciaDoArquivo("professores")) {

            String cabecalho = "matrícula;nome;endereço;data-ingresso;setor  \n";
            SalverCarregarCsv.salvar(cabecalho, "professores", cadastraNovaLinha);
        }

        SalverCarregarCsv.salvar(professoresSalvar, "professores",cadastraNovaLinha);

    }

}
