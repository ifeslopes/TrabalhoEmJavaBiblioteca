package utilitarios;

import classes.Aluno;
import classes.Livro;
import vetorclasses.AlunoVet;
import vetorclasses.LivroVet;

import java.util.Scanner;

public class BuscarClienteLivro {

    public static Aluno buscarUsuario(){
        Scanner entrada =new Scanner(System.in);
        AlunoVet alunoVet = CarregarCsvVetor.getAlunoVetrioVet();

        Aluno aluno=null;

        while (aluno==null){
            System.out.println("Entre com matricula do aluno ou  entre com 0 parar listar de alunos: ");
            int buscar = entrada.nextInt();


                aluno= CarregarCsvVetor.buscarAlunoPorMatricula(buscar);



            if( aluno==null){
                System.out.println("Usuario não encotrado: ");
                System.out.println("Lista de usuarios");

                for (int i = 0; i < alunoVet.getAlunoVets().size(); i++) {
                    System.out.println("Nome: "+ alunoVet.getAlunoVets().get(i).getNome()+
                            " Matricula: "+alunoVet.getAlunoVets().get(i).getMatricula());
                }
            }

           }


        return aluno;
        }
        public static boolean culsuntaMulta(Aluno aluno){
            if(aluno.getMulta()!=0){
                System.out.println("\n Usuário impossibilitado de fazer novos emprestimos\n  " +
                        "Foi detectado um saldo pendente por atraso de R$: "+aluno.getMulta());
                return false;

            }
            return true;
        }



    public static Livro buscarLivro(){
        Scanner entrada =new Scanner(System.in);
        LivroVet livroVet = CarregarCsvVetor.getLivroVet();

        Livro livro=null;

        while (livro==null){

            System.out.println("Entre com codigo do livro ou entre 0 para listas livros cadastrados: ");
            int buscar = entrada.nextInt();

            livro= CarregarCsvVetor.buscarLivroPorCodigo(buscar);

            if( livro==null){
                System.out.println("Livro não encotrado: ");
                System.out.println("Lista de usuarios");

                for (int i = 0; i < livroVet.getLivroVets().size(); i++) {
                    System.out.println("Titulo: "+ livroVet.getLivroVets().get(i).getTitulo()+
                            " Codigo: "+livroVet.getLivroVets().get(i).getCodigo());
                }
            }

        }


        return livro;
    }




    }

