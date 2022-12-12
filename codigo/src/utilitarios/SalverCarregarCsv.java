package utilitarios;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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
        atualizarDadosNoVetor(diretorio);

    }

        public static List<String> carregarArquivo(String planilha ){

            List<String> resultado =new ArrayList<>();
            try {
            File diretorio =new File("codigo/src/utilitarios/Base_Dados");
            File arquivo = new File(diretorio,planilha);

                FileReader lerArquivo = new FileReader(arquivo);
                BufferedReader bufferedReader = new BufferedReader(lerArquivo);

                String linha = "";


                while ((linha = bufferedReader.readLine()) != null) {
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
            File diretorioExist =new File("codigo/src/utilitarios/Base_Dados/"+arquivo+".csv");
        return diretorioExist.exists();
        }
        public static void atualizarDadosNoVetor(File diretorio){

        if(diretorio.exists()) {
            List<File> nome = Arrays.asList(diretorio.listFiles(File::isFile));
            nome.stream().map(x -> x.toString().split("/")).map(x -> x[4]).
                    forEach(CarregarCsvVetor::carregarTudo);
        }
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
