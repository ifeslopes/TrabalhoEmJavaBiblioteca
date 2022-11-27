package utilitarios;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.lang.Integer.valueOf;

public class CalculadoraDeData {

   //metodo para calcular diferença das datas
    public static Integer calcularData(String dataInico, String dataFim){
        Integer dias=0;
        try {

        LocalDate inicio = LocalDate.parse(dataInico, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate fim = LocalDate.parse(dataFim, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Duration duracaoDias = Duration.between(inicio.atStartOfDay(),fim.atStartOfDay());
       dias = Integer.parseInt(String.valueOf(duracaoDias.toDays()));
      }catch (RuntimeException e){
          System.out.println("Erro de formatação: "+ e.getMessage());
            System.exit(0);
      }

        return dias;
    }
    //metodo para calcular os 5 dias do emprestimo do livro
    public static String gerarDiasDaDevolucao(String diaEmprestimo){
        LocalDate diaDevolucao=null;
        try {
         diaDevolucao = LocalDate.parse(diaEmprestimo, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        } catch (RuntimeException e){
        System.out.println("Erro de formatação: "+ e.getMessage());
        System.exit(0);
    }
        return  ""+diaDevolucao.plusDays(5).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

}
