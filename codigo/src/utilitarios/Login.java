package utilitarios;

import classes.Funcionario;
import vetorclasses.FuncionarioVet;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public  class Login extends SalverCarregarCsv {
    private static String nomeFuncionarioLogado;

    private static int matriculaFuncionarioLogado;

    public  static String getNomeFuncionarioLogado() {
        return nomeFuncionarioLogado;
    }
    public static int getMatriculaFuncionarioLogado() {
        return matriculaFuncionarioLogado;
    }




    public static boolean iniciar(){
        File diretorio =new File("codigo/src/utilitarios/Base_Dados");
        boolean inicio =true;


        while (inicio) {

            if (diretorio.exists()) {



                return telaLogin();
            } else {
                //criar diretorio
                diretorio.mkdir();
                System.out.println("CADASTR FUNCIONARIO INICIAL NO SISTEMA!");
                FuncionarioVet funcionarioVet =new FuncionarioVet();
                funcionarioVet.cadastra();

            }
        }
        return true;
    }

    public static boolean telaLogin(){
        FuncionarioVet lista= carregarCsvFuncionario();
        Scanner entrada =new Scanner(System.in);
        boolean menu =true;

        while (menu){
            System.out.println("\n\n:: TELA DE LOGIN ::");
            System.out.println("Entre com login:");
            String login = entrada.nextLine();

            System.out.println("Entre com senha:");
            String senha = entrada.nextLine();

            for (int i = 0; i < lista.getFuncionarioVets().size() ; i++) {


                if(lista.getFuncionarioVets().get(i).getLogin().equalsIgnoreCase(login)
                        && lista.getFuncionarioVets().get(i).getSenha().equalsIgnoreCase(senha)){

                    //pegando nome e matricula do funcionario logado
                    nomeFuncionarioLogado = lista.getFuncionarioVets().get(i).getNome();
                    matriculaFuncionarioLogado= lista.getFuncionarioVets().get(i).getMatricula();

                    menu = false;

                }
            }
            if(menu) {
                System.out.println("\n \n Login ou senha Invalido: \n\n");
            }


        }
        return true;
    }

    public static FuncionarioVet carregarCsvFuncionario(){
        //metodo carregar funcionario

        Funcionario funcionario =new Funcionario();
        FuncionarioVet funcionarioVet =new FuncionarioVet();
        List<String> listas = carregarArquivo("funcionarios.csv");

        for (String list:listas ) {
            String[] funci = list.split(";");
            funcionario.setMatricula(Integer.parseInt(funci[0]));
            funcionario.setNome(funci[1]);
            funcionario.setEndereco(funci[2]);
            funcionario.setDataEngresso(funci[3]);
            funcionario.setSetor(funci[4]);
            funcionario.setLogin(funci[5]);
            funcionario.setSenha(funci[6]);
            funcionarioVet.novoFuncionario(funcionario);

        }
       return  funcionarioVet;
    }

}
