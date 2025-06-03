package Habilidades;

public abstract class HabilidadeBuffDebuff implements Habilidade {
    private TipoBuffDebuff tipo;
    public HabilidadeBuffDebuff(TipoBuffDebuff t){
        tipo = t;
    }

}
