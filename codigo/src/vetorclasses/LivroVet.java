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
        System.out.println("::N O V O -  L I V R O::");
        System.out.println("Entre com Codigo: ");
        livro.setCodigo(entrada.nextInt());
        entrada.nextLine();
        System.out.println("Entre com nome dos autore(s),(se houver mais de um, separados por vírgula): ");
        livro.setAutores(entrada.nextLine());
        System.out.println("Entre com titulo do livro: ");
        livro.setTitulo(entrada.nextLine());
        System.out.println("Entre com nome da editora do livro: ");
        livro.setEditora(entrada.nextLine());
        System.out.println("Entre com tipo (P:periodico), (L:Livros) ");
        livro.setTipo(entrada.nextLine().toUpperCase().charAt(0));
        System.out.println("Entre com ano da publicação: ");
        livro.setAnoDePublicacao(entrada.nextInt());
        entrada.nextLine();
        System.out.println("Entre com numero issn: ");
        livro.setIssn(entrada.nextLine());


        String livroSalvar = livro.getCodigo()+";"+livro.getAutores()+";"+
                livro.getTitulo()+";"+livro.getEditora()+";"+livro.getTipo()+";"+
                livro.getAnoDePublicacao()+";"+ livro.getIssn()+"\n";

        novoLivro(livro);

        /* true= nova linha no arquivo csv e false = atualizar todo o aruuivo csv*/
        boolean cadastraNovaLinha =true;

        //Veririficar se aruivo existe parar criar cabeçalho
        if(!SalverCarregarCsv.verificarExistenciaDoArquivo("livros")) {
            String cabecalho = "código;autor(es);título;editora;tipo;ano de publicação;issn \n";
            SalverCarregarCsv.salvar(cabecalho, "livros",cadastraNovaLinha);
        }
        SalverCarregarCsv.salvar(livroSalvar, "livros",cadastraNovaLinha);

        if(livro.getTipo()=='P'){
            PeriodicoVet periodico =new PeriodicoVet();
            periodico.cadastra(livro);


        }


    }


}
