package utilitarios;

import vetorclasses.FuncionarioVet;

import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public  class Login  {
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
        SalverCarregarCsv.atualizarDadosNoVetor(diretorio);



        while (inicio) {

            if (diretorio.exists()) {

                return telaLogin();
            } else {
                //criar diretorio
                diretorio.mkdir();

                System.out.println("\n\n    A T E N Ç Ã O !");
                System.out.println("Os aruivios .csv de entrada e relatórios estão salvos nos diretórios ");
                System.out.println("codigo/src/utilitarios/Base_Dados/");
                System.out.println("codigo/src/utilitarios/Relatorio/ \n\n");
                System.out.println("CADASTRO INICIAL DE FUNCIONARIO PARA USO DO SISTEMA!");

                FuncionarioVet funcionarioVet =new FuncionarioVet();
                funcionarioVet.cadastra();

            }
        }
        return true;
    }

    public static boolean telaLogin(){
        FuncionarioVet lista= CarregarCsvVetor.getFuncionarioVet();

        Scanner entrada =new Scanner(System.in);
        boolean menu =true;

        while (menu){
            System.out.println("\n::T E L A  D E  L O G I N ::");
            System.out.println(">>> LOGIN <<<");
            String login = entrada.nextLine();

            System.out.println(">>> SENHA <<<");
            String senha = entrada.nextLine();

            for (int i = 0; i < lista.getFuncionarioVets().size() ; i++) {


                if(lista.getFuncionarioVets().get(i).getLogin().equalsIgnoreCase(login)
                        && lista.getFuncionarioVets().get(i).getSenha().equalsIgnoreCase(encriptar(senha))){

                    //pegando nome e matricula do funcionario logado
                    nomeFuncionarioLogado = lista.getFuncionarioVets().get(i).getNome();
                    matriculaFuncionarioLogado= lista.getFuncionarioVets().get(i).getMatricula();

                    menu = false;

                }
            }
            if(menu) {
                System.out.println("\n  Login ou Senha Invalido: \n");
            }


        }
        return true;
    }
    public static String encriptar(String senha)  {
        String s2="";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
            s2 = hash.toString(16);
        }catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        return s2;
    }



}
