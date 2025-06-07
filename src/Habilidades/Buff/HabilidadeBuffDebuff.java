package Habilidades.Buff;

import Habilidades.Habilidade;
import Personagem.Personagem;

public abstract class HabilidadeBuffDebuff implements Habilidade {
    private String nome;
    private int turnos;
    private TipoBuffDebuff tipo;

    public HabilidadeBuffDebuff(TipoBuffDebuff tipo, String nome, int turnos){
        this.tipo = tipo;
        this.nome = nome;
        this.turnos = turnos;
    }

    @Override
    public void exibe(Personagem alvo) {
        System.out.println("Usando habilidade de " + tipo + " no personagem" + alvo.getNome() + ": " + nome);
    }
}
