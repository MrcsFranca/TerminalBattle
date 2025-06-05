package Habilidades.Buff;

public class QuantAtaques extends HabilidadeBuffDebuff {
    int mudanca;

    public QuantAtaques(TipoBuffDebuff tipo, int turnos, String nome, int mudanca) {
        super(tipo, turnos, nome);
        this.mudanca = mudanca;
    }

    @Override
    public void usaHab(Personagem alvo) {
        alvo.setQuantAtaque(alvo.getQuantAtaque() + mudanca);
    }
}
