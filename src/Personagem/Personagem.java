package Personagem;

import Habilidades.Habilidade;

import java.util.*;


public abstract class Personagem {
    private int vidaMax, vidaAtual, qntdHab, defesa, agilidade, quantAtaques;
    private ArrayList<Habilidade> habilidades;
    private String tipo;
    private boolean BoolBuffCarac, BoolBuffDano;

    public Personagem(int vidaMax, int vidaAtual, int qntdHab, int defesa, int agilidade, ArrayList<Habilidade>habilidades, String tipo){
        this.vidaMax = vidaMax;
        this.vidaAtual = vidaAtual;
        this.qntdHab = qntdHab;
        this.defesa = defesa;
        this.agilidade = agilidade;
        this.habilidades = habilidades;
        this.tipo = tipo;
        this.quantAtaques = 1;
        this.BoolBuffCarac = false;
        this.BoolBuffDano = false;
    }
    public int getVidaMax() {
        return vidaMax;
    }
    public int getQntdHab() {
        return qntdHab;
    }

    public ArrayList<Habilidade> getHabilidades() {
        return habilidades;
    }
    public int getAgilidade() {
        return agilidade;
    }
    public int getDefesa() {
        return defesa;
    }
    public String getTipo() {
        return tipo;
    }
    public int getQuantAtaques() {return  quantAtaques;}
    public boolean getBoolBuffCarac() {return BoolBuffCarac;}
    public boolean getBoolBuffDano() {return BoolBuffDano;}
    public void setAgilidade(int agilidade) {this.agilidade = agilidade;}
    public void setDefesa(int defesa) {this.defesa = defesa;}
    public void setQntdHab(int qntdHab) {this.qntdHab = qntdHab;}
    public void setHabilidades(ArrayList<Habilidade> habilidades) {this.habilidades = habilidades;}
    public void setTipo(String tipo) {this.tipo = tipo;}
    public void setVidaAtual(int vidaAtual) {this.vidaAtual = vidaAtual;}
    public void setVidaMax(int vidaMax) {this.vidaMax = vidaMax;}
    public void setQuantAtaques(int quantAtaques) { this.quantAtaques = quantAtaques;}
    public void setBoolBuffCarac(boolean boolBuffCarac) {BoolBuffCarac = boolBuffCarac;}
    public void setBoolBuffDano(boolean boolBuffDano) {BoolBuffDano = boolBuffDano;}

    public abstract void atacar(Personagem alvo, Habilidade hab);

}
