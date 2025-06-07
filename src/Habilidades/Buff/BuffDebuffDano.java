package Habilidades.Buff;

import Personagem.Personagem;

public class BuffDebuffDano extends HabilidadeBuffDebuff{
    private double multiplicador;

    public BuffDebuffDano(TipoBuffDebuff tipo, String nome, int turnos, double multiplicador) {
        super(tipo, nome, turnos);
        this.multiplicador = multiplicador;
    }

    @Override
    public void usaHab(Personagem dono, Personagem alvo) {
        alvo.setBoolBuffDano(true);
        alvo.setMultDano(alvo.getMultDano() * multiplicador);
    }
}
