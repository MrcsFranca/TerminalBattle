import Habilidades.Habilidade;
import Personagem.*;
import Personagem.Player;
import Habilidades.NomeHabilidade;

public class TerminalBattleApp {
    public static void main(String[] args) {

        Gerador gerador = new Gerador();
        Personagem player = gerador.geraPlayer();
        Personagem npc = gerador.geraNPC();

        System.out.println(player.getNome());
        System.out.println(player.getTipo());
        System.out.println(player.getHabilidades());
        System.out.println(player.getVidaMax());
        System.out.println(player.getVidaAtual());
        System.out.println(player.getDefesa());
        System.out.println(player.getAgilidade());
        System.out.println(player.getMultDano());
        System.out.println(player.getMultDef());
        System.out.println(player.getMultAgil());
        System.out.println(player.getQntdHab());

        System.out.println(npc.getNome());
        System.out.println(npc.getTipo());
        System.out.println(npc.getHabilidades());
        System.out.println(npc.getVidaMax());
        System.out.println(npc.getVidaAtual());
        System.out.println(npc.getDefesa());
        System.out.println(npc.getAgilidade());
        System.out.println(npc.getMultDano());
        System.out.println(npc.getMultDef());
        System.out.println(npc.getMultAgil());
        System.out.println(npc.getQntdHab());
    }
}
