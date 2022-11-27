package classes;

import java.util.Date;

public class Aluno  extends Pessoa{
    private String curso;

    private Double multa;
    public Aluno() {}
    public Aluno(int matricula, String nome, String endereco, String dataIngresso, String curso, Double multa) {
        super(matricula, nome, endereco, dataIngresso);
        this.curso = curso;
        this.multa = multa;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Double getMulta() {
        return multa;
    }

    public void setMulta(Double multa) {
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
