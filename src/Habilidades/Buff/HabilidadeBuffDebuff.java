package Habilidades.Buff;

import Habilidades.Habilidade;
import Personagem.Personagem;

public abstract class HabilidadeBuffDebuff implements Habilidade {
    private NomeHabilidadeBuffDebuff nome;
    private int qntdHab = 0;
    private TipoBuffDebuff tipo;

    public HabilidadeBuffDebuff(TipoBuffDebuff tipo, NomeHabilidadeBuffDebuff nome, int qntdHab){
        this.tipo = tipo;
        this.nome = nome;
        this.qntdHab = qntdHab;
    }

    public NomeHabilidadeBuffDebuff getNome() {
        return nome;
    }

    public void setQntdHab(int qntdHab) {
        this.qntdHab = qntdHab;
    }

    public int getQntdHab() {
        return qntdHab;
    }

    @Override
    public void exibe(Personagem dono, Personagem alvo) {
        System.out.println("> Usando " + nome + " de " + tipo);
    }
}
