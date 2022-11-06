package model;

import java.util.Date;

public class Aluno  extends Pessoa{
    private String curso;

    private double multa;

    public Aluno(int matricula, String nome, String endereco, Date dataEngresso, String curso, double multa) {
        super(matricula, nome, endereco, dataEngresso);
        this.curso = curso;
        this.multa = multa;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "curso='" + curso + '\'' +
                ", multa=" + multa +
                "} " + super.toString();
    }
}
