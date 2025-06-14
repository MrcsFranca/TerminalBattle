import Habilidades.Buff.BuffDebuffDano;
import Habilidades.Buff.HabilidadeBuffDebuff;
import Habilidades.Buff.QuantAtaques;
import Habilidades.Habilidade;
import Habilidades.HabilidadeDanoCura;
import Personagem.Personagem;
import Personagem.Player;

public class UI {
    private int iterador;
    public void personagemStats(Personagem personagem) {
        System.out.printf("{Nome: " + personagem.getNome() + " | Vida: %.2f /" + personagem.getVidaMax() + " | Defesa: " + personagem.getDefesa() + " | Agilidade: " + personagem.getAgilidade() + " | Tipo: " + personagem.getTipo() + "}\n", personagem.getVidaAtual());
    }

    public void escolherHabilidades(Personagem personagem) {
        iterador = 1;
        System.out.println();
        System.out.println(personagem.getNome() + ", escolha uma de suas habilidades...");
        for(Habilidade elementos : personagem.getHabilidades()) {
            if(elementos.getClass() == HabilidadeDanoCura.class) {
                System.out.printf("[" + iterador + "] " + elementos.getNome() + " (Valor da habilidade: %.2f) (Usos: " + ((HabilidadeDanoCura) personagem.getHabilidades().get(iterador - 1)).getQntdHab() + ")\n", (((HabilidadeDanoCura) (elementos)).getDano()) * personagem.getMultDano());
            } else if(elementos.getClass() == BuffDebuffDano.class) {
                System.out.printf("[" + iterador + "] " + elementos.getNome() + " (Valor do multiplicador: %.2f) (Usos: " + ((HabilidadeBuffDebuff) personagem.getHabilidades().get(iterador - 1)).getQntdHab() + ")\n",((BuffDebuffDano) (elementos)).getMultiplicador());
            } else if(elementos.getClass() == QuantAtaques.class) {
                System.out.println("[" + iterador + "] " + elementos.getNome() + " (Valor da habilidade: +2) (Usos: " + ((HabilidadeBuffDebuff) personagem.getHabilidades().get(iterador - 1)).getQntdHab() + ")");
            }
            iterador++;
        }
    }

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

    public void editarAtributos() {
        System.out.println("Escolha um de seus atributos para melhorar");
        System.out.println("[1] Agilidade\n[2] Defesa\n[3] Recarregar as habilidades em 5\n");
    }

    public void perdeu(Personagem player, boolean TemHabilidade, int winstreak) {
        if(!TemHabilidade) {
            System.out.println("Suas habilidades acabaram e você não consegue mais prosseguir.");
            player.setVidaAtual(0);
        }
        ((Player) player).setWinStreak(winstreak);
        System.out.println("Você perdeu com uma winstreak de: " + ((Player) player).getWinStreak());
    }

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
