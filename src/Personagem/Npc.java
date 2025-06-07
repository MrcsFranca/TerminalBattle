package Personagem;

import Habilidades.Habilidade;

import java.util.ArrayList;

public class Npc extends Personagem{
    private String nome, personalidade;

    public Npc(int vidaMax,int vidaAtual, int qntdHab, int defesa, int agilidade, ArrayList<Habilidade> habilidades, String tipo, String nome, String personalidade){
            super(vidaMax, vidaAtual, qntdHab, defesa, agilidade, habilidades, tipo);
            this.nome = nome;
            this.personalidade = personalidade;
    }

    public String getNome() {
        return nome;
    }

    public String getPersonalidade() {
        return personalidade;
    }
    public void setPersonalidade(String personalidade) {
        this.personalidade = personalidade;
    }

    public void atacar(Personagem alvo, Habilidade hab){
        hab.ativar(alvo);
    }
}
