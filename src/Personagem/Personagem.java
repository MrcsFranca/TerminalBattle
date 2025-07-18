package Personagem;

import Habilidades.Habilidade;
import Habilidades.TipoHabilidade;

import java.util.*;
/**
 * Classe abstrata que representa os componentes principais que qualquer personagem, seja o player, seja um NPC, irã possuir
 */
public abstract class Personagem {
    private String nome;
    private int vidaMax, defesa, agilidade, quantAtaques;
    private double vidaAtual, multDano, multAgil, multDef;
    private ArrayList<Habilidade> habilidades;
    private TipoHabilidade tipo;
    private boolean BoolBuffCarac, BoolBuffDano;
    /**
     * Construtor da super-classe que define os atributos principais de um personagem
     * @author Lucas Polidorio
     * @param nome Representa o nome do peronagem
     * @param vidaMax Representa a vida máxima de um personagem
     * @param vidaAtual Representa a vida atual de um personagem
     * @param defesa Representa a quantidade de defesa de um personagem
     * @param agilidade Representa a quantidade de agilidade de um personagem, representando quem vai atacar primeiro em um combate
     * @param habilidades Um arrayList de habilidades que representa quais habilidades um personagem irá começar
     * @param tipo Representa o tipo do personagem, isto é, o elemento dele
     */
    public Personagem(String nome, int vidaMax, int defesa, int agilidade, int quantAtaques, double vidaAtual, double multDano, double multAgil, double multDef, ArrayList<Habilidade> habilidades, TipoHabilidade tipo, boolean boolBuffCarac, boolean boolBuffDano) {
        this.nome = nome;
        this.vidaMax = vidaMax;
        this.defesa = defesa;
        this.agilidade = agilidade;
        this.quantAtaques = quantAtaques;
        this.vidaAtual = vidaAtual;
        this.multDano = multDano;
        this.multAgil = multAgil;
        this.multDef = multDef;
        this.habilidades = habilidades;
        this.tipo = tipo;
        BoolBuffCarac = boolBuffCarac;
        BoolBuffDano = boolBuffDano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVidaMax() {
        return vidaMax;
    }

    public void setVidaMax(int vidaMax) {
        this.vidaMax = vidaMax;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    public int getQuantAtaques() {
        return quantAtaques;
    }

    public void setQuantAtaques(int quantAtaques) {
        this.quantAtaques = quantAtaques;
    }

    public double getVidaAtual() {
        return vidaAtual;
    }

    public void setVidaAtual(double vidaAtual) {
        this.vidaAtual = vidaAtual;
    }

    public double getMultDano() {
        return multDano;
    }

    public void setMultDano(double multDano) {
        this.multDano = multDano;
    }

    public double getMultAgil() {
        return multAgil;
    }

    public void setMultAgil(double multAgil) {
        this.multAgil = multAgil;
    }

    public double getMultDef() {
        return multDef;
    }

    public void setMultDef(double multDef) {
        this.multDef = multDef;
    }

    public ArrayList<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }

    public TipoHabilidade getTipo() {
        return tipo;
    }

    public void setTipo(TipoHabilidade tipo) {
        this.tipo = tipo;
    }

    public boolean isBoolBuffCarac() {
        return BoolBuffCarac;
    }

    public void setBoolBuffCarac(boolean boolBuffCarac) {
        BoolBuffCarac = boolBuffCarac;
    }

    public boolean isBoolBuffDano() {
        return BoolBuffDano;
    }

    public void setBoolBuffDano(boolean boolBuffDano) {
        BoolBuffDano = boolBuffDano;
    }

    /**
     * Método abstrato para ataques. Sera implementado em sub-classes de personagem
     * @author Lucas Polidorio
     * @param dono O personagem que esta atacando
     * @param alvo O alvo que sera atacado
     * @param hab A habilidade que esta sendo usada para atacar
     */
    public abstract void atacar(Personagem dono, Personagem alvo, Habilidade hab);
}
