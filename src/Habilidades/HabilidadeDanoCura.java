package Habilidades;

import Personagem.Personagem;
/**
 * Classe que implementa Habilidade, determina funcionalidade de uma habilidade que pode ser usada para cura ou dano
 * @author Caua Monteiro
 */
public class HabilidadeDanoCura implements Habilidade {
    private Enum nome;
    private int qntdHab;
    private double valor;
    private boolean isCura;
    private TipoHabilidade elemento;
    /**
     * Construtor de uma habilidade de cura ou dano
     * @author Marcos França
     * @param valor Valor de dano ou cura da habilidade
     * @param nome Nome da habilidade
     * @param isCura Booleano que determina se a habilidade é de cura ou não
     * @param elemento Tipo da habilidade
     * @param qntdHab Quantidade de vezes que a habilidade pode ser utilizada
     * @param <T> Tipo generico que extende os Enums para que o atributo nome utilize
     */
    public <T extends Enum> HabilidadeDanoCura(double valor, T nome, boolean isCura, TipoHabilidade elemento, int qntdHab){
        this.valor = valor;
        this.nome = nome;
        this.isCura = isCura;
        this.elemento = elemento;
        this.qntdHab = qntdHab;
    }
    /**
     * Classe que torna o nome de uma habilidade
     * @author Caua Monteiro
     * @return Retorna o nome de uma habilidade
     */
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
    /**
     * Define a utilização de uma habilidade, verificando se é uma cura ou não
     * @author Caua Monteiro
     * @param dono Quem esta usando a habilidade
     * @param alvo Quem vai receber a habilidade
     */
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

    /**
     * Exibe as informações sobre o personagem que esta recendo a habilidade e qual habilidade vai ser usada
     * @author Marcos França
     * @param alvo O objeto personagem em quem esta sendo exibido a habilidade sendo usada
     */
    @Override
    public void exibe(Personagem dono, Personagem alvo) {
        System.out.println("> " + dono.getNome() + " usou " + nome + " em " + alvo.getNome());
    }
}
