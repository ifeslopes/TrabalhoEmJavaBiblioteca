import auxiliar.Login;
import menu.MenuPricipal;

public class ProgramaPrincial {
    public static void main(String[] args) {

        if(Login.iniciar()) {
            MenuPricipal.menuPrincipal();
        }
    }
}
