package utilitarios;

import classes.Aluno;
import vetorclasses.AlunoVet;

import java.util.Scanner;

public class BuscarClienteLivro {

    public static Object bucaDeUsuario(){
        Scanner entrada =new Scanner(System.in);
        AlunoVet alunoVet = new  AlunoVet();
        alunoVet.cadastra();
        Aluno aluno=null;

        while (aluno==null){
            System.out.println("Entre com matricula do usuario:");
            int buscar = entrada.nextInt();
            for (int i = 0; i < alunoVet.getAlunoVets().size(); i++) {

            if(alunoVet.getAlunoVets().get(i).getMatricula()==buscar){

                aluno= alunoVet.getAlunoVets().get(i);
            }

            }
            if( aluno==null){
                System.out.println("Usuario não encotrado: ");
                System.out.println("Lista de usuarios");

                for (int i = 0; i < 5; i++) {
                    System.out.println("Nome: "+ alunoVet.getAlunoVets().get(i).getNome()+
                            "Matricula: "+alunoVet.getAlunoVets().get(i).getMatricula());
                }
            }

           }


        return aluno;
        }
        public static boolean culsuntaMulta(Aluno aluno){
            if(aluno.getMulta()!=0){
                System.out.println("\n Foi detectado que o usuario  as com saldo pendente de R$: "+aluno.getMulta());
                return false;

            }
            return true;
        }


    }

