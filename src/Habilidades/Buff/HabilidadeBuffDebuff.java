package Habilidades.Buff;

import Habilidades.Habilidade;
import Habilidades.NomeHabilidadeDano;
import Personagem.Personagem;

public abstract class HabilidadeBuffDebuff implements Habilidade {
    private NomeHabilidadeDano nome;
    private int turnos;
    private TipoBuffDebuff tipo;

    public HabilidadeBuffDebuff(TipoBuffDebuff tipo, NomeHabilidadeDano nome, int turnos){
        this.tipo = tipo;
        this.nome = nome;
        this.turnos = turnos;
    }

    public NomeHabilidadeDano getNome() {
        return nome;
    }

    @Override
    public void exibe(Personagem alvo) {
        System.out.println("Usando habilidade de " + tipo + " no personagem" + alvo.getNome() + ": " + nome);
    }
}
