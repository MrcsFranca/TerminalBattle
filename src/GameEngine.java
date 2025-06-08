import Habilidades.Habilidade;
import Habilidades.HabilidadeDanoCura;
import Personagem.Personagem;
import Personagem.Gerador;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class GameEngine {
    public static void run(Personagem player) {
        Gerador gerador = new Gerador();
        int winstreak = 0, escolha, auxEscolha;
        while(player.getVidaAtual() > 0 && winstreak < 5) {
            System.out.println("----- "+ (winstreak + 1) + "ª batalha -----");

            Personagem npc = gerador.geraNPC();
            System.out.println(player.getNome() + " está batalhando contra " + npc.getNome());

            while(npc.getVidaAtual() > 0) {
                escolha = 1;
                System.out.printf("\nVida de " + player.getNome() + ": %.2f\n" + "\nVida de " + npc.getNome() + ": %.2f\n", player.getVidaAtual(), npc.getVidaAtual());
                System.out.println();

                System.out.println(player.getNome() + ", escolha uma de suas habilidades...");
                for(Habilidade elementos : player.getHabilidades()) {
                    System.out.println("[" + escolha + "] " + elementos.getNome());
                    escolha++;
                }

                // Usar try catch aqui e tentar deixar menos estruturado
                acaoJogador(player, npc);


                if(npc.getVidaAtual() > 0) {
                    acaoNPC(player, npc);
                }
                System.out.println(((HabilidadeDanoCura) (npc.getHabilidades().get(0))).getDano());
            }

            System.out.println(npc.getNome() + " foi derrotado por " + player.getNome());

            System.out.println("Escolha uma das habilidades de " + npc.getNome() + " para ser sua (0 - não absorve nova habilidade)");
            escolha = 1;
            for(Habilidade elementos : npc.getHabilidades()) {
                System.out.println("[" + escolha + "] " + elementos.getNome());
                escolha++;
            }
            //try catch aqui para verificar se escolha é diferente do permitido (quant de habilidades que npc tem)
            Scanner scanner = new Scanner(System.in);
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
            }

            winstreak++;
        }
    }

    public static void acaoJogador(Personagem player, Personagem npc) {
        int escolha = 0;
        HabilidadeDanoCura verificaCura;
        Scanner scanner = new Scanner(System.in);
        escolha = scanner.nextInt();
        if((escolha == 1)) {
            verificaCura = (HabilidadeDanoCura) player.getHabilidades().get(0);
            if(verificaCura.getIsCura()) {
                player.atacar(player, player, player.getHabilidades().get(0));
                verificaCura.exibe(player);
            } else {
                player.atacar(player, npc, player.getHabilidades().get(0));
                verificaCura.exibe(npc);
            }
        } else if((escolha == 2) && (player.getHabilidades().size() >= 2)) {
            verificaCura = (HabilidadeDanoCura) player.getHabilidades().get(1);
            if(verificaCura.getIsCura()) {
                player.atacar(player, player, player.getHabilidades().get(1));
                verificaCura.exibe(player);
            } else {
                player.atacar(player, npc, player.getHabilidades().get(1));
                verificaCura.exibe(npc);
            }
        } else if((escolha == 3) && (player.getHabilidades().size() >= 3)) {
            verificaCura = (HabilidadeDanoCura) player.getHabilidades().get(2);
            if(verificaCura.getIsCura()) {
                player.atacar(player, player, player.getHabilidades().get(2));
                verificaCura.exibe(player);
            } else {
                player.atacar(player, npc, player.getHabilidades().get(2));
                verificaCura.exibe(npc);
            }
        } else if((escolha == 4) && (player.getHabilidades().size() == 4)) {
            verificaCura = (HabilidadeDanoCura) player.getHabilidades().get(3);
            if(verificaCura.getIsCura()) {
                player.atacar(player, player, player.getHabilidades().get(3));
                verificaCura.exibe(player);
            } else {
                player.atacar(player, npc, player.getHabilidades().get(3));
                verificaCura.exibe(npc);
            }
        } else {
            System.out.println("Você não possui esse habilidade");
        }
    }

    public static void acaoNPC(Personagem player, Personagem npc) {
        HabilidadeDanoCura verificaCura;
        Random random = new Random();
        int acao = random.nextInt(npc.getHabilidades().size());
        if((acao == 0)) {
            verificaCura = (HabilidadeDanoCura) npc.getHabilidades().get(0);
            if(verificaCura.getIsCura()) {
                npc.atacar(npc, npc, npc.getHabilidades().get(0));
                verificaCura.exibe(npc);
            } else {
                npc.atacar(npc, player, npc.getHabilidades().get(0));
                verificaCura.exibe(player);
            }
        } else if((acao == 1) && (npc.getHabilidades().size() >= 2)) {
            verificaCura = (HabilidadeDanoCura) npc.getHabilidades().get(1);
            if(verificaCura.getIsCura()) {
                npc.atacar(npc, npc, npc.getHabilidades().get(1));
                verificaCura.exibe(npc);
            } else {
                npc.atacar(npc, player, npc.getHabilidades().get(1));
                verificaCura.exibe(player);
            }
        } else if((acao == 2) && (npc.getHabilidades().size() >= 3)) {
            verificaCura = (HabilidadeDanoCura) npc.getHabilidades().get(2);
            if(verificaCura.getIsCura()) {
                npc.atacar(npc, npc, npc.getHabilidades().get(2));
                verificaCura.exibe(npc);
            } else {
                npc.atacar(npc, player, npc.getHabilidades().get(2));
                verificaCura.exibe(player);
            }
        } else if((acao == 3) && (npc.getHabilidades().size() == 4)) {
            verificaCura = (HabilidadeDanoCura) npc.getHabilidades().get(3);
            if(verificaCura.getIsCura()) {
                npc.atacar(npc, npc, npc.getHabilidades().get(3));
                verificaCura.exibe(npc);
            } else {
                npc.atacar(npc, player, npc.getHabilidades().get(3));
                verificaCura.exibe(player);
            }
        }
    }
}
/*
            System.out.println(player.getNome());
            System.out.println(player.getTipo());
            System.out.println(player.getHabilidades());
            System.out.println(player.getVidaMax());
            System.out.println(player.getVidaAtual());
            System.out.println(player.getDefesa());
            System.out.println(player.getAgilidade());
            System.out.println(player.getMultDano());
            System.out.println(player.getMultDef());
            System.out.println(player.getMultAgil());
            System.out.println(player.getQntdHab());

            System.out.println(npc.getNome());
            System.out.println(npc.getTipo());
            System.out.println(npc.getHabilidades());
            System.out.println(npc.getVidaMax());
            System.out.println(npc.getVidaAtual());
            System.out.println(npc.getDefesa());
            System.out.println(npc.getAgilidade());
            System.out.println(npc.getMultDano());
            System.out.println(npc.getMultDef());
            System.out.println(npc.getMultAgil());
            System.out.println(npc.getQntdHab());
*/