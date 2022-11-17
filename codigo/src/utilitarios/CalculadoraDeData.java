package utilitarios;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.lang.Integer.valueOf;

public class CalculadoraDeData {

    public static Integer calcularData(String dataInico, String dataFim){
        LocalDate inicio = LocalDate.parse(dataInico, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate fim = LocalDate.parse(dataFim, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Duration duracaoDias = Duration.between(inicio.atStartOfDay(),fim.atStartOfDay());
        Integer dias = Integer.parseInt(String.valueOf(duracaoDias.toDays()));

        return dias;
    }

}
