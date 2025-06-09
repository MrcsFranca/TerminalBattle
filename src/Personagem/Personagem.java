package Personagem;

import Habilidades.Habilidade;
import Habilidades.TipoHabilidade;

import java.util.*;

public abstract class Personagem {
    private String nome;
    private int vidaMax, defesa, agilidade, quantAtaques;
    private double vidaAtual, multDano, multAgil, multDef;
    private ArrayList<Habilidade> habilidades;
    private TipoHabilidade tipo;
    private boolean BoolBuffCarac, BoolBuffDano;

    public Personagem(String nome, int vidaMax, int vidaAtual, int defesa, int agilidade, ArrayList<Habilidade>habilidades, TipoHabilidade tipo){
        this.nome = nome;
        this.vidaMax = vidaMax;
        this.vidaAtual = vidaAtual;
        this.defesa = defesa;
        this.agilidade = agilidade;
        this.habilidades = habilidades;
        this.tipo = tipo;
        this.quantAtaques = 1;
        this.BoolBuffCarac = false;
        this.BoolBuffDano = false;
        multDef = multAgil = multDano = 1;
    }

    public String getNome() {
        return nome;
    }

    public int getVidaMax() {
        return vidaMax;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setTipo(TipoHabilidade tipo) {
        this.tipo = tipo;
    }

    public TipoHabilidade getTipo() {
        return tipo;
    }

    public void setQuantAtaques(int quantAtaques) {
        this.quantAtaques = quantAtaques;
    }

    public int getQuantAtaques() {
        return  quantAtaques;
    }

    public void setBoolBuffCarac(boolean boolBuffCarac) {
        BoolBuffCarac = boolBuffCarac;
    }

    public boolean getBoolBuffCarac() {
        return BoolBuffCarac;
    }

    public void setBoolBuffDano(boolean boolBuffDano) {
        BoolBuffDano = boolBuffDano;
    }

    public boolean getBoolBuffDano() {
        return BoolBuffDano;
    }

    public void setHabilidades(ArrayList<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }

    public ArrayList<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void setVidaAtual(double vidaAtual) {
        this.vidaAtual = vidaAtual;
    }

    public double getVidaAtual() {
        return vidaAtual;
    }

    public void setMultDano(double multDano) {
        this.multDano = multDano;
    }

    public double getMultDano() {
        return multDano;
    }

    public void setMultAgil(double multAgil) {
        this.multAgil = multAgil;
    }

    public double getMultAgil() {
        return multAgil;
    }

    public void setMultDef(double v) {
        this.multDef= multDef;
    }

    public double getMultDef() {
        return multDef;
    }

    public abstract void atacar(Personagem dono, Personagem alvo, Habilidade hab);
}
