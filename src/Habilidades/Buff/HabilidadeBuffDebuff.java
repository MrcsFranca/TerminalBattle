package Habilidades.Buff;

import Habilidades.Habilidade;

public class HabilidadeBuffDebuff implements Habilidade {
    private String nome;
    private TipoBuffDebuff tipo;
    private int turnos;

    public HabilidadeBuffDebuff(TipoBuffDebuff tipo, int turnos, String nome){
        this.tipo = tipo;
        this.turnos = turnos;
        this.nome = nome;
    }


    @Override
    public void exibe() {
        System.out.println("Usando habilidade de " + tipo + ": " + nome);
    }
}
