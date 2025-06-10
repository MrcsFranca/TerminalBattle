import Habilidades.HabilidadeDanoCura;
import Personagem.Personagem;

import java.util.Random;
import java.util.Scanner;

public class Acoes {
    public static void acaoJogador(Personagem player, Personagem npc) {
        int escolha = 0, qntdHab = 0;
        HabilidadeDanoCura verificaHabilidade;
        Scanner scanner = new Scanner(System.in);
        escolha = scanner.nextInt();
        if((escolha == 1)) {
            verificaHabilidade = (HabilidadeDanoCura) player.getHabilidades().get(0);
            if(verificaHabilidade.getQntdHab() > 0) {
                if(verificaHabilidade.getIsCura()) {
                    player.atacar(player, player, player.getHabilidades().get(0));
                    verificaHabilidade.exibe(player);
                } else {
                    player.atacar(player, npc, player.getHabilidades().get(0));
                    verificaHabilidade.exibe(npc);
                }
                qntdHab = ((HabilidadeDanoCura) player.getHabilidades().get(0)).getQntdHab();
                ((HabilidadeDanoCura) player.getHabilidades().get(0)).setQntdHab(--qntdHab);
            } else {
                System.out.println(player.getHabilidades().get(0).getNome() + " acabou e você não consegue mais usar");
            }
        } else if((escolha == 2) && (player.getHabilidades().size() >= 2)) {
            verificaHabilidade = (HabilidadeDanoCura) player.getHabilidades().get(1);
            if(verificaHabilidade.getQntdHab() > 0) {
                if(verificaHabilidade.getIsCura()) {
                    player.atacar(player, player, player.getHabilidades().get(1));
                    verificaHabilidade.exibe(player);
                } else {
                    player.atacar(player, npc, player.getHabilidades().get(1));
                    verificaHabilidade.exibe(npc);
                }
                qntdHab = ((HabilidadeDanoCura) player.getHabilidades().get(1)).getQntdHab();
                ((HabilidadeDanoCura) player.getHabilidades().get(1)).setQntdHab(--qntdHab);
            } else {
                System.out.println(player.getHabilidades().get(1).getNome() + " acabou e você não consegue mais usar");
            }
        } else if((escolha == 3) && (player.getHabilidades().size() >= 3)) {
            verificaHabilidade = (HabilidadeDanoCura) player.getHabilidades().get(2);
            if(verificaHabilidade.getQntdHab() > 0) {
                if(verificaHabilidade.getIsCura()) {
                    player.atacar(player, player, player.getHabilidades().get(2));
                    verificaHabilidade.exibe(player);
                } else {
                    player.atacar(player, npc, player.getHabilidades().get(2));
                    verificaHabilidade.exibe(npc);
                }
                qntdHab = ((HabilidadeDanoCura) player.getHabilidades().get(2)).getQntdHab();
                ((HabilidadeDanoCura) player.getHabilidades().get(2)).setQntdHab(--qntdHab);
            } else {
                System.out.println(player.getHabilidades().get(2).getNome() + " acabou e você não consegue mais usar");
            }
        } else if((escolha == 4) && (player.getHabilidades().size() == 4)) {
            verificaHabilidade = (HabilidadeDanoCura) player.getHabilidades().get(3);
            if(verificaHabilidade.getQntdHab() > 0) {
                if(verificaHabilidade.getIsCura()) {
                    player.atacar(player, player, player.getHabilidades().get(3));
                    verificaHabilidade.exibe(player);
                } else {
                    player.atacar(player, npc, player.getHabilidades().get(3));
                    verificaHabilidade.exibe(npc);
                }
                qntdHab = ((HabilidadeDanoCura) player.getHabilidades().get(3)).getQntdHab();
                ((HabilidadeDanoCura) player.getHabilidades().get(3)).setQntdHab(--qntdHab);
            } else {
                System.out.println(player.getHabilidades().get(3).getNome() + " acabou e você não consegue mais usar");
            }
        } else {
            System.out.println("Você não possui essa habilidade");
        }
    }

    public static void acaoNPC(Personagem player, Personagem npc) {
        HabilidadeDanoCura verificaHabilidade;
        Random random = new Random();
        int acao = random.nextInt(npc.getHabilidades().size());
        if((acao == 0)) {
            verificaHabilidade = (HabilidadeDanoCura) npc.getHabilidades().get(0);
            if(verificaHabilidade.getIsCura()) {
                npc.atacar(npc, npc, npc.getHabilidades().get(0));
                verificaHabilidade.exibe(npc);
            } else {
                npc.atacar(npc, player, npc.getHabilidades().get(0));
                verificaHabilidade.exibe(player);
            }
        } else if((acao == 1) && (npc.getHabilidades().size() >= 2)) {
            verificaHabilidade = (HabilidadeDanoCura) npc.getHabilidades().get(1);
            if(verificaHabilidade.getIsCura()) {
                npc.atacar(npc, npc, npc.getHabilidades().get(1));
                verificaHabilidade.exibe(npc);
            } else {
                npc.atacar(npc, player, npc.getHabilidades().get(1));
                verificaHabilidade.exibe(player);
            }
        } else if((acao == 2) && (npc.getHabilidades().size() >= 3)) {
            verificaHabilidade = (HabilidadeDanoCura) npc.getHabilidades().get(2);
            if(verificaHabilidade.getIsCura()) {
                npc.atacar(npc, npc, npc.getHabilidades().get(2));
                verificaHabilidade.exibe(npc);
            } else {
                npc.atacar(npc, player, npc.getHabilidades().get(2));
                verificaHabilidade.exibe(player);
            }
        } else if((acao == 3) && (npc.getHabilidades().size() == 4)) {
            verificaHabilidade = (HabilidadeDanoCura) npc.getHabilidades().get(3);
            if(verificaHabilidade.getIsCura()) {
                npc.atacar(npc, npc, npc.getHabilidades().get(3));
                verificaHabilidade.exibe(npc);
            } else {
                npc.atacar(npc, player, npc.getHabilidades().get(3));
                verificaHabilidade.exibe(player);
            }
        }
    }
}
