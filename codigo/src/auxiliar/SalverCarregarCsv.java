package auxiliar;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class SalverCarregarCsv {
    public SalverCarregarCsv() {
    }

    public static void slavar(String salvar, String nome){
        File diretorio =new File("codigo/src/auxiliar/Base_Dados");
        //criar diretorio
        //diretorio.mkdir();
        File arquivo = new File(diretorio,nome+".csv");

        try{
            arquivo.createNewFile();
            FileWriter arquivoEscrita = new FileWriter(arquivo,true);
            PrintWriter escrever =new PrintWriter(arquivoEscrita);

            escrever.print(salvar);
            escrever.flush();
            escrever.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

        public static List<String> carregarArquivo(String planilha ){

            List<String> resultado =new ArrayList<>();
            try {
            File diretorio =new File("codigo/src/auxiliar/Base_Dados");
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
                e.printStackTrace();
            }
          return resultado;
        }
}
