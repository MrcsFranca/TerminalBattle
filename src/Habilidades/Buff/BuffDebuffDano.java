package Habilidades.Buff;

import Personagem.Personagem;
/**
 * Classe que implementa um buff ou debuff de dano em um personagem
 */
public class BuffDebuffDano extends HabilidadeBuffDebuff{
    private double multiplicador;
    /**
     * Construtor do obejto da habilidade de buff ou debuff de dano
     * @author Caua Monteiro
     * @param tipo Tipo/Elemento da habilidade
     * @param nome Nome da habilidade
     * @param multiplicador Multiplicador de efeito da habilidade
     */
    public BuffDebuffDano(TipoBuffDebuff tipo, NomeHabilidadeBuffDebuff nome, double multiplicador, int qntdHab) {
        super(tipo, nome, qntdHab);
        this.multiplicador = multiplicador;
    }

    public double getMultiplicador() {
        return multiplicador;
    }
    /**
     * Metodo para usar uma habilidade de buff/debuff de dano
     * @author Caua Monteiro
     * @param dono Quem esta usando a habilidade
     * @param alvo Quem ira receber os efeitos da habilidade
     */
    @Override
    public void usaHab(Personagem dono, Personagem alvo) {
        alvo.setBoolBuffDano(true);
        alvo.setMultDano(alvo.getMultDano() * multiplicador);
    }
}
