import Habilidades.Buff.BuffDebuffDano;
import Habilidades.Buff.QuantAtaques;
import Habilidades.Habilidade;
import Habilidades.HabilidadeDanoCura;
import Personagem.Personagem;
import Personagem.Player;
import Personagem.Gerador;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Esta classe define o funcionamento da logica de jogo, utilizando metodos e classes ja desenvolvidos
 */
public class GameEngine {
    /**
     * Metodo estatico para inicializar o jogo e sua logica
     * @author Marcos França
     * @param player O objeto que representa o player que estamos jogando
     * @exception
     */
    public static void run(Personagem player) {
        Scanner scanner = new Scanner(System.in);
        Gerador gerador = new Gerador();
        Verificador verificador = new Verificador();
        UI ui = new UI();
        int winstreak = 0, escolha, auxEscolha;
        boolean TemHabilidade = true;

        while(player.getVidaAtual() > 0 && winstreak < 5) {
            ui.limpar();
            System.out.println("----- "+ (winstreak + 1) + "ª batalha -----");

            Personagem npc = gerador.geraNPC();
            System.out.println(player.getNome() + " está batalhando contra " + npc.getNome());

            while(player.getVidaAtual() > 0 && npc.getVidaAtual() > 0 && TemHabilidade) {
                ui.personagemStats(player);
                ui.personagemStats(npc);

                // Usar try catch aqui e tentar deixar menos estruturado
                if(player.getAgilidade() >= npc.getAgilidade()) {
                    ui.escolherHabilidades(player);
                    Acoes.acaoJogador(player, npc);
                    System.out.println();
                    if(npc.getVidaAtual() > 0) {
                        Acoes.acaoNPC(player, npc);
                        System.out.println();
                    }
                } else {
                    ui.escolherHabilidades(player);
                    Acoes.acaoNPC(player, npc);
                    System.out.println();
                    if(player.getVidaAtual() > 0) {
                        Acoes.acaoJogador(player, npc);
                        System.out.println();
                    }
                }

                TemHabilidade = verificador.verificaTodasHabilidadesZeradas(player);
            }

            if(player.getVidaAtual() > 0 && TemHabilidade) {
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
                    ui.editarAtributos();
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
                                if(elementos.getClass() == HabilidadeDanoCura.class) {
                                    ((HabilidadeDanoCura) elementos).setQntdHab(((HabilidadeDanoCura) elementos).getQntdHab() + 5);
                                } else if(elementos.getClass() == BuffDebuffDano.class) {
                                    ((BuffDebuffDano) elementos).setQntdHab(((BuffDebuffDano) elementos).getQntdHab() + 5);
                                } else if(elementos.getClass() == QuantAtaques.class) {
                                    ((QuantAtaques) elementos).setQntdHab(((QuantAtaques) elementos).getQntdHab() + 5);
                                }
                            }
                            break;
                        default:
                            System.out.println("Você escolheu não melhorar nada");
                    }
                }
                winstreak++;
            } else {
                ui.perdeu(player, TemHabilidade, winstreak);
            }
        }
    }
}