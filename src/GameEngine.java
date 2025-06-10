import Habilidades.Habilidade;
import Habilidades.HabilidadeDanoCura;
import Personagem.Personagem;
import Personagem.Player;
import Personagem.Gerador;
import java.util.ArrayList;
import java.util.Scanner;

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

            while(player.getVidaAtual() > 0 && npc.getVidaAtual() > 0) {
                ui.personagemStats(player);
                ui.personagemStats(npc);

                // Usar try catch aqui e tentar deixar menos estruturado
                if(player.getAgilidade() >= npc.getAgilidade()) {
                    ui.escolherHabilidades(player);
                    Acoes.acaoJogador(player, npc);
                    if(npc.getVidaAtual() > 0) {
                        Acoes.acaoNPC(player, npc);
                    }
                } else if(npc.getAgilidade() > player.getAgilidade()) {
                    Acoes.acaoNPC(player, npc);
                    ui.escolherHabilidades(player);
                    if(player.getVidaAtual() > 0) {
                        Acoes.acaoJogador(player, npc);
                    }
                }

                int auxQntdHabilidade = 0;
                for(Habilidade elementos : player.getHabilidades()) {
                    if(((HabilidadeDanoCura) elementos).getQntdHab() > 0) {
                        auxQntdHabilidade = 1;
                        break;
                    }
                }
                if(auxQntdHabilidade == 0) {
                    System.out.println("Suas habilidades acabaram e você não consegue mais prosseguir\n Você perdeu.");
                    player.setVidaAtual(0);
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
}