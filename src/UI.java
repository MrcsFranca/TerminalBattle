import Habilidades.Buff.BuffDebuffDano;
import Habilidades.Buff.HabilidadeBuffDebuff;
import Habilidades.Buff.QuantAtaques;
import Habilidades.Habilidade;
import Habilidades.HabilidadeDanoCura;
import Leitores.EscritaJson;
import Leitores.LeitorGeral;
import Personagem.Personagem;
import Personagem.Player;

import java.util.List;

/**
 * Classe que define os métodos da saída no terminal da interface de usuário
 */
public class UI {
    private int iterador;
    /**
     * Método que realiza a saída dos status de um personagem
     * @author Marcos França
     * @param personagem É o objeto que define o Personagem que o método irá apresentar os stats, como vida e defesa
     */
    public void personagemStats(Personagem personagem) {
        System.out.printf("{Nome: " + personagem.getNome() + " | Vida: %.2f /" + personagem.getVidaMax() + " | Defesa: " + personagem.getDefesa() + " | Agilidade: " + personagem.getAgilidade() + " | Tipo: " + personagem.getTipo() + "}\n", personagem.getVidaAtual());
    }
    /**
     * É o método que realiza a saida das habilidades de um personagem e uma mensagem para escolher uma delas
     * @author Marcos França
     * @param personagem É o objeto que define o Personagem que o método irá apresentar as habilidades
     */
    public void escolherHabilidades(Personagem personagem) {
        iterador = 1;
        System.out.println();
        System.out.println(personagem.getNome() + ", escolha uma de suas habilidades...");
        for(Habilidade elementos : personagem.getHabilidades()) {
            if(elementos.getClass() == HabilidadeDanoCura.class) {
                System.out.printf("[" + iterador + "] " + elementos.getNome() + " (Valor da habilidade: %.2f) (Usos: " + ((HabilidadeDanoCura) personagem.getHabilidades().get(iterador - 1)).getQntHab() + ")\n", (((HabilidadeDanoCura) (elementos)).getValor()) * personagem.getMultDano());
            } else if(elementos.getClass() == BuffDebuffDano.class) {
                System.out.printf("[" + iterador + "] " + elementos.getNome() + " (Valor do multiplicador: %.2f) (Usos: " + ((HabilidadeBuffDebuff) personagem.getHabilidades().get(iterador - 1)).getQntdHab() + ")\n",((BuffDebuffDano) (elementos)).getMultiplicador());
            } else if(elementos.getClass() == QuantAtaques.class) {
                System.out.println("[" + iterador + "] " + elementos.getNome() + " (Valor da habilidade: +2) (Usos: " + ((HabilidadeBuffDebuff) personagem.getHabilidades().get(iterador - 1)).getQntdHab() + ")");
            }
            iterador++;
        }
    }
    /**
     * É o método que realiza a saida das habilidades de um NPC que podem ser absorvidas
     * @author Marcos França
     * @param player É o objeto que define o Personagem que o método irá dar uma habilidade absorvida
     * @param npc É o objeto que define o NPC que uma habilidade será absorvida
     */
    public void absorverHabilidade(Personagem player, Personagem npc) {
        iterador = 1;
        System.out.println("*** " + npc.getNome() + " foi derrotado por " + player.getNome() + " ***");
        System.out.println("Escolha uma das habilidades de " + npc.getNome() + " para ser sua (0 - editar atributos)");
        for(Habilidade elementos : npc.getHabilidades()) {
            System.out.println("[" + iterador + "] " + elementos.getNome());
            iterador++;
        }
        System.out.println();
    }

    /**
     * Metodo para dar saida das mensagens de melhoria de atributos
     * @author Marcos França
     */
    public void editarAtributos() {
        System.out.println("Escolha um de seus atributos para melhorar");
        System.out.println("[1] Agilidade\n[2] Defesa\n[3] Recarregar as habilidades em 5\n");
    }

    /**
     * Metodo para mostrar a mensagem de derrota de um player
     * @author Marcos França
     * @param player Objeto do player que perdeu
     * @param TemHabilidade Booleano para dizer se um player tem habilidades ainda
     * @param winstreak Receve o valor da quantidade de vitorias de um player
     */
    public void perdeu(Personagem player, boolean TemHabilidade, int winstreak) {
        if(!TemHabilidade) {
            System.out.println("Suas habilidades acabaram e você não consegue mais prosseguir.");
            player.setVidaAtual(0);
        }
        ((Player) player).setWinStreak(winstreak);
        System.out.println("Você perdeu com uma winstreak de: " + ((Player) player).getWinStreak());
        List<Personagem> save = LeitorGeral.PersonagensGerais();
        EscritaJson.SalvaPersonagem(save , player);
    }

    public void venceu(Personagem player){
        System.out.println("Meus parabens...");
        System.out.println("VOCE VENCEU O TERMINAL BATTLE");
        List<Personagem> save = LeitorGeral.PersonagensGerais();
        EscritaJson.SalvaPersonagem(save , player);
    }

    /**
     * Metodo para limpar a tela do terminal
     * @author Marcos França
     */
    public void limpar() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("Erro ao limpar o terminal: " + e.getMessage());
        }
    }
}
