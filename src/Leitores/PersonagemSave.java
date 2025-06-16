package Leitores;

import Habilidades.TipoHabilidade;

import java.util.ArrayList;

public class PersonagemSave {
    private String nome;
    private int vidaMax, defesa, agilidade, quantAtaques;
    private double vidaAtual, multDano, multAgil, multDef;
    private ArrayList<String> habilidades;
    private TipoHabilidade tipo;
    private boolean BoolBuffCarac, BoolBuffDano;

    public PersonagemSave(String nome, int vidaMax, int defesa, int agilidade, int quantAtaques, double vidaAtual, double multDano, double multAgil, double multDef, ArrayList<String> habilidades, TipoHabilidade tipo, boolean boolBuffCarac, boolean boolBuffDano) {
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

    public ArrayList<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<String> habilidades) {
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

    @Override
    public String toString() {
        return "PersonagemSave{" +
                "nome='" + nome + '\'' +
                ", vidaMax=" + vidaMax +
                ", defesa=" + defesa +
                ", agilidade=" + agilidade +
                ", quantAtaques=" + quantAtaques +
                ", vidaAtual=" + vidaAtual +
                ", multDano=" + multDano +
                ", multAgil=" + multAgil +
                ", multDef=" + multDef +
                ", habilidades=" + habilidades +
                ", tipo=" + tipo +
                ", BoolBuffCarac=" + BoolBuffCarac +
                ", BoolBuffDano=" + BoolBuffDano +
                '}';
    }
}
