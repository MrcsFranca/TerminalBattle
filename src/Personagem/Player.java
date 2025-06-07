package Personagem;

import Habilidades.Habilidade;

import java.util.ArrayList;

public class Player extends Personagem {
    private String nome;
    private int winsStreak;

    public Player(int vidaMax, int vidaAtual, int qntdHab, int defesa, int agilidade, ArrayList<Habilidade> habilidades, String tipo, String nome, int winsStreak){
        super(vidaMax, vidaAtual, qntdHab, defesa, agilidade, habilidades, tipo);
        this.nome = nome;
        this.winsStreak = winsStreak;
    }

    public String getNome() {
        return nome;
    }
    public int getWinsStreak() {
        return winsStreak;
    }

    public void setWinsStreak(int winsStreak) {
        this.winsStreak = winsStreak;
    }

    public void atacar(Personagem alvo, Habilidade hab){
        hab.ativar(alvo);
    }


}
