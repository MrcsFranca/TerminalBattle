package Habilidades.Buff;
import Habilidades.Habilidade;
import Habilidades.HabilidadeDanoCura;
import Personagem.Personagem;

public class QuantAtaques extends HabilidadeBuffDebuff {
    public QuantAtaques(TipoBuffDebuff tipo, NomeHabilidadeBuffDebuff nome, int qntdHab) {
        super(tipo, nome, qntdHab);
    }

    @Override
    public void usaHab(Personagem dono, Personagem alvo) {
        for(Habilidade elementos : alvo.getHabilidades()) {
            if(elementos.getClass() == HabilidadeDanoCura.class) {
                ((HabilidadeDanoCura) elementos).setQntdHab(((HabilidadeDanoCura) elementos).getQntdHab() + 2);
            } else if(elementos.getClass() == BuffDebuffDano.class) {
                ((BuffDebuffDano) elementos).setQntdHab(((BuffDebuffDano) elementos).getQntdHab() + 2);
            } else if(elementos.getClass() == QuantAtaques.class) {
                ((QuantAtaques) elementos).setQntdHab(((QuantAtaques) elementos).getQntdHab() + 2);
            }
        }
        alvo.setQuantAtaques(alvo.getQuantAtaques() + 2);
    }

    @Override
    public void exibe(Personagem dono, Personagem alvo) {
        System.out.println("> " + dono.getNome() + " aumentou sua quantidade de ataques");
    }
}
