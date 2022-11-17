package vetorclasses;

import utilitarios.SalverCarregarCsv;
import classes.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LivroVet {
    private List<Livro> livroVets = new ArrayList<>();

    public LivroVet() {}

    public  void novoLivro(Livro livro){
        this.livroVets.add(livro);
    }

    public List<Livro> getLivroVets() {
        return livroVets;
    }

    public void cadastra(){
        Scanner entrada =new Scanner(System.in);
        Livro livro =new Livro();

        System.out.println("Entre com Codigo: ");
        livro.setCodigo(entrada.nextInt());
        entrada.nextLine();
        System.out.println("Entre com titulo do livro: ");
        livro.setTitulo(entrada.nextLine());
        System.out.println("Entre com nome dos autore(s): ");
        livro.setAutores(entrada.nextLine());
        System.out.println("Entre com ano da publicação: ");
        livro.setAnoDePublicacao(entrada.nextInt());
        entrada.nextLine();
        System.out.println("Entre com tipo (P:periodico), (L:Livros) ");
        livro.setTipo(entrada.nextLine().toUpperCase().charAt(0));
        System.out.println("Entre com issn: ");
        livro.setIssn(entrada.nextLine());


        String livroSalvar = livro.getCodigo()+";"+livro.getTitulo()+";"+
                livro.getAutores()+";"+livro.getAnoDePublicacao()+";"+
                livro.getTipo()+";"+ livro.getIssn()+"\n";

        this.novoLivro(livro);
        SalverCarregarCsv.salvar(livroSalvar, "livros");
        if(livro.getTipo()=='P'){
            PeriodicoVet periodico =new PeriodicoVet();
            periodico.cadastra(livro);


        }


    }
}
