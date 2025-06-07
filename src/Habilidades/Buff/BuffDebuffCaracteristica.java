package Habilidades.Buff;

import Personagem.Personagem;

public class BuffDebuffCaracteristica extends HabilidadeBuffDebuff{
    private boolean caracteristica; //false para defesa || true para agilidade
    private double multi;

    public BuffDebuffCaracteristica(TipoBuffDebuff tipo, String nome, int turnos, boolean caracteristica, double multi) {
        super(tipo, nome, turnos);
        this.caracteristica = caracteristica;
        this.multi = multi;
    }

    public void usaHab(Personagem dono, Personagem alvo) {
        dono.setBoolBuffCarac(true);
        if(caracteristica)
            dono.setMultAgil(alvo.getMultAgil() + multi);
        else
            dono.setMultDef(alvo.getMultDef() + multi);
    }
}
