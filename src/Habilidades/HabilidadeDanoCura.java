package Habilidades;

import Personagem.Personagem;

public abstract class HabilidadeDanoCura implements Habilidade {
    private String nome;
    private int valor, turnos;
    private boolean isCura;
    private TipoHabilidade elemento;

    public HabilidadeDanoCura(int valor, int turnos, String nome, boolean isCura, TipoHabilidade elemento ){
        this.valor = valor;
        this.turnos = turnos;
        this.nome = nome;
        this.isCura = isCura;
        this.elemento = elemento;
    }

    public int getDano(){
        return valor;
    }

    public void setTurnos(int turnos){
        this.turnos = turnos;
    }

    public int getTurnos(){
        return turnos;
    }

    public TipoHabilidade getElemento(){
        return elemento;
    }

    @Override
    public void usaHab(Personagem dono, Personagem alvo) {
        if(!isCura) {
            alvo.setVidaAtual(alvo.getVidaAtual() - (valor * dono.getMultDano()));
        }
        else{
            alvo.setVidaAtual(alvo.getVidaAtual() + valor);
        }
    }

    @Override
    public void exibe(Personagem alvo) {
        System.out.println("Usando " + nome + " em " + alvo.getNome());
    }
}
