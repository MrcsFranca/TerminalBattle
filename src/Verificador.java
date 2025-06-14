import Habilidades.Buff.BuffDebuffDano;
import Habilidades.Buff.QuantAtaques;
import Habilidades.Habilidade;
import Habilidades.HabilidadeDanoCura;
import Personagem.Personagem;

/**
 * Classe que verifica
 */
public class Verificador {
    public boolean verificaTodasHabilidadesZeradas(Personagem player) {
        boolean temHabilidade = false;
        int i = 0;
        while(i < player.getHabilidades().size() && !temHabilidade) {
            if(((HabilidadeDanoCura) player.getHabilidades().get(i)).getQntdHab() > 0) {
                temHabilidade = true;
            }
            i++;
        }
        return temHabilidade;
    }

    public void verificaHabilidadeZerada(Habilidade habilidade, Personagem dono, Personagem alvo) {
        if(habilidade.getClass() == HabilidadeDanoCura.class) {
            if(((HabilidadeDanoCura) habilidade).getQntdHab() > 0) {
                verificaTipoHabilidade(habilidade, dono, alvo);
            } else {
                System.out.println(habilidade.getNome() + " acabou e você não consegue mais usar");
            }
        } else if(habilidade.getClass() == BuffDebuffDano.class) {
            if(((BuffDebuffDano) habilidade).getQntdHab() > 0) {
                verificaTipoHabilidade(habilidade, dono, dono);
            } else {
                System.out.println(habilidade.getNome() + " acabou e você não consegue mais usar");
            }
        } else if(habilidade.getClass() == QuantAtaques.class) {
            if(((QuantAtaques) habilidade).getQntdHab() > 0) {
                verificaTipoHabilidade(habilidade, dono, dono);
            } else {
                System.out.println(habilidade.getNome() + " acabou e você não consegue mais usar");
            }
        }
    }

    public void verificaTipoHabilidade(Habilidade habilidade, Personagem dono, Personagem alvo) {
        int qntdHab = 0;
        if(habilidade.getClass() == HabilidadeDanoCura.class) {
            if(((HabilidadeDanoCura) habilidade).getIsCura()) {
                dono.atacar(dono, dono, habilidade);
                habilidade.exibe(dono, dono);
            } else {
                dono.atacar(dono, alvo, habilidade);
                habilidade.exibe(dono, alvo);
            }
            qntdHab = (((HabilidadeDanoCura) habilidade).getQntdHab());
            ((HabilidadeDanoCura) habilidade).setQntdHab(--qntdHab);
        } else if(habilidade.getClass() == BuffDebuffDano.class) {
            dono.atacar(dono, alvo, habilidade);
            habilidade.exibe(dono, alvo);
            qntdHab = (((BuffDebuffDano) habilidade).getQntdHab());
            ((BuffDebuffDano) habilidade).setQntdHab(--qntdHab);
        } else if(habilidade.getClass() == QuantAtaques.class) {
            dono.atacar(dono, dono, habilidade);
            habilidade.exibe(dono, alvo);
            qntdHab = (((QuantAtaques) habilidade).getQntdHab());
            ((QuantAtaques) habilidade).setQntdHab(--qntdHab);
        }
    }
}
