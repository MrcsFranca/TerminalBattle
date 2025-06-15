import Excecoes.EscolhaInvalida;
import Excecoes.HabilidadeZerada;
import Habilidades.Buff.BuffDebuffDano;
import Habilidades.Buff.QuantAtaques;
import Habilidades.HabilidadeDanoCura;
import Personagem.Personagem;

import java.util.Random;
import java.util.Scanner;
/**
 * Classe que define as ações que o NPC e o personagem jogável podem fazer
 */
public class Acoes {
    /**
     * Metodo que define a ação de um Player, utilizando uma habilidade
     * @author Marcos França
     * @param player É o objeto que o método recebe que define o jogador que vai usar uma habilidade
     * @param npc É o objeto que o método recebe que define em qual NPC o jogador vai realizar uma ação
     */
    public static void acaoJogador(Personagem player, Personagem npc) {
        Verificador verificador = new Verificador();
        int escolha = 0;
        boolean escolhaValida;
        Scanner scanner = new Scanner(System.in);

        do {
            String entrada = scanner.nextLine();
            escolhaValida = true;
            try {
                escolha = Integer.parseInt(entrada);
                if(escolha < 1 || escolha > player.getHabilidades().size()) {
                    throw new EscolhaInvalida(escolha);
                } else if((player.getHabilidades().get(escolha-1).getClass() == HabilidadeDanoCura.class) && ((HabilidadeDanoCura)player.getHabilidades().get(escolha-1)).getQntdHab() == 0) {
                    throw new HabilidadeZerada();
                } else if((player.getHabilidades().get(escolha-1).getClass() == BuffDebuffDano.class) && ((BuffDebuffDano)player.getHabilidades().get(escolha-1)).getQntdHab() == 0) {
                    throw new HabilidadeZerada();
                } else if((player.getHabilidades().get(escolha-1).getClass() == QuantAtaques.class) && ((QuantAtaques)player.getHabilidades().get(escolha-1)).getQntdHab() == 0) {
                    throw new HabilidadeZerada();
                }
            } catch(EscolhaInvalida escolhaInvalida) {
                System.out.println(escolhaInvalida);
                escolhaValida = false;
            } catch(HabilidadeZerada habilidadeZerada) {
                System.out.println(habilidadeZerada);
                escolhaValida = false;
            } catch(Exception exception) {
                System.out.println("Erro: escolha um numero inteiro valido");
                escolhaValida = false;
            }
        } while(!(escolhaValida));

        if((escolha == 1)) {
            verificador.verificaHabilidadeZerada(player.getHabilidades().getFirst(), player, npc);
        } else if((escolha == 2) && (player.getHabilidades().size() >= 2)) {
            verificador.verificaHabilidadeZerada(player.getHabilidades().get(1), player, npc);
        } else if((escolha == 3) && (player.getHabilidades().size() >= 3)) {
            verificador.verificaHabilidadeZerada(player.getHabilidades().get(2), player, npc);
        } else if((escolha == 4) && (player.getHabilidades().size() == 4)) {
            verificador.verificaHabilidadeZerada(player.getHabilidades().get(3), player, npc);
        } else {
            System.out.println("Você não possui essa habilidade");
        }
    }
    /**
     * Metodo que define a ação de um NPC, utilizando uma habilidade
     * @author Marcos França
     * @param player É o objeto que o método recebe que define em quem o NPC vai usar uma habilidade
     * @param npc É o objeto que o método recebe que define qual NPC vai realizar uma acao
     */
    public static void acaoNPC(Personagem player, Personagem npc) {
        Verificador verificador = new Verificador();
        Random random = new Random();
        int acao = random.nextInt(npc.getHabilidades().size());
        if((acao == 0)) {
            verificador.verificaTipoHabilidade(npc.getHabilidades().getFirst(), npc, player);
        } else if((acao == 1) && (npc.getHabilidades().size() >= 2)) {
            verificador.verificaTipoHabilidade(npc.getHabilidades().get(1), npc, player);
        } else if((acao == 2) && (npc.getHabilidades().size() >= 3)) {
            verificador.verificaTipoHabilidade(npc.getHabilidades().get(2), npc, player);
        } else if((acao == 3) && (npc.getHabilidades().size() == 4)) {
            verificador.verificaTipoHabilidade(npc.getHabilidades().get(3), npc, player);
        }
    }
}
