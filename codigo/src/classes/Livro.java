package classes;

public class Livro {
    private int codigo;
    private String autores;
    private String titulo;
    private String editora;
    private char tipo;
    private  int anoDePublicacao;
    private String issn;

    public Livro() {
    }

    public Livro(int codigo, String autores, String titulo, String editora, char tipo, int anoDePublicacao, String issn) {
        this.codigo = codigo;
        this.autores = autores;
        this.titulo = titulo;
        this.editora = editora;
        this.tipo = tipo;
        this.anoDePublicacao = anoDePublicacao;
        this.issn = issn;
    }

    public Livro(int codigo, String autores, String titulo, char tipo, String issn) {
        this.codigo = codigo;
        this.autores = autores;
        this.titulo = titulo;
        this.tipo = tipo;
        this.issn = issn;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public int getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public void setAnoDePublicacao(int anoDePublicacao) {
        this.anoDePublicacao = anoDePublicacao;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "codigo=" + codigo +
                ", autores='" + autores + '\'' +
                ", titulo='" + titulo + '\'' +
                ", editora='" + editora + '\'' +
                ", tipo=" + tipo +
                ", anoDePublicacao=" + anoDePublicacao +
                ", issn='" + issn + '\'' +
                '}';
    }
}
