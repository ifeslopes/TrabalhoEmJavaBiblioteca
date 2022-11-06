package model;

import java.util.Date;

public class Professor extends Pessoa {
    private String setor;

    public Professor(int matricula, String nome, String endereco, Date dataEngresso, String setor) {
        super(matricula, nome, endereco, dataEngresso);
        this.setor = setor;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "setor='" + setor + '\'' +
                "} " + super.toString();
    }
}
