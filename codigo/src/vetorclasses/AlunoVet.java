package vetorclasses;

import classes.Aluno;
import utilitarios.SalverCarregarCsv;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlunoVet {


    private List<Aluno> alunoVets = new ArrayList<>();

    public AlunoVet() {}

    public  void novoAluno(Aluno aluno){
        this.alunoVets.add(aluno);
    }

    public List<Aluno> getAlunoVets() {
        return alunoVets;
    }

    public void cadastra(){

        for (int i = 0; i < 5; i++) {

        Aluno aluno =new Aluno(1234+i,"Endereço Aluno_"+i,
                "Endereço Aluno_"+i,"12/02/2022","letras_"+i,0);
        this.novoAluno(aluno);
        }
        alunoVets.forEach(System.out::println);

    }


}
