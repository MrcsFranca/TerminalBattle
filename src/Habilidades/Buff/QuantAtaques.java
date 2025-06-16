package Habilidades.Buff;
import Habilidades.Habilidade;
import Habilidades.HabilidadeDanoCura;
import Personagem.Personagem;
/**
 * Classe que determina um buff ou debuff na quantidade e ataques que um personagem pode fazer por turno
 */
public class QuantAtaques extends HabilidadeBuffDebuff {
    /**
     * Construtor do objeto que determina um buff ou debuff na quantidade de ataques por turno de um personagem
     * @param tipo Tipo/elemento da habilidade
     * @param nome Nome da habilidade
     */
    public QuantAtaques(TipoBuffDebuff tipo, String nome, int qntdHab) {
        super(tipo, nome, qntdHab);
    }
    /**
     * Metodo para um personagem usar uma habilidade em um alvo
     * @author Caua Monteiro
     * @param dono Objeto do tipo Personagem: quem esta usando a habilidade
     * @param alvo Objeto do tipo Personagem: quem ira receber o efeito da habilidade
     */
    @Override
    public void usaHab(Personagem dono, Personagem alvo) {
        for(Habilidade elementos : alvo.getHabilidades()) {
            if(elementos.getClass() == HabilidadeDanoCura.class) {
                ((HabilidadeDanoCura) elementos).setQntHab(((HabilidadeDanoCura) elementos).getQntHab() + 2);
            } else if(elementos.getClass() == BuffDebuffDano.class) {
                ((BuffDebuffDano) elementos).setQntdHab(((BuffDebuffDano) elementos).getQntdHab() + 2);
            } else if(elementos.getClass() == QuantAtaques.class) {
                ((QuantAtaques) elementos).setQntdHab(((QuantAtaques) elementos).getQntdHab() + 2);
            }
        }
        alvo.setQuantAtaques(alvo.getQuantAtaques() + 2);
    }
    /**
     *
     * @param dono Objeto do tipo Personagem: quem esta usando a habilidade
     * @param alvo Objeto do tipo Personagem: quem ira receber o efeito da habilidade
     */
    @Override
    public void exibe(Personagem dono, Personagem alvo) {
        System.out.println("> " + dono.getNome() + " aumentou sua quantidade de ataques");
    }
    public int getQntHab(){
        return getQntdHab();
    }
}
