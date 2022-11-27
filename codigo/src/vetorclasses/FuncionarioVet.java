package vetorclasses;

import utilitarios.SalverCarregarCsv;
import classes.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FuncionarioVet {


    private List<Funcionario> funcionarioVets = new ArrayList<>();

    public FuncionarioVet() {}

    public  void novoFuncionario(Funcionario funcionario){
        this.funcionarioVets.add(funcionario);
    }

    public List<Funcionario> getFuncionarioVets() {
        return funcionarioVets;
    }

    public void cadastra(){
        Scanner entrada =new Scanner(System.in);
        Funcionario funcionario =new Funcionario();

        System.out.println("::N O V O -  F U N C I O N A R I O::");
        System.out.println("Entre com matricula: ");
        funcionario.setMatricula(entrada.nextInt());
        entrada.nextLine();
        System.out.println("Entre com nome: ");
        funcionario.setNome(entrada.nextLine());
        System.out.println("Entre com endereço: ");
        funcionario.setEndereco(entrada.nextLine());
        System.out.println("Entre com data do ingresso: ");
        funcionario.setDataIngresso(entrada.nextLine());
        System.out.println("Entre com setor: ");
        funcionario.setSetor(entrada.nextLine());
        System.out.println("Cadastre seu login: ");
        funcionario.setLogin(entrada.nextLine());
        System.out.println("Casatre com senha: ");
        funcionario.setSenha(entrada.nextLine());

        String funcionarioSalvar = funcionario.getMatricula()+";"+funcionario.getNome()+";"+
                funcionario.getEndereco()+";"+funcionario.getDataIngresso()+";"+funcionario.getSetor()+";"+
                funcionario.getSenha()+";"+funcionario.getLogin()+"\n";

        novoFuncionario(funcionario);

        /* true= nova linha no arquivo csv e false = atualizar todo o arquivo csv*/
        boolean cadastraNovaLinha =true;

        //Veririficar se aruivo existe parar criar cabeçalho
       if(!SalverCarregarCsv.verificarExistenciaDoArquivo("funcionarios")) {

           String cabecalho = "matrícula;nome;endereço;data-ingresso; setor; login ;senha \n";
           SalverCarregarCsv.salvar(cabecalho, "funcionarios", cadastraNovaLinha);
       }
        SalverCarregarCsv.salvar(funcionarioSalvar, "funcionarios",cadastraNovaLinha);


    }


}
