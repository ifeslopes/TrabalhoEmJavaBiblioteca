package estrategies.carregarvetores;

import classes.Emprestimo;
import classes.Funcionario;
import utilitarios.SalverCarregarCsv;
import vetorclasses.EmprestimoVet;

import java.util.List;

public class CarregarEmprestimo implements Estrategy {
    public CarregarEmprestimo(){}

    @Override
    public Object carregarVetor() {
        //metodo carregar Emprestimo

        EmprestimoVet emprestimoVet = new EmprestimoVet();
        List<String> listas = SalverCarregarCsv.carregarArquivo("emprestimos.csv");

        try {
            listas.stream().map(l -> l.split(";")).skip(1)
          .forEach(f -> emprestimoVet.novoEmprestimo(
           new Emprestimo(Integer.parseInt(f[0]),Integer.parseInt(f[1]),Integer.parseInt(f[2]),f[3],f[4])));

            /*
            for (int i = 1; i < listas.size(); i++) {
                String[] emprest = listas.get(i).split(";");

                Emprestimo emprestimo = new Emprestimo(Integer.parseInt(emprest[0]), Integer.parseInt(emprest[1]),
                        Integer.parseInt(emprest[2]), emprest[3], emprest[4]);

                emprestimoVet.novoEmprestimo(emprestimo);
            }

             */

        }catch ( RuntimeException e){
            System.out.println("Erro deformatação"+ e.getMessage());
            System.exit(0);
        }

        return emprestimoVet;

    }
}
