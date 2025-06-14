package Habilidades.Buff;

import Habilidades.Habilidade;
import Personagem.Personagem;
/**
 * Classe para implementar uma habilidade de buff ou debuff
 */
public abstract class HabilidadeBuffDebuff implements Habilidade {
    private NomeHabilidadeBuffDebuff nome;
    private int qntdHab = 0;
    private TipoBuffDebuff tipo;
    /**
     * Construtor da habilidade que sera um buff ou debuff de Personagem
     * @author Caua Monteiro
     * @param tipo Tipo/Elemento da habilidade
     * @param nome Nome da habilidade
     */
    public HabilidadeBuffDebuff(TipoBuffDebuff tipo, NomeHabilidadeBuffDebuff nome, int qntdHab){
        this.tipo = tipo;
        this.nome = nome;
        this.qntdHab = qntdHab;
    }
    /**
     * Metodo para receber o nome da habilidade
     * @author Caua Monteiro
     * @return Retorna o nome da habilidade de jogo
     */
    public NomeHabilidadeBuffDebuff getNome() {
        return nome;
    }

    public void setQntdHab(int qntdHab) {
        this.qntdHab = qntdHab;
    }

    public int getQntdHab() {
        return qntdHab;
    }

    /**
     * Exibe as informações sobre o personagem que esta recendo a habilidade e qual habilidade vai ser usada
     * @author Caua Monteiro
     * @param alvo Objeto do tipo personagem que ira ser exibido informações
     */
    @Override
    public void exibe(Personagem dono, Personagem alvo) {
        System.out.println("> Usando " + nome + " de " + tipo);
    }
}
