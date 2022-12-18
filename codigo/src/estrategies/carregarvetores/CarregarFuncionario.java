package estrategies.carregarvetores;

import classes.Aluno;
import classes.Funcionario;
import utilitarios.SalverCarregarCsv;
import vetorclasses.FuncionarioVet;

import java.util.List;

public class CarregarFuncionario implements Estrategy {

    FuncionarioVet funcionarioVet =new FuncionarioVet();



    @Override
    public Object carregarVetor() {

            //carregando funcionarios no vetor

        List<String> listas = SalverCarregarCsv.carregarArquivo("funcionarios.csv");

        try {

            listas.stream().map(l -> l.split(";")).skip(1)
                    .forEach(f -> funcionarioVet.novoFuncionario(
                            new Funcionario(Integer.parseInt(f[0]),f[1],f[2],f[3],f[4],f[5],f[6])));
/*
            for (int i=1; i< listas.size();i++ ) {
                String[] funci = listas.get(i).split(";");

                Funcionario funcionario =new Funcionario( Integer.parseInt(funci[0]),funci[1],
                        funci[2],funci[3],funci[4],funci[5],funci[6]);
                funcionarioVet.novoFuncionario(funcionario);
            }
 */
        }catch (RuntimeException e){
            System.out.println("Erro de formatação: "+e.getMessage());
            System.exit(0);
        }

        return  funcionarioVet;

    }
}
