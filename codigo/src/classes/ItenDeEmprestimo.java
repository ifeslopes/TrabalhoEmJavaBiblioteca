package classes;


public class ItenDeEmprestimo {
    private int codigo;
    private int codigoEmprestimo;
    private int codigoLivro;
    private int codigoPeriodico;
    private String dataDevolucao;

    public ItenDeEmprestimo() {
    }

    public ItenDeEmprestimo(int codigo, int codigoEmprestimo, int codigoLivro, int codigoPeriodico, String dataDevolucao) {
        this.codigo = codigo;
        this.codigoEmprestimo = codigoEmprestimo;
        this.codigoLivro = codigoLivro;
        this.codigoPeriodico = codigoPeriodico;
        this.dataDevolucao = dataDevolucao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigoEmprestimo() {
        return codigoEmprestimo;
    }

    public void setCodigoEmprestimo(int codigoEmprestimo) {
        this.codigoEmprestimo = codigoEmprestimo;
    }

    public int getCodigoLivro() {
        return codigoLivro;
    }

    public void setCodigoLivro(int codigoLivro) {
        this.codigoLivro = codigoLivro;
    }

    public int getCodigoPeriodico() {
        return codigoPeriodico;
    }

    public void setCodigoPeriodico(int codigoPeriodico) {
        this.codigoPeriodico = codigoPeriodico;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public String toString() {
        return "ItenDeEmprestimo{" +
                "codigo=" + codigo +
                ", codigoEmprestimo=" + codigoEmprestimo +
                ", codigoLivro=" + codigoLivro +
                ", codigoPeriodico=" + codigoPeriodico +
                ", dataDevolucao=" + dataDevolucao +
                '}';
    }
}
