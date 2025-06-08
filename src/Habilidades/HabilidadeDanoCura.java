package Habilidades;

import Personagem.Personagem;

public class HabilidadeDanoCura implements Habilidade {
    private Enum nome;
    private int turnos;
    private double valor;
    private boolean isCura;
    private TipoHabilidade elemento;

    public <T extends Enum> HabilidadeDanoCura(double valor, int turnos, T nome, boolean isCura, TipoHabilidade elemento ){
        this.valor = valor;
        this.turnos = turnos;
        this.nome = nome;
        this.isCura = isCura;
        this.elemento = elemento;
    }

    public Enum getNome() {
        return nome;
    }

    public boolean getIsCura() {
        return isCura;
    }

    public double getDano(){
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
            if((valor + alvo.getVidaAtual()) >= alvo.getVidaMax()) {
                alvo.setVidaAtual(alvo.getVidaMax());
            } else {
                alvo.setVidaAtual(alvo.getVidaAtual() + valor);
            }
        }
    }

    @Override
    public void exibe(Personagem alvo) {
        System.out.println("Usando " + nome + " em " + alvo.getNome());
    }
}
