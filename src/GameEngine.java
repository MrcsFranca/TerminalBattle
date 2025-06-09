import Habilidades.Habilidade;
import Habilidades.HabilidadeDanoCura;
import Personagem.Personagem;
import Personagem.Player;
import Personagem.Gerador;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class GameEngine {
    public static void run(Personagem player) {
        Scanner scanner = new Scanner(System.in);
        Gerador gerador = new Gerador();
        UI ui = new UI();
        int winstreak = 0, escolha, auxEscolha;

        while(player.getVidaAtual() > 0 && winstreak < 5) {
            System.out.println("----- "+ (winstreak + 1) + "ª batalha -----");

            Personagem npc = gerador.geraNPC();
            System.out.println(player.getNome() + " está batalhando contra " + npc.getNome());

            while(npc.getVidaAtual() > 0) {
                ui.personagemStats(player);
                ui.personagemStats(npc);

                // Usar try catch aqui e tentar deixar menos estruturado
                if(player.getAgilidade() >= npc.getAgilidade()) {
                    ui.escolherHabilidades(player);
                    acaoJogador(player, npc);
                    if(npc.getVidaAtual() > 0) {
                        acaoNPC(player, npc);
                    }
                } else if(npc.getAgilidade() > player.getAgilidade()) {
                    acaoNPC(player, npc);
                    ui.escolherHabilidades(player);
                    if(player.getVidaAtual() > 0) {
                        acaoJogador(player, npc);
                    }
                }
            }

            if(player.getVidaAtual() > 0) {
                ui.absorverHabilidade(player, npc);

                //try catch aqui para verificar se escolha é diferente do permitido (quant de habilidades que npc tem)
                escolha = scanner.nextInt();
                if(escolha != 0) {
                    ArrayList<Habilidade> habilidades = player.getHabilidades();
                    if(player.getHabilidades().size() == 4) {
                        auxEscolha = escolha;
                        System.out.println("Escolha uma de suas habilidades para substituir");
                        escolha = scanner.nextInt();
                        habilidades.remove(escolha - 1);
                        habilidades.add(escolha - 1, npc.getHabilidades().get(auxEscolha - 1));
                    } else {
                        habilidades.add(npc.getHabilidades().get(escolha - 1));
                    }
                    player.setHabilidades(habilidades);
                } else {
                    System.out.println("Escolha um de seus atributos para melhorar");
                    System.out.println("[1] Agilidade\n[2] Defesa\n[3] Recarregar as habilidades em 5\n");
                    escolha = scanner.nextInt();
                    switch(escolha) {
                        case 1:
                            player.setAgilidade(player.getAgilidade() + npc.getAgilidade());
                            break;
                        case 2:
                            player.setDefesa(player.getDefesa() + npc.getDefesa());
                            break;
                        case 3:
                            for(Habilidade elementos : player.getHabilidades()) {
                                ((HabilidadeDanoCura) elementos).setQntdHab(5);
                            }
                            break;
                        default:
                            System.out.println("Você escolheu não melhorar nada");
                    }
                }
                winstreak++;
            } else {
                ((Player) player).setWinStreak(winstreak);
                System.out.println("Você perdeu com uma winstreak de: " + ((Player) player).getWinStreak());
            }
        }
    }

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