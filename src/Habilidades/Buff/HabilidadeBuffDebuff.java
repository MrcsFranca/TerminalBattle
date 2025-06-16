package Habilidades.Buff;

import Habilidades.Habilidade;
import Personagem.Personagem;
/**
 * Classe para implementar uma habilidade de buff ou debuff
 */
public abstract class HabilidadeBuffDebuff implements Habilidade {
    private TipoBuffDebuff tipo;
    private String nome;
    private int qntdHab;
    /**
     * Construtor da habilidade que sera um buff ou debuff de Personagem
     * @author Caua Monteiro
     * @param tipo Tipo/Elemento da habilidade
     * @param nome Nome da habilidade
     */
    public HabilidadeBuffDebuff(TipoBuffDebuff tipo, String nome, int qntdHab){
        this.tipo = tipo;
        this.nome = nome;
        this.qntdHab = qntdHab;
    }

    public HabilidadeBuffDebuff(HabilidadeBuffDebuff hab){
        this.tipo = hab.tipo;
        this.nome = hab.nome;
        this.qntdHab = hab.qntdHab;
    }
    /**
     * Metodo para receber o nome da habilidade
     * @author Caua Monteiro
     * @return Retorna o nome da habilidade de jogo
     */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome){this.nome = nome;}

    public TipoBuffDebuff getTipo() {
        return tipo;
    }

    public void setTipo(TipoBuffDebuff tipo) {
        this.tipo = tipo;
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
