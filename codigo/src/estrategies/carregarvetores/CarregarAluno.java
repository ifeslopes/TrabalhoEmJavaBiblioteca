package estrategies.carregarvetores;

import classes.Aluno;
import utilitarios.SalverCarregarCsv;
import vetorclasses.AlunoVet;

import java.util.List;

public class CarregarAluno implements Estrategy {

    AlunoVet alunoVet =new AlunoVet();



    @Override
    public Object carregarVetor() {

            //carregando alunos no vetor
            List<String> listas = SalverCarregarCsv.carregarArquivo("alunos.csv");

            try {
                listas.stream().map(l -> l.split(";")).skip(1)
               .forEach(a -> alunoVet.novoAluno(
                new Aluno(Integer.parseInt(a[0]),a[1],a[2],a[3],a[4],Double.parseDouble(a[5]))));


                /*
                for (int i=1; i< listas.size();i++ ) {
                    String[] funci = listas.get(i).split(";");

                    Aluno aluno1 =new Aluno( Integer.parseInt(funci[0]),funci[1],
                            funci[2],funci[3],funci[4],Double.parseDouble(funci[5]));
                    this.alunoVet.novoAluno(aluno1);
                }
                 */
            }catch (RuntimeException e){
                System.out.println("Erro de formatação: "+e.getMessage());
                System.exit(0);
            }

            return  alunoVet;

    }
}
