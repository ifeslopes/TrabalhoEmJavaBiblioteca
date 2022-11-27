package utilitarios;

import classes.*;
import vetorclasses.*;

import java.util.List;

import static java.lang.Thread.sleep;


public class CarregarCsvVetor {



    public static FuncionarioVet carregarCsvFuncionario(){
        //metodo carregar funcionario

        Funcionario funcionario =new Funcionario();
        FuncionarioVet funcionarioVet =new FuncionarioVet();
        List<String> listas = SalverCarregarCsv.carregarArquivo("funcionarios.csv");

        try {

        //carregando funcionarios no vetor
        for (int i=1; i< listas.size();i++ ) {
            String[] funci = listas.get(i).split(";");

            Funcionario funcionario1 =new Funcionario( Integer.parseInt(funci[0]),funci[1],
                    funci[2],funci[3],funci[4],funci[5],funci[6]);
            funcionarioVet.novoFuncionario(funcionario1);
        }
        }catch (RuntimeException e){
            System.out.println("Erro de formatação: "+e.getMessage());
            System.exit(0);
        }

        return  funcionarioVet;
    } public static AlunoVet carregarCsvAluno(){
        //metodo carregar funcionario

        Aluno aluno =new Aluno();
        AlunoVet alunoVet =new AlunoVet();
        List<String> listas = SalverCarregarCsv.carregarArquivo("alunos.csv");

        try {

        //carregando alunos no vetor
        for (int i=1; i< listas.size();i++ ) {
            String[] funci = listas.get(i).split(";");

            Aluno aluno1 =new Aluno( Integer.parseInt(funci[0]),funci[1],
                    funci[2],funci[3],funci[4],Double.parseDouble(funci[5]));
            alunoVet.novoAluno(aluno1);
        }
        }catch (RuntimeException e){
            System.out.println("Erro de formatação: "+e.getMessage());
            System.exit(0);
        }

        return  alunoVet;
    }
            public static LivroVet carregarCsvLivro () {
                //metodo carregar livro

                LivroVet livroVet = new LivroVet();
                List<String> listas = SalverCarregarCsv.carregarArquivo("livros.csv");
                try {

                    for (int i = 1; i < listas.size(); i++) {
                        String[] liv = listas.get(i).split(";");

                        Livro livro = new Livro(Integer.parseInt(liv[0]), liv[1],
                                liv[2], liv[3], liv[4].charAt(0), Integer.parseInt(liv[5]), liv[6]);

                        livroVet.novoLivro(livro);
                    }
                }catch ( RuntimeException e){
                    System.out.println("Erro deformatação"+ e.getMessage());
                    System.exit(0);
                }

            return livroVet;

        }

            public static EmprestimoVet carregarCsvEmprestimo () {
            //metodo carregar Emprestimo

            EmprestimoVet emprestimoVet = new EmprestimoVet();
            List<String> listas = SalverCarregarCsv.carregarArquivo("emprestimos.csv");

            try {

            for (int i = 1; i < listas.size(); i++) {
                String[] emprest = listas.get(i).split(";");

                Emprestimo emprestimo = new Emprestimo(Integer.parseInt(emprest[0]), Integer.parseInt(emprest[1]),
                        Integer.parseInt(emprest[2]), emprest[3], emprest[4]);

                emprestimoVet.novoEmprestimo(emprestimo);
            }

            }catch ( RuntimeException e){
                System.out.println("Erro deformatação"+ e.getMessage());
                System.exit(0);
            }

            return emprestimoVet;
        }

            public static ItenEmprestimoVet carregarCsvItenEmprestimo () {
            //metodo carregar ItenEmprestimo

            ItenEmprestimoVet itemEmprestimoVet = new ItenEmprestimoVet();
            List<String> listas = SalverCarregarCsv.carregarArquivo("itenDeEmprestimos.csv");
            try {
                for (int i = 1; i < listas.size(); i++) {
                    String[] itemEmpre = listas.get(i).split(";");

                    ItenDeEmprestimo itenDeEmprestimo = new ItenDeEmprestimo(Integer.parseInt(itemEmpre[0]), Integer.parseInt(itemEmpre[1]),
                            Integer.parseInt(itemEmpre[2]), Integer.parseInt(itemEmpre[3]), itemEmpre[4]);

                    itemEmprestimoVet.novoItenDeEmprestimo(itenDeEmprestimo);
                }
            }catch ( RuntimeException e){
                System.out.println("Erro deformatação"+ e.getMessage());
                System.exit(0);
            }
                return itemEmprestimoVet;
        }

        //_____________________Buscas Individuais para funcionario cliente e livro---------------------------------
        public static Funcionario buscarFuncionarioPorMatricula(Integer matricul) {
            FuncionarioVet funcionarioVet  = CarregarCsvVetor.carregarCsvFuncionario();
            Funcionario funcionario=null;
            for (int i = 0; i < funcionarioVet.getFuncionarioVets().size(); i++) {

                //if para pegar codigo e nome do funcionario
                if (matricul == funcionarioVet.getFuncionarioVets().get(i).getMatricula()) {
                    funcionario = funcionarioVet.getFuncionarioVets().get(i);

                    //relatririoEmprestimo+=funcionarioVet.getFuncionarioVets().get(j).getMatricula()+
                    //      ";"+funcionarioVet.getFuncionarioVets().get(j).getNome()+";";
                }

            }
            return funcionario;
        }

        public static Aluno buscarAlunoPorMatricula(Integer matricula) {
            AlunoVet alunoVet = carregarCsvAluno();

            Aluno aluno = null;
            for (int i = 0; i < alunoVet.getAlunoVets().size(); i++) {

                if (matricula == alunoVet.getAlunoVets().get(i).getMatricula()) {

                    aluno = alunoVet.getAlunoVets().get(i);
                    // relatririoEmprestimo+=alunoVet.getAlunoVets().get(k).getMatricula()+
                    ///       ";"+alunoVet.getAlunoVets().get(k).getNome()+";";;
                }
            }
            return aluno;
        }

            public static Livro buscarLivroPorCodigo (Integer codigo){

                LivroVet livroVet= CarregarCsvVetor.carregarCsvLivro();
                Livro livro = null;
                for (int i = 0; i < livroVet.getLivroVets().size() ; i++) {

                    if (codigo == livroVet.getLivroVets().get(i).getCodigo()){
                        livro = livroVet.getLivroVets().get(i);
                       // relatririoEmprestimo+=livroVet.getLivroVets().get(c).getCodigo()+
                         //       ";"+livroVet.getLivroVets().get(b).getTitulo()+";";
                    }
                }


                return livro;

            }
        }




