package vetorclasses;

import utilitarios.SalverCarregarCsv;
import classes.Livro;
import classes.Periodico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PeriodicoVet {
    private List<Periodico> periodicoVets = new ArrayList<>();

    public PeriodicoVet() {}

    public  void novoPeriodico(Periodico periodico){
        this.periodicoVets.add(periodico);
    }

    public List<Periodico> getPeriodicoVets() {
        return periodicoVets;
    }

    public void cadastra(Livro livro){
        Scanner entrada =new Scanner(System.in);
        Periodico periodico =new Periodico();


        periodico.setCodigo(livro.getCodigo());
        periodico.setTitulo(livro.getTitulo());
        periodico.setAutores(livro.getAutores());
        periodico.setIssn(livro.getIssn());

        System.out.println("\n\n Cadastro de Periódicos::\n ");
        System.out.println("Entre com tipo (P:periodico), (R:revistas), (C:conferencias) ");
        periodico.setTipo(entrada.nextLine().toLowerCase().charAt(0));
        System.out.println("Entre com fator de impacto: ");
        periodico.setFatorDeEmpactor(entrada.nextDouble());


        String periodicoSalvar = periodico.getCodigo()+";"+periodico.getAutores()+";"+
                periodico.getTitulo()+";"+ periodico.getTipo()+";"
                + periodico.getFatorDeEmpactor()+";"+ periodico.getIssn()+"\n";

        this.novoPeriodico(periodico);
        boolean cadastraNovaLinha =true; //para cadastra um nova linha no .csv

        //Veririficar se aruivo existe parar criar cabeçalho
        if(!SalverCarregarCsv.verificarExistenciaDoArquivo("periodicos")) {
            String cabecalho = "código;autor(es);título;tipo;fator-de-impacto;issn \n";
            SalverCarregarCsv.salvar(cabecalho, "periodicos",cadastraNovaLinha);
        }
        SalverCarregarCsv.salvar(periodicoSalvar, "periodicos",cadastraNovaLinha);
        System.out.println("Cadastro Realizado Com Sucesso! ");

    }
}
