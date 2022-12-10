package utilitarios.estrategies.carregarvetores;

import classes.Funcionario;
import classes.Livro;
import utilitarios.SalverCarregarCsv;
import vetorclasses.FuncionarioVet;
import vetorclasses.LivroVet;

import java.util.List;

public class CarregarLivro implements Estrategy {
    public CarregarLivro(){}

    @Override
    public Object carregarVetor() {
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
}
