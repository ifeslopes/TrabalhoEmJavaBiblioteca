package utilitarios;

import classes.*;
import utilitarios.estrategies.carregarvetores.*;
import vetorclasses.*;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Thread.sleep;


public class CarregarCsvVetor {
    private static FuncionarioVet funcionarioVet;
    private static AlunoVet alunoVet;
    private static LivroVet livroVet;
    private static EmprestimoVet emprestimoVet;

    public static FuncionarioVet getFuncionarioVet() {
        return funcionarioVet;
    }
    public static AlunoVet getAlunoVetrioVet() {
        return alunoVet;
    }
    public static LivroVet getLivroVet() {return livroVet;}
    public static EmprestimoVet getEmprestimoVet() {
        return emprestimoVet;
    }

 //refatoração com patradão de projeto estrategy
  public static void carregarTudo(String nomeArquivo){

  Carregar novo;

      if(nomeArquivo.equalsIgnoreCase("funcionarios.csv")){
         novo = new Carregar(new CarregarFuncionario());
         funcionarioVet= (FuncionarioVet) novo.getEstrategy();
      }

      if(nomeArquivo.equalsIgnoreCase("alunos.csv")){
         novo = new Carregar(new CarregarAluno());
         alunoVet= (AlunoVet) novo.getEstrategy();
      }
      if(nomeArquivo.equalsIgnoreCase("livros.csv")){
         novo = new Carregar(new CarregarLivro());
        livroVet = (LivroVet) novo.getEstrategy();
      }
      if(nomeArquivo.equalsIgnoreCase("emprestimos.csv")){
         novo = new Carregar(new CarregarEmprestimo());
        emprestimoVet = (EmprestimoVet) novo.getEstrategy();
      }

  }




  // semrefatoração com for
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

            Funcionario funcionario=null;
            for (int i = 0; i < funcionarioVet.getFuncionarioVets().size(); i++) {

                //if para pegar codigo e nome do funcionario
                if (matricul == funcionarioVet.getFuncionarioVets().get(i).getMatricula()) {
                    funcionario = funcionarioVet.getFuncionarioVets().get(i);


                }

            }
            return funcionario;
        }

        public static Aluno buscarAlunoPorMatricula(Integer matricula) {

          List<Aluno> aluno =  alunoVet.getAlunoVets().stream().filter(x -> x.getMatricula() == matricula)
                  .collect(Collectors.toList());
          
            return(!aluno.isEmpty())?aluno.get(0):null;
        }

            public static Livro buscarLivroPorCodigo (Integer codigo){

                LivroVet livroVet= getLivroVet();
                Livro livro = null;
                for (int i = 0; i < livroVet.getLivroVets().size() ; i++) {

                    if (codigo == livroVet.getLivroVets().get(i).getCodigo()){
                        livro = livroVet.getLivroVets().get(i);

                    }
                }


                return livro;

            }
        }




