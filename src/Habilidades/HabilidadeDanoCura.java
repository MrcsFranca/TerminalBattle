package Habilidades;

public abstract class HabilidadeDanoCura implements Habilidade {
    private int valor;
    private int turnos;
    private TipoHabilidade elemento;

    public HabilidadeDanoCura(int v, int t){
        valor = v;
        turnos = t;
    }

    public int getDano(){
        return valor;
    }
    public int getTurnos(){
        return turnos;
    }
    public void setTurnos(int t){
        this.turnos = t;
    }
}
