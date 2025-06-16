import Personagem.*;

/**
 * Classe que abriga a main para inicializar o jogo
 */
public class TerminalBattleApp {
    public static void main(String[] args) {

        Gerador gerador = new Gerador();
        Personagem player = gerador.geraPlayer();

        GameEngine.run(player);
    }
}
