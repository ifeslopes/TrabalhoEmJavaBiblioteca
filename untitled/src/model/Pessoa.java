package model;

import java.util.Date;

public class Pessoa {
    private int matricula;
    private String nome;
    private String endereco;
    private Date dataEngresso;

    public Pessoa(int matricula, String nome, String endereco, Date dataEngresso) {
        this.matricula = matricula;
        this.nome = nome;
        this.endereco = endereco;
        this.dataEngresso = dataEngresso;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getDataEngresso() {
        return dataEngresso;
    }

    public void setDataEngresso(Date dataEngresso) {
        this.dataEngresso = dataEngresso;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "matricula=" + matricula +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", dataEngresso=" + dataEngresso +
                '}';
    }
}