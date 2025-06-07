package Personagem;

import Habilidades.Habilidade;
import Habilidades.NomeHabilidade;
import Habilidades.TipoHabilidade;

import java.util.ArrayList;

public class Npc extends Personagem{
    private String nome, personalidade;

    public Npc(String nome, int vidaMax, int vidaAtual, int qntdHab, int defesa, int agilidade, ArrayList<NomeHabilidade> habilidades, TipoHabilidade tipo){
            super(nome, vidaMax, vidaAtual, qntdHab, defesa, agilidade, habilidades, tipo);
            this.nome = nome;
    }

    public void atacar(Personagem dono, Personagem alvo, Habilidade hab){
        hab.usaHab(dono, alvo);
    }
}
