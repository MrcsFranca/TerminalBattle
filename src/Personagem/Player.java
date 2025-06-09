package Personagem;

import Habilidades.Habilidade;
import Habilidades.TipoHabilidade;

import java.util.ArrayList;

public class Player extends Personagem {
    private int winsStreak;

    public Player(String nome, int vidaMax, int vidaAtual, int qntdHab, int defesa, int agilidade, ArrayList<Habilidade> habilidades, TipoHabilidade tipo, int winsStreak){
        super(nome, vidaMax, vidaAtual, defesa, agilidade, habilidades, tipo);
        this.winsStreak = winsStreak;
    }

    public int getWinStreak() {
        return winsStreak;
    }

    public void setWinStreak(int winsStreak) {
        this.winsStreak = winsStreak;
    }

    public void atacar(Personagem dono, Personagem alvo, Habilidade hab){
        hab.usaHab(dono, alvo);
    }
}
