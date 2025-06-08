package Habilidades.Buff;

import Habilidades.NomeHabilidadeDano;
import Personagem.Personagem;

public class QuantAtaques extends HabilidadeBuffDebuff {
    private int mudanca;

    public QuantAtaques(TipoBuffDebuff tipo, NomeHabilidadeDano nome, int turnos, int mudanca) {
        super(tipo, nome, turnos);
        this.mudanca = mudanca;
    }

    @Override
    public void usaHab(Personagem dono, Personagem alvo) {
        alvo.setQuantAtaques(alvo.getQuantAtaques() + mudanca);
    }
}
