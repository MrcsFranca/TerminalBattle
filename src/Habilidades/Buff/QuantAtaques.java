package Habilidades.Buff;

import Personagem.Personagem;

public class QuantAtaques extends HabilidadeBuffDebuff {
    private int mudanca;

    public QuantAtaques(TipoBuffDebuff tipo, String nome, int turnos, int mudanca) {
        super(tipo, nome, turnos);
        this.mudanca = mudanca;
    }

    @Override
    public void usaHab(Personagem dono, Personagem alvo) {
        alvo.setQuantAtaques(alvo.getQuantAtaques() + mudanca);
    }
}
