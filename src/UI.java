import Habilidades.Habilidade;
import Habilidades.HabilidadeDanoCura;
import Personagem.Personagem;

public class UI {
    private int iterador;
    public void personagemStats(Personagem personagem) {
        System.out.printf("{Nome: " + personagem.getNome() + " | Vida: %.2f /" + personagem.getVidaMax() + " | Defesa: " + personagem.getDefesa() + " | Agilidade: " + personagem.getAgilidade() + " | Tipo: " + personagem.getTipo() + "}\n", personagem.getVidaAtual());
        System.out.println();
    }

    public void escolherHabilidades(Personagem personagem) {
        iterador = 1;
        System.out.println();
        System.out.println(personagem.getNome() + ", escolha uma de suas habilidades...");
        for(Habilidade elementos : personagem.getHabilidades()) {
            System.out.printf("[" + iterador + "] " + elementos.getNome() + " (Valor da habilidade: %.2f) (Usos: " + ((HabilidadeDanoCura) personagem.getHabilidades().get(iterador - 1)).getQntdHab() + ")\n",((HabilidadeDanoCura) (elementos)).getDano());
            iterador++;
        }
    }

    public void absorverHabilidade(Personagem player, Personagem npc) {
        iterador = 1;
        System.out.println(npc.getNome() + " foi derrotado por " + player.getNome());
        System.out.println("Escolha uma das habilidades de " + npc.getNome() + " para ser sua (0 - editar atributos)");
        for(Habilidade elementos : npc.getHabilidades()) {
            System.out.println("[" + iterador + "] " + elementos.getNome());
            iterador++;
        }
        System.out.println();
    }

    public void perdeu() {
        // mensagem de perder o jogo
    }
}
