package Habilidades.Buff;

import Personagem.Personagem;

public class BuffDebuffDano extends HabilidadeBuffDebuff{
    private double multiplicador;

    public BuffDebuffDano(TipoBuffDebuff tipo, NomeHabilidadeBuffDebuff nome, double multiplicador, int qntdHab) {
        super(tipo, nome, qntdHab);
        this.multiplicador = multiplicador;
    }

    public double getMultiplicador() {
        return multiplicador;
    }

    @Override
    public void usaHab(Personagem dono, Personagem alvo) {
        alvo.setBoolBuffDano(true);
        alvo.setMultDano(alvo.getMultDano() * multiplicador);
    }
}
