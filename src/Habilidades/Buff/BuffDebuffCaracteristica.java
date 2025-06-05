package Habilidades.Buff;

public class BuffDebuffCaracteristica extends HabilidadeBuffDebuff{
    boolean caracteristica; //false para defesa || true para agilidade
    double multi;

    public BuffDebuffCaracteristica(TipoBuffDebuff tipo, int turnos, String nome, boolean caracteristica, double multi) {
        super(tipo, turnos, nome);
        this.caracteristica = caracteristica;
        this.multi = multi;
    }

    @Override
    public void usaHab(Personagem alvo) {
        alvo.setBoolBuffCarac(true);
        if(caracteristica)
            alvo.setMultAgil(alvo.getMultAgil() + multi);
        else
            alvo.setMultDef(alvo.getMultDef() + multi);

    }
}
