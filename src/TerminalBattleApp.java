import Personagem.*;
import Habilidades.*;

public class TerminalBattleApp {
    public static void main(String[] args) {

        Gerador gerador = new Gerador();
        Personagem player = gerador.geraPlayer();

        GameEngine.run(player);
    }
}
