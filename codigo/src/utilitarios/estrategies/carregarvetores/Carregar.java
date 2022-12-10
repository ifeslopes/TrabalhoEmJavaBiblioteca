package utilitarios.estrategies.carregarvetores;

import java.util.List;

public class Carregar {
    Estrategy estrategy;


    public Carregar(Estrategy estrategy) {
        this.estrategy = estrategy;
    }
    public Object getEstrategy() {
        return  estrategy.carregarVetor();
    }
}
