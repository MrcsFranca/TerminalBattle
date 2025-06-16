package Personagem;

import Habilidades.Habilidade;
import Habilidades.TipoHabilidade;

import java.util.ArrayList;
/**
 * Sub-classe de Personagem que implementa os NPC's (Personagens jogados pela maquina)
 */
public class Npc extends Personagem{
    /**
     * Construtor do objeto do personagem NPC
     * @author Lucas Polidorio
     * @param nome Representa o nome do peronagem NPC
     * @param vidaMax Representa a vida máxima de um personagem NPC
     * @param vidaAtual Representa a vida atual de um personagem NPC
     * @param defesa Representa a quantidade de defesa de um personagem NPC
     * @param agilidade Representa a quantidade de agilidade de um personagem NPC, determina quem vai atacar primeiro em um combate
     * @param habilidades Um arrayList de habilidades que representa quais habilidades um personagem NPC irá começar
     * @param tipo Representa o tipo do personagem NPC, isto é, o elemento dele
     */
    public Npc(String nome, int vidaMax, int defesa, int agilidade, int quantAtaques, double vidaAtual, double multDano, double multAgil, double multDef, ArrayList<Habilidade> habilidades, TipoHabilidade tipo, boolean boolBuffCarac, boolean boolBuffDano) {
        super(nome, vidaMax, defesa, agilidade, quantAtaques, vidaAtual, multDano, multAgil, multDef, habilidades, tipo, boolBuffCarac, boolBuffDano);
    }

    /**
     * Método para ataques do personagem NPC.
     * @author Lucas Polidorio
     * @param dono O personagem que esta atacando
     * @param alvo O alvo que sera atacado
     * @param hab A habilidade que esta sendo usada para atacar
     */
    public void atacar(Personagem dono, Personagem alvo, Habilidade hab){
        hab.usaHab(dono, alvo);
    }
}
