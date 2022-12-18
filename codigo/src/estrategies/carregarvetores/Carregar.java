package estrategies.carregarvetores;

public class Carregar {
    Estrategy estrategy;


    public Carregar() {

    }
    public void setEstrategy(Estrategy estrategy) {
        this.estrategy = estrategy;
    }
    public  Object getEstrategy() {
        return estrategy.carregarVetor();
    }
}
