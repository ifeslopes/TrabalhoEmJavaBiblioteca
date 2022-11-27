package utilitarios;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public  class SalverCarregarCsv {
    public SalverCarregarCsv() {
    }

    public static void salvar(String salvar, String nome,boolean novoAtualizar){
        File diretorio =new File("codigo/src/utilitarios/Base_Dados");
        //criar diretorio
        //diretorio.mkdir();
        File arquivo = new File(diretorio,nome+".csv");

        try{
            arquivo.createNewFile();
            FileWriter arquivoEscrita = new FileWriter(arquivo,novoAtualizar);
            PrintWriter escrever =new PrintWriter(arquivoEscrita);

            escrever.print(salvar);
            escrever.flush();
            escrever.close();
        }catch (IOException e){

            System.out.println("Erro de I/O: "+e.getMessage());
            System.exit(0);
        }

    }

        public static List<String> carregarArquivo(String planilha ){

            List<String> resultado =new ArrayList<>();
            try {
            File diretorio =new File("codigo/src/utilitarios/Base_Dados");
            File arquivo = new File(diretorio,planilha);
            FileReader lerArquivo = new  FileReader(arquivo);
            BufferedReader bufferedReader =new BufferedReader(lerArquivo);

            String linha="";


            while((linha = bufferedReader.readLine())!=null){
                resultado.add(linha);
            }

            bufferedReader.close();
            lerArquivo.close();

            }catch (IOException e){
                System.out.println("Erro de I/O ");
                System.out.println(e.getMessage());
                System.exit(0);
            }
          return resultado;
        }
        public static boolean verificarExistenciaDoArquivo(String arquivo){
            File diretorio =new File("codigo/src/utilitarios/Base_Dados/"+arquivo+".csv");
        return diretorio.exists();
        }

    public static void salvarRelatorio(String salvar, String nome,boolean novoAtualizar){
        File diretorio =new File("codigo/src/utilitarios/Relatorio");
        //criar diretorio
        if (!diretorio.exists()) {
            diretorio.mkdir();
        }
        File arquivo = new File(diretorio,nome+".csv");

        try{
            arquivo.createNewFile();
            FileWriter arquivoEscrita = new FileWriter(arquivo,novoAtualizar);
            PrintWriter escrever =new PrintWriter(arquivoEscrita);

            escrever.print(salvar);
            escrever.flush();
            escrever.close();
        }catch (IOException e){

            System.out.println("Erro de I/O: "+e.getMessage());
            System.exit(0);
        }

    }
}
