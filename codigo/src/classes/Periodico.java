package classes;

public class Periodico extends Livro{
    private double fatorDeEmpactor;

    public Periodico() {

    }

    public Periodico(int codigo, String autores, String titulo, char tipo, String issn) {
        super(codigo, autores, titulo, tipo, issn);
    }

    public double getFatorDeEmpactor() {
        return fatorDeEmpactor;
    }

    public void setFatorDeEmpactor(double fatorDeEmpactor) {
        this.fatorDeEmpactor = fatorDeEmpactor;
    }

    @Override
    public String toString() {
        return "Periodicos{" +
                "fatorDeEmpactor=" + fatorDeEmpactor +
                "} " + super.toString();
    }
}
