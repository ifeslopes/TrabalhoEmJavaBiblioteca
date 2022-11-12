package classes;

import java.util.Date;

public class Funcionario extends Pessoa{

    private String setor;
    private String login;
    private String senha;
    public Funcionario(){
        super();
    }
    public Funcionario(int matricula, String nome, String endereco, String dataEngresso, String setor, String login, String senha) {
        super(matricula, nome, endereco, dataEngresso);
        this.setor = setor;
        this.login = login;
        this.senha = senha;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "setor='" + setor + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                "} " + super.toString();
    }
}
