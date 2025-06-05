package Habilidades.Buff;

public class BuffDebuffDano extends HabilidadeBuffDebuff{
    double multiplicador;

    public BuffDebuffDano(TipoBuffDebuff tipo, int turnos, String nome, double multiplicador) {
        super(tipo, turnos, nome);
        this.multiplicador = multiplicador;
    }

    @Override
    public void usaHab(Personagem alvo) {
        alvo.setBoolBuffDano(true);
        alvo.setMultDano(alvo.getMultDano() + multiplicador);
    }
}
