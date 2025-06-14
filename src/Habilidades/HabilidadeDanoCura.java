package Habilidades;

import Personagem.Personagem;

public class HabilidadeDanoCura implements Habilidade {
    private Enum nome;
    private int qntdHab;
    private double valor;
    private boolean isCura;
    private TipoHabilidade elemento;

    public <T extends Enum> HabilidadeDanoCura(double valor, T nome, boolean isCura, TipoHabilidade elemento, int qntdHab){
        this.valor = valor;
        this.nome = nome;
        this.isCura = isCura;
        this.elemento = elemento;
        this.qntdHab = qntdHab;
    }

    public Enum getNome() {
        return nome;
    }

    public void setQntdHab(int qntdHab) {
        this.qntdHab = qntdHab;
    }

    public int getQntdHab() {
        return qntdHab;
    }

    public boolean getIsCura() {
        return isCura;
    }

    public double getDano(){
        return valor;
    }

    public TipoHabilidade getElemento(){
        return elemento;
    }

    @Override
    public void usaHab(Personagem dono, Personagem alvo) {
        if(!isCura) {
            alvo.setVidaAtual((alvo.getVidaAtual() - (valor * dono.getMultDano())) + ((double) alvo.getDefesa() / 5));
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
    public void exibe(Personagem dono, Personagem alvo) {
        System.out.println("> " + dono.getNome() + " usou " + nome + " em " + alvo.getNome());
    }
}
