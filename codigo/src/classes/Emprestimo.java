package classes;

import java.util.Date;

public class Emprestimo {
    private int codigo;
    private int matriculaCliente;
    private int matriculaFuncionario;
    private Date dataEmprestimo;
    private Date dataDevolucao;

    public Emprestimo(int codigo, int matriculaCliente, int matriculaFuncionario, Date dataEmprestimo, Date dataDevolucao) {
        this.codigo = codigo;
        this.matriculaCliente = matriculaCliente;
        this.matriculaFuncionario = matriculaFuncionario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getMatriculaCliente() {
        return matriculaCliente;
    }

    public void setMatriculaCliente(int matriculaCliente) {
        this.matriculaCliente = matriculaCliente;
    }

    public int getMatriculaFuncionario() {
        return matriculaFuncionario;
    }

    public void setMatriculaFuncionario(int matriculaFuncionario) {
        this.matriculaFuncionario = matriculaFuncionario;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "codigo=" + codigo +
                ", matriculaCliente=" + matriculaCliente +
                ", matriculaFuncionario=" + matriculaFuncionario +
                ", dataEmprestimo=" + dataEmprestimo +
                ", dataDevolucao=" + dataDevolucao +
                '}';
    }
}
