package Personagem;

import Habilidades.Habilidade;
import Habilidades.TipoHabilidade;

import java.util.ArrayList;
/**
 * Subclasse de Personagem que implementa um personagem jogável
 */
public class Player extends Personagem {
    private int winsStreak;
    /**
     * Construtor do personagem jogavel
     * @author Lucas Polidorio
     * @param nome Representa o nome do personagem do jogador
     * @param vidaMax Representa a vida maxima do personagem jogavel
     * @param vidaAtual Representa a vida atual do personagem jogavel
     * @param quantAtaques Representa a quantidade de habilidades que o personagem jogavel pode possuir
     * @param defesa Representa a quantidade de defesa que o personagem jogavel possui
     * @param agilidade Representa a quantidade de agilidade que o personagem jogavel possui
     * @param habilidades Representa a lista de habilidades que o personagem jogavel possui
     * @param tipo Representa o tipo do personagem jogavel, isto é, o elemento dele
     * @param winsStreak Representa a quantidade de vitórias do personagem jogavel na partida atual
     */
    public Player(String nome, int vidaMax, int defesa, int agilidade, int quantAtaques, double vidaAtual, double multDano, double multAgil, double multDef, ArrayList<Habilidade> habilidades, TipoHabilidade tipo, boolean boolBuffCarac, boolean boolBuffDano, int winsStreak) {
        super(nome, vidaMax, defesa, agilidade, quantAtaques, vidaAtual, multDano, multAgil, multDef, habilidades, tipo, boolBuffCarac, boolBuffDano);
        this.winsStreak = winsStreak;
    }

    /**
     * @author Lucas Polidorio
     * @return Retorna o numero de vitorias do personagem jogavel na partida atual
     */
    public int getWinStreak() {
        return winsStreak;
    }

    /**
     * Altera da quantidade de vitorias do personagem na partida atual
     * @author Lucas Polidorio
     * @param winsStreak Novo valor da quantidade de vitorias do personagem na partida atual;
     */
    public void setWinStreak(int winsStreak) {
        this.winsStreak = winsStreak;
    }
    /**
     * Método para ataques do personagem jogavel.
     * @author Lucas Polidorio
     * @param dono O personagem que esta atacando
     * @param alvo O alvo que sera atacado
     * @param hab A habilidade que esta sendo usada para atacar
     */
    public void atacar(Personagem dono, Personagem alvo, Habilidade hab){
        hab.usaHab(dono, alvo);
    }
}
