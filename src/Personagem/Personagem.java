package Personagem;

import Habilidades.Habilidade;

import java.util.*;


public abstract class Personagem {
    private int vidaMax, vidaAtual, qntdHab, defesa, agilidade, carisma;
    private ArrayList<Habilidade> habilidades;
    private String tipo;

    public Personagem(int vidaMax, int vidaAtual, int qntdHab, int defesa, int agilidade, int carisma, ArrayList<Habilidade>habilidades, String tipo){
        this.vidaMax = vidaMax;
        this.vidaAtual = vidaAtual;
        this.qntdHab = qntdHab;
        this.defesa = defesa;
        this.agilidade = agilidade;
        this.carisma = carisma;
        this.habilidades = habilidades;
        this.tipo = tipo;
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
    public int getCarisma() {
        return carisma;
    }
    public int getDefesa() {
        return defesa;
    }
    public String getTipo() {
        return tipo;
    }
    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }
    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }
    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }
    public void setQntdHab(int qntdHab) {
        this.qntdHab = qntdHab;
    }
    public void setHabilidades(ArrayList<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setVidaAtual(int vidaAtual) {
        this.vidaAtual = vidaAtual;
    }
    public void setVidaMax(int vidaMax) {
        this.vidaMax = vidaMax;
    }

    public abstract void atacar(Personagem alvo, Habilidade hab);

}
