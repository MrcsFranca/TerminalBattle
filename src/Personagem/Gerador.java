package Personagem;

import Habilidades.*;

import Leitores.LeitorGeral;

import java.util.*;

/**
 * Classe que gera os atributos dos personagens que serao usados no jogo
 */
public class Gerador {
    private List<Personagem> personagems = LeitorGeral.PersonagensGerais();
    /**
     * Classe que gera um objeto de um personagem jogavel
     * @author Marcos França
     * @return retorna um objeto de um Personagem jogavel
     */
    public Personagem geraPlayer() {
        String nome;
        System.out.print("Entre com o nome do jogador: ");
        Scanner scanner = new Scanner(System.in);
        nome = scanner.nextLine();

        Habilidade hab1 = LeitorGeral.getHabFromJson("Fireball"),
                   hab2 = LeitorGeral.getHabFromJson("DeepBreath"),
                   hab3 = LeitorGeral.getHabFromJson("Bite");

        ArrayList<Habilidade> habilidade = new ArrayList<Habilidade>();
        habilidade.add(hab1);
        habilidade.add(hab2);
        habilidade.add(hab3);

        return new Player(nome, 50, 5, 5, 5, 50.0, 1.0, 1.0, 1.0, habilidade, TipoHabilidade.normal, false,false, 0);
    }
    /**
     * Classe que gera um objeto de um personagem NPC
     * @author Marcos França
     * @return retorna um objeto de um Personagem NPC lido dos arquivos
     */
    public Personagem geraNPC() {
        Random R = new Random();
        return personagems.get(R.nextInt(personagems.size()));
    }


}
