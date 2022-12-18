package vetorclasses;

import utilitarios.CalculadoraDeData;
import utilitarios.CarregarCsvVetor;
import utilitarios.Login;
import utilitarios.SalverCarregarCsv;
import classes.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FuncionarioVet {


    private final List<Funcionario> funcionarioVets = new ArrayList<>();
    final int CODIGO = 00000000;

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
        if (SalverCarregarCsv.verificarExistenciaDoArquivo("funcionarios")) {
            funcionario.setMatricula(CarregarCsvVetor.getFuncionarioVet().getFuncionarioVets().get(CarregarCsvVetor
                    .getAlunoVetrioVet().getAlunoVets().size() - 1).getMatricula() + 1);
        } else {
            funcionario.setMatricula(CODIGO);
        }


        System.out.println("Entre com nome: ");
        funcionario.setNome(entrada.nextLine());
        System.out.println("Entre com endereço: ");
        funcionario.setEndereco(entrada.nextLine());
        funcionario.setDataIngresso(CalculadoraDeData.getDataHoje());
        System.out.println("Entre com setor: ");
        funcionario.setSetor(entrada.nextLine());
        System.out.println("Cadastre seu login: ");
        funcionario.setLogin(entrada.nextLine());
        System.out.println("Casatre com senha: ");
        funcionario.setSenha(Login.encriptar(entrada.nextLine()));

        String funcionarioSalvar = funcionario.getMatricula()+";"+funcionario.getNome()+";"+
                funcionario.getEndereco()+";"+funcionario.getDataIngresso()+";"+funcionario.getSetor()+";"+
                funcionario.getSenha()+";"+funcionario.getLogin()+"\n";


        /* true= nova linha no arquivo csv e false = atualizar todo o arquivo csv*/
        boolean cadastraNovaLinha =true;

        //Veririficar se aruivo existe parar criar cabeçalho
       if(!SalverCarregarCsv.verificarExistenciaDoArquivo("funcionarios")) {

           String cabecalho = "matrícula;nome;endereço;data-ingresso; setor; senha ;login \n";
           SalverCarregarCsv.salvar(cabecalho, "funcionarios", cadastraNovaLinha);
       }
        SalverCarregarCsv.salvar(funcionarioSalvar, "funcionarios",cadastraNovaLinha);
        //CarregarCsvVetor.getFuncionarioVet().novoFuncionario(funcionario);


    }


}
